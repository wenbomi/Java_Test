package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName proxyTest
 * @Author Xiao Mi
 * @Date 2023/1/6 10:29
 * 简介：
 */
public class proxyTest {
    public static void main(String[] args) {
        //1. 创建真实对象
        Apple apple = new Apple();

        //2. 动态代理增强apple对象
        /**
         * 三个参数
         1. 类加载器： 真实对象.getClass().getClassLoader()
         2. 接口数组：真实对象.getClass().getInterfaces()
         3. 处理器： new InvocationHandler()
         */
        saleComputer proxy_apple = (saleComputer) Proxy.newProxyInstance(apple.getClass().getClassLoader(),
                apple.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                        代码逻辑编写方法，代理对象调用的所有方法都会触发该方法的执行
                        参数：
                            1. proxy:  代理对象 一般不使用
                            2. method: 代理对象调用的方法，将方法封装成对象
                            3. args：  代理对象调用方法时，传递的实际参数
                     */

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("该方法被执行了....");
//                        System.out.println(method.getName());
//                        System.out.println(args[0]);

                        // 判断方法是否是sale
                        if (method.getName().equals("sale")) {
                            //1.增强参数
                            double money = (double) args[0];
                            money *= 0.85;
                            // 3. 增强方法体执行逻辑
                            System.out.println("专车接你到店选购。。。");
                            // 使用真实对象调用方法
                            Object obj = method.invoke(apple, money);
                            System.out.println("专车送货上门。。。");
                            //2.增强返回值
                            return obj + "_LG 4K显示器";
                        } else {
                            Object obj = method.invoke(apple, args);
                            return obj ;
                        }
                    }
                });

        //3. 调用方法
        String mac = proxy_apple.sale(8000);
        System.out.println(mac);

        proxy_apple.show();
    }
}
