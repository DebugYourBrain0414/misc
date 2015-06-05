package com.practice.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GreetingsDynamicHandler implements InvocationHandler {
  private Greetings greetings;
  
  public GreetingsDynamicHandler (Greetings greetings) {
    this.greetings = greetings;
  }
  
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("*****(DyanamicProxy) Proxy class name *****"+proxy.getClass().getName());
    System.out.println("*****(DyanamicProxy) Method name *****"+method.getName());
    System.out.println("*****(DyanamicProxy) Method info *****"+method.toGenericString());
    for (Object arg : args) {
      System.out.println("*****(DyanamicProxy) Args name *****"+arg.getClass().getName());
    }
    
    String result = (String) method.invoke(greetings, args);
    if (method.getName().equals("sayHappyBirthday")) result = result.toUpperCase();
    return result;
  }

}
