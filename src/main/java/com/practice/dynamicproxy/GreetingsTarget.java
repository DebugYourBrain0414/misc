package com.practice.dynamicproxy;

public class GreetingsTarget implements Greetings {

  public String sayHappyNewYear(String name) {
    return name.concat("! happy new year!");
  }

  public String sayHappyBirthday(String name) {
    return name.concat("! happy birthday!");
  }

  public String sayHappyEaster(String name) {
    return name.concat("! happy easter!");
  }

}
