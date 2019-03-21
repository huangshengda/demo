package main.com.hsd.vm;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/12/24
 */
public class JVMHook1 {/**
 * Runtime.getRuntime().addShutdownHook(shutdownHook);
 * <p>
 * 这个方法的意思就是在jvm中增加一个关闭的钩子，当jvm关闭的时候，会执行系统中已经设置的所有通过方法addShutdownHook添加的钩子，
 * 当系统执行完这些钩子后，jvm才会关闭。所以这些钩子可以在jvm关闭的时候进行内存清理、对象销毁等操作。
 * </p>
 * 用途１:应用程序正常退出，在退出时执行特定的业务逻辑，或者关闭资源等操作。
 */
    public static void start() {
        System.out.println("The JVM is started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    // do something
                    System.out.println("The JVM Hook is execute");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        start();

        System.out.println("The Application is doing something");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ///Thread.sleep(Integer.MAX_VALUE);
    }
}
