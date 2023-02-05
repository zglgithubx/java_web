package com.example.view.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyTest {
    public static void main(String[] args){
        Lenovo lenovo=new Lenovo();
        /**
         * 三个参数:
         * 1.类加载器:真实对象.个体Class().getClassLoader()
         * 2.接口数组:真实对象.getClass().getInterface()
         * 3.处理器:new InvocationHandler()
         */
        /**
         * sa_le为代理对象和真实对象没有区别
         */
        Sale sa_le=(Sale)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * 代理逻辑编写的方法:代理对象调用的所有方法都会出发该方法执行
                 * 参数:
                 * 1.proxy:代理对象
                 * 2.method:代理对象调用的方法,被封装为的对象
                 * 3.args:代理对象调用的方法时,传递的实际参数
                 */
//                判断是否有参数
                if(method.getName().equals("sale")){
                    //1.增强参数
                     double money=(double) args[0];
                     money=money*0.85;
                     String obj=(String) method.invoke(lenovo,money);
                     //2.增强返回值
                    return obj+"_鼠标垫";

                }else{
                    Object obj=method.invoke(lenovo,args);
                    return  obj;
                }
            }
        });
        String computer=sa_le.sale(8000);
        System.out.println(computer);
    }
}
