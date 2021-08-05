package com.example.calculator;

public class Order {
    private String exp_index;
    private String exp_formula;
    private String exp_expectvalue;
    private String exp_result;
    private boolean exp_ispass;

    public Order(String exp_index, String exp_formula, String exp_expectvalue, String exp_result, boolean exp_ispass) {
        this.exp_index = exp_index;
        this.exp_formula = exp_formula;
        this.exp_expectvalue = exp_expectvalue;
        this.exp_result = exp_result;
        this.exp_ispass = exp_ispass;
    }

    public String getExp_index() {
        return exp_index;
    }

    public void setExp_index(String exp_index) {
        this.exp_index = exp_index;
    }

    public String getExp_formula() {
        return exp_formula;
    }

    public void setExp_formula(String exp_formula) {
        this.exp_formula = exp_formula;
    }

    public String getExp_expectvalue() {
        return exp_expectvalue;
    }

    public void setExp_expectvalue(String exp_expectvalue) {
        this.exp_expectvalue = exp_expectvalue;
    }

    public String getExp_result() {
        return exp_result;
    }

    public void setExp_result(String exp_result) {
        this.exp_result = exp_result;
    }

    public boolean isExp_ispass() {
        return exp_ispass;
    }

    public void setExp_ispass(boolean exp_ispass) {
        this.exp_ispass = exp_ispass;
    }

}
