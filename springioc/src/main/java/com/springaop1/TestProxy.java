package com.springaop1;

import com.springaop1.dao.Dao;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

public class TestProxy {
    public static void main(String[] args) throws Exception {
        Class<?>[] interfaces = new Class[]{Dao.class};
        byte[] testproxies = ProxyGenerator.generateProxyClass("GeneratorProxy", interfaces);
        File file = new File("D:/GeneratorProxy.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(testproxies);
        fos.flush();
        fos.close();
    }
}
