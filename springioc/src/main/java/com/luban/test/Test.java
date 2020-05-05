package com.luban.test;

import com.luban.dao.LubanDao;
import com.luban.dao.LubanDaoImpl;
import com.luban.proxy.ProxyUtil;
import com.luban.customer.TestCustomHandler;
import com.luban.util.LubanInvocationHandler;

import java.lang.reflect.Proxy;


public class Test {
    public static void main(String[] args) {
        LubanDao proxy = (LubanDao) ProxyUtil.newInstance(LubanDao.class,new TestCustomHandler(new LubanDaoImpl()));
        try {
//            proxy.proxy();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        byte[] bytes=ProxyGenerator.generateProxyClass("$Proxy18",new Class[]{LubanDao.class});
//
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("d:\\$Proxy18.class");
//            fileOutputStream.write(bytes);
//            fileOutputStream.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //        System.out.println(proxy.proxy());
        /**
         * 参数1：ClassLoader loader ，类加载器，
         *      方式一：通过当前类获得，当前类.class.getClassLoader();
         *      方式二：通过目标类获得，目标类实例.getClass().getClassLoader();
         * 参数2：Class[] interfaces ，代理类需要实现的所有接口
         *      方式一：目标类实例.getClass().getInterfaces();
         *      方式二：new Class[]{UserService.class};
         * 参数3：InvocationHandler h，接口的代理逻辑，由于接口LubanDao有很多需要代理的目标对象，所以要指定需要代理的目标对象LubanDaoImpl
         *      方式一：采用匿名内部类
         *      方式二：传入实例化对象
         */
        LubanDao jdkproxy = (LubanDao) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{LubanDao.class},new LubanInvocationHandler(new LubanDaoImpl()));
        try {
            System.out.println(jdkproxy.proxy());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
