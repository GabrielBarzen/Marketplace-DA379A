package com.life.marketplace.model;


import java.util.ArrayList;

public class Colors {

  private ArrayList<String> colors = new ArrayList<String>();


  public ArrayList<String> getColors() {
    return colors;
  }

  public void addColors(String color) {
    colors.add(color);
  }
  public void removeColors(String color){colors.remove(color);}
}
