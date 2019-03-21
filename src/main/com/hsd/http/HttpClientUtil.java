package main.com.hsd.http;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.apache.http.conn.socket.PlainConnectionSocketFactory.*;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/12/21
 */
public class HttpClientUtil {

    /**
     * @param url
     * @return
     * @Description: get请求
     * @author huangshengda
     * @version 1.0
     */
    public static String get(String url) {

        String responseContent = null;
        CloseableHttpClient httpclient = null;
        // 采用绕过验证的方式处理https请求
        try {
            httpclient = getHttpClient();
            // 创建httpget
            HttpGet httpGet = new HttpGet(url);
            // 执行get请求
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                if (entity != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    // 打印响应内容
                    responseContent = EntityUtils.toString(entity, Consts.UTF_8);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }
        return responseContent;
    }

    /**
     * @param url
     * @param params
     * @return
     * @Description: post请求
     * @author huangshengda
     * @version 1.0
     */
    public static String post(String url, Map<String, String> params) {

        String responseContent = null;
        CloseableHttpClient httpclient = null;
        // 采用绕过验证的方式处理https请求
        try {
            httpclient = getHttpClient();
            // 创建httppost
            HttpPost httppost = new HttpPost(url);

            // 创建参数队列
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();

            Set<Map.Entry<String, String>> entrys = params.entrySet();
            for (Map.Entry<String, String> entry : entrys) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                if (entity != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    // 打印响应内容
                    responseContent = EntityUtils.toString(entity, Consts.UTF_8);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }
        return responseContent;
    }

    private static CloseableHttpClient getHttpClient() {
        try {
            // 全部信任 不做身份鉴定
            SSLContextBuilder builder = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            });
            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", INSTANCE).register("https", new SSLConnectionSocketFactory(builder.build())).build();
            HttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            return HttpClients.custom().setConnectionManager(connManager).build();
        } catch (Exception e) {
        }
        return HttpClients.createDefault();
    }

    public static void main(String[] args){

        System.out.println(get("http://www.baidu.com"));
    }


    /*public static boolean downloadFile(String url, String destFileName) {
        CloseableHttpClient httpclient = null;
        InputStream in = null;
        boolean flag = true;
        try {
            // 生成一个httpclient对象
            httpclient = getHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            in = entity.getContent();
            File file = new File(destFileName);
            FileOutputStream fout = new FileOutputStream(file);
            int l = -1;
            byte[] tmp = new byte[1024];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l);
                // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
            }
            fout.flush();
            fout.close();
        } catch (Exception e) {
            flag = false;
            LOG.error("", e);
        } finally {
            // 关闭低层流。
            try {
                in.close();
                httpclient.close();
            } catch (IOException e) {
            }
        }
        return flag;
    }

    public static Upload2ResServerRet uploadFile(String url, String fileName) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        Upload2ResServerRet upload2ResServerRet = new Upload2ResServerRet(false, 1, "上传失败");
        try {
            httpclient = getHttpClient();
            // 要上传的文件的路径
            String filePath = new String(fileName);
            // 把一个普通参数和文件上传给下面这个地址 是一个servlet
            HttpPost httpPost = new HttpPost(url);
            // 把文件转换成流对象FileBody
            File file = new File(filePath);
            FileBody bin = new FileBody(file);
            StringBody uploadFileName = new StringBody("把我修改成文件名称", ContentType.create("text/plain", Consts.UTF_8));
            // 以浏览器兼容模式运行，防止文件名乱码。
            HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).addPart("uploadFile", bin) // uploadFile对应服务端类的同名属性<File类型>
                    .addPart("uploadFileName", uploadFileName)// uploadFileName对应服务端类的同名属性<String类型>
                    .setCharset(CharsetUtils.get("UTF-8")).build();

            httpPost.setEntity(reqEntity);
            // 发起请求 并返回请求的响应
            response = httpclient.execute(httpPost);
            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                // 打印响应内容
                String str = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
                LOG.info(str);
                upload2ResServerRet = JSONObject.parseObject(str, Upload2ResServerRet.class);
            }
            // 销毁
            EntityUtils.consume(resEntity);
        } catch (Exception e) {
            LOG.error("", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (Exception e) {
                LOG.error("", e);
            }
        }
        return upload2ResServerRet;
    }*/
}
