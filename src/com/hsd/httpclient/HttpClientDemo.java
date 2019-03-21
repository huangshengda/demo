package com.hsd.httpclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientDemo {

//	private static final String url = "http://localhost/index.html";
//	private static final String URL = "http://search.m.yhd.com/statics/mglobal/js/common/redirect.js";
	private static final String URL3 = "http://search.yhd.com/statics/global/css/global_site_search.css?1200";
	private static final String URL1 = "http://search.yhd.com/c0-0/k%25E7%2589%259B%25E5%25A5%25B61/";
//	private static final String URL_fav = "http://search.m.yhd.com/favicon.ico";
	
	
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			new Thread(getRunnable(i + ":",URL1)).start();
//			new Thread(getRunnable(i + "URL_fav:",URL_fav)).start();
//			new Thread(getRunnable(i + "@@@:",URL3)).start();
			Thread.sleep(100);
		}
	}

	private static Runnable getRunnable(final String threadName,final String url) {
		return new Runnable() {
			public void run() {
				HttpGet httpGet = new HttpGet(url);
				CloseableHttpClient client = HttpClients.createDefault();
				CloseableHttpResponse execute = null;
				try {
					execute = client.execute(httpGet);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int statusCode = execute.getStatusLine().getStatusCode();
				System.out.println(threadName + ":" + statusCode);
			}
		};
	}
}
