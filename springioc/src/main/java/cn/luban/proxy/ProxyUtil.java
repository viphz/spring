package cn.luban.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {
    public static Object newInstance(Object target){
        Object proxy=null;
        Class targetInf = target.getClass().getInterfaces()[0];
        Method methods[] =targetInf.getDeclaredMethods();
        String line="\n";
        String tab ="\t";
        String infName = targetInf.getSimpleName();
        String content ="";
        String packageContent = "package com.google;"+line;
        String importContent = "import "+targetInf.getName()+";"+line;
        String clazzFirstLineContent = "public class $Proxy implements "+infName+"{"+line;
        String filedContent  =      tab+"private "+infName+" target;"+line;//定义变量
        String constructorContent = tab+"public $Proxy ("+infName+" target){" +line
                                    +tab+tab+"this.target =target;"
                                    +line+tab+"}"+line;//定义构造函数
        String methodContent = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName =method.getName();
            // Sting.class String.class
            Class args[] = method.getParameterTypes();
            String argsContent = "";//参数列表
            String paramsContent="";
            int flag =0;
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                //String p0,Sting p1,
                argsContent+=temp+" p"+flag+",";
                paramsContent+="p"+flag+",";
                flag++;
            }
            if (argsContent.length()>0){
                argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
            }
            //定义方法
            methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+") {"+line
                          +tab+tab+"System.out.println(\"log\");"+line;
            if("void".equals(returnTypeName)){
                methodContent +=tab+tab+"target."+methodName+"("+paramsContent+");"+line  //调用原方法带参数
                        +tab+"}"+line;
            } else {
                methodContent +=tab+tab+"return target."+methodName+"("+paramsContent+");"+line  //调用原方法带参数
                        +tab+"}"+line;
            }
        }
        content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";
        //通过io得到java文件
        File file =new File("d:\\com\\google\\$Proxy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
            //编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            //创建对象，但是class文件在工程外部不能使用反射，通过URLClassLoader引入网络上的类
            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");
            Constructor constructor = clazz.getConstructor(targetInf);
            proxy = constructor.newInstance(target);
            //clazz.newInstance();//创建实例，但构造函数中有参数不能直接调用午餐构造函数
            //Class.forName()//反射生成Class对象，但是类不在当前工程中
        }catch (Exception e){
            e.printStackTrace();
        }
        return proxy;
    }
}
