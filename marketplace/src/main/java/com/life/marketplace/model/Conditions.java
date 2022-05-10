package com.life.marketplace.model;


import java.util.ArrayList;

public class Conditions {

  private ArrayList<String> conditions = new ArrayList<>();


  public ArrayList<String> getConditions() {
    return conditions;
  }


  public void addCondition(String Condition) {
    conditions.add(Condition);
  }
  public void removeCondition(String Condition){conditions.remove(Condition);}


}
