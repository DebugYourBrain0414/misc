package com.practice.dynamicproxy;

public class GreetingsProxy implements Greetings {
  private GreetingsTarget greetingsTarget;
  
  public GreetingsProxy(GreetingsTarget greetingsTarget) {
    this.greetingsTarget = greetingsTarget;
  }
  
  public String sayHappyNewYear(String name) {
    return greetingsTarget.sayHappyNewYear(name).toUpperCase();
  }

  public String sayHappyBirthday(String name) {
    return greetingsTarget.sayHappyBirthday(name);
  }

  public String sayHappyEaster(String name) {
    return greetingsTarget.sayHappyEaster(name);
  }

}
