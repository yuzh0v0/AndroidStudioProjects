package com.example.calculator;

import org.litepal.crud.LitePalSupport;

public class TestCase extends LitePalSupport{
    private int id;
    private String formulas;
    private String expectedValue;
    private String realResult;
    private boolean ispass;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFormulas(){
        return formulas;
    }
    public void setFormulas(String formulas){
        this.formulas = formulas;
    }
    public String getExpectedValue(){
        return expectedValue;
    }
    public void setExpectedValue(String expectedValue){
        this.expectedValue = expectedValue;
    }
    public String getRealResult(){
        return realResult;
    }
    public void setRealResult(String realResult) {
        this.realResult = realResult;
    }
    public boolean getIsPass(){
        return ispass;
    }
    public void setIspass(boolean ispass){
        this.ispass=ispass;
    }
}
