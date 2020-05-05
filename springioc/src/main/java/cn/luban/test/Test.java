package cn.luban.test;

import cn.luban.dao.UserDao;
import cn.luban.dao.UserDaoImpl;
import cn.luban.proxy.ProxyUtil;

public class Test {
    public static void main(String[] args) {
        UserDao proxy = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
        proxy.query();
        System.out.println(proxy.query("xx"));
//        HashMap<String, String> hashMap = new HashMap<String, String>();
        //
//        Proxy.newProxyInstance(UserDao.class.getClassLoader(), UserDao.class.getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                return null;
//            }
//        });
    }
}
