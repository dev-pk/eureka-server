package com.hd;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan

public class TestProxyMode {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestProxyMode.class);

        PrototypeBeanFactory factoryBean = context.getBean(PrototypeBeanFactory.class);
        System.out.println("Let's start");
        PrototypeBean b1 = factoryBean.getPrototypeBeanInstance();
        PrototypeBean b2 = factoryBean.getPrototypeBeanInstance();

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());

        b1.sayHello();
        b2.sayHello();

        b1.sayHello();
        b2.sayHello();
    }

    @Component
    public class PrototypeBeanFactory {
        @Lookup
        public PrototypeBean getPrototypeBeanInstance() {
            System.out.println("It'll be ignored");
            return null;
        }
    }

    @Component
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public class PrototypeBean {
        public PrototypeBean() {
            System.out.println("I am created");
        }

        public void sayHello() {
            System.out.println("Hello from " + this.hashCode());
        }

    }

}
