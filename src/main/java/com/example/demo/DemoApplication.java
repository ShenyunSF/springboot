package com.example.demo;

import com.example.demo.springevenshandler.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.example")
public class DemoApplication
{

    public static void main(String[] args)
    {
        /*SpringApplication.run(DemoApplication.class, args);*/
        /*使用AnnotationConfigApplicationContext可以实现基于Java的配置类（包括各种注解）加载Spring的应用上下文。避免使用application
        .xml进行配置。相比XML配置，更加便捷。*/
       /* AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoApplication.class);*/
        // HelloWorld 类要加component注解
        /*HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println( helloWorld.getMessage());*/

        // or can use this get beans from xml
      /*  ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Bean.xml");
        classPathXmlApplicationContext.start();

        HelloWorld helloworld = (HelloWorld) classPathXmlApplicationContext.getBean("helloworld");
        System.out.println( helloworld.getMessage());

        classPathXmlApplicationContext.stop();*/


       /* SpringApplication.run(DemoApplication.class, args);*/
        SpringApplication app = new SpringApplication(DemoApplication.class);
        ConfigurableApplicationContext context02 = app.run(args);
        HelloWorld helloWorld = (HelloWorld) context02.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());

        /*版权声明：本文为CSDN博主「苍鹰蛟龙」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/u010502101/article/details/78817581*/
    }

}
