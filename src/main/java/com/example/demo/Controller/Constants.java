package com.example.demo.Controller;

public class Constants {
  public static int usersSize = 0;

  public static synchronized int addOrGetUsersSize(boolean identity) {
    if (identity) {
      Constants.usersSize = Constants.usersSize + 1;
    }
    return Constants.usersSize;
  }
}
