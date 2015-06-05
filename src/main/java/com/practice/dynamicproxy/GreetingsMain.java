package com.practice.dynamicproxy;

import java.lang.reflect.Proxy;

public class GreetingsMain {
  final static String NAME = "John";
  
  public static void main(String[] args) {
    //normalProxy();
    dynamicProxy();
  }

  private static void dynamicProxy() {
    Greetings greetings = (Greetings)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Greetings.class},
        new GreetingsDynamicHandler(new GreetingsTarget()));
    
    System.out.println("Birthday greeting: "+greetings.sayHappyBirthday(NAME));
    System.out.println("Easter greeting: "+greetings.sayHappyEaster(NAME));
    System.out.println("Newyear greeting: "+greetings.sayHappyNewYear(NAME));
  }

  private static void normalProxy() {
    Greetings greetings = new GreetingsProxy(new GreetingsTarget());
    System.out.println("Birthday greeting: "+greetings.sayHappyBirthday(NAME));
    System.out.println("Easter greeting: "+greetings.sayHappyEaster(NAME));
    System.out.println("Newyear greeting: "+greetings.sayHappyNewYear(NAME));
  }
}
