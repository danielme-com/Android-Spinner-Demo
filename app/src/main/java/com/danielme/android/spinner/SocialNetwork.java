package com.danielme.android.spinner;

public class SocialNetwork {

  private final String name;
  private final int icon;

  public SocialNetwork(String name, int icon) {
    this.name = name;
    this.icon = icon;
  }

  public String getName() {
    return name;
  }

  public int getIcon() {
    return icon;
  }

}
