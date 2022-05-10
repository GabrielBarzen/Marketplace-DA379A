package com.life.marketplace.model;


import java.util.ArrayList;

public class Types {

  private ArrayList<String> types = new ArrayList<>();


  public ArrayList<String> getTypes() {
    return types;
  }

  public void addType(String type) {
    types.add(type);
  }
  public void removeType(String type){types.remove(type);}

}
