package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Support extends AppCompatActivity {

    //检查上一位输入是否为+-运算符
    public boolean checkaddsub(String str){
        return str.endsWith("+") || str.endsWith("-");
    }
    //检查上一位输入是否为*/运算符
//    public boolean checkmultidiv(String str){
//        return str.endsWith("*") || str.endsWith("/");
//    }
    //检查上一位输入是否为+-*/运算符
    public boolean checkLastSym(String str){
        return str.endsWith("+") || str.endsWith("-") || str.endsWith("*") || str.endsWith("/");
    }

    //检查上一位输入是否为数字0-9
    public boolean checkLastNum(String str){
        char [] chara = str.toCharArray();
        return chara[str.length() - 1] >= '0' && chara[str.length() - 1] <= '9';
    }

    //检查上一位输入是否为系统初始化的0
    public  boolean checkInit(String str){
        return str.endsWith("0") && str.length() == 1;
    }

    //检查上一位是否为符号后的0
    public  boolean checkZero(String str){
        String tempstr = str.substring(0,str.length()-1);
        return str.endsWith("0") && checkLastSym(tempstr);
    }

    //检查上一位是否为左括号
    public  boolean checkLBracket(String str){
        return str.endsWith("(");
    }

    //检查上一位是否为右括号
    public  boolean checkRBracket(String str){
        return str.endsWith(")");
    }

    //检查上一位是否为小数点
    public  boolean checkPoint(String str){
        return str.endsWith(".");
    }

    //查找整个字符串最后一个运算符的位置
    public int checksym(String str){
        int addIndex = str.lastIndexOf("+");
        int subIndex = str.lastIndexOf("-");
        int multiIndex = str.lastIndexOf("*");
        int divIndex = str.lastIndexOf("/");
        int pointIndex = str.lastIndexOf(".");
        if(pointIndex>addIndex&&pointIndex>subIndex&&pointIndex>multiIndex&&pointIndex>divIndex){
            // 就是小数
            return -2;
        }else {
            int[] a=new int[]{addIndex,subIndex,multiIndex,divIndex};
            Arrays.sort(a);
            return a[3];
        }
    }

    //补充右括号
    public String addRBracket(String str){
        char[] chars = str.toCharArray();
        int diff = 0;
        for(int i = 0;i<str.length();i++){
            if(chars[i]=='('){
                diff = diff +1;
            }else if (chars[i]==')'){
                diff = diff -1;
            }
        }
        StringBuilder strBuilder = new StringBuilder(str);
        for (int j = 0; j<diff; j++){
            strBuilder.append(")");
        }
        str = strBuilder.toString();
        return str;
    }

    //判断是否有()内只存在操作符的现象
    public boolean checkspe(String str){
        int addIndex = str.lastIndexOf("(+)");
        int subIndex = str.lastIndexOf("(-)");
        int multiIndex = str.lastIndexOf("(*)");
        int divIndex = str.lastIndexOf("(/)");
        int pointIndex = str.lastIndexOf("(.)");
        int bracket = str.lastIndexOf("()");
        return addIndex != -1 || subIndex != -1 || multiIndex != -1 || divIndex != -1 || pointIndex != -1 || bracket != -1 ;

    }

    //格式化结果
    public boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(cardNum);
        return !m.matches();
    }
    
    //另一种格式化方法
//    public boolean judgeContains(String str) {
//        return str.startsWith("ERROR");
//    }
}
