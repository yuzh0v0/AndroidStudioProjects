package com.example.calculator;

import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Support extends AppCompatActivity {
    
    private final String init_String= "";
    private long mExitTime = 0;

    //judge last input whether is operator + -
    public boolean checkaddsub(String str){
        return str.endsWith("+") || str.endsWith("-");
    }
    
    //judge last input whether is operator * /
    public boolean checkmultidiv(String str){
        return str.endsWith("*") || str.endsWith("/");
    }
    
    //judge last input whether is operator
    public boolean checkLastSym(String str){
        return checkaddsub(str) || checkmultidiv(str);
    }
    
    //judge last input whether is operand
    public boolean checkLastNum(String str){
        char [] chara = str.toCharArray();
        return chara[str.length() - 1] >= '0' && chara[str.length() - 1] <= '9';
    }
    
    //judge last input whether is initialized 0
    public  boolean checkInit(String str){
        return str.endsWith("0") && str.length() == 1;
    }
    
    //judge last input whether is 0 after operator
    public  boolean checkZero(String str){
        String tempstr = str.substring(0,str.length()-1);
        return str.endsWith("0") && checkLastSym(tempstr);
    }
    
    //judge last input whether is LBracket
    public  boolean checkLBracket(String str){
        return str.endsWith("(");
    }
    
    //judge last input whether is RBracket
    public  boolean checkRBracket(String str){
        return str.endsWith(")");
    }

    //judge last input whether is point
    public  boolean checkPoint(String str){
        return str.endsWith(".");
    }

    //find last operator
    public int Last_operator(String str){
        int addIndex = str.lastIndexOf("+");
        int subIndex = str.lastIndexOf("-");
        int multiIndex = str.lastIndexOf("*");
        int divIndex = str.lastIndexOf("/");
        int pointIndex = str.lastIndexOf(".");
        if(pointIndex>addIndex&&pointIndex>subIndex&&pointIndex>multiIndex&&pointIndex>divIndex){
            return -2;
        }else {
            int[] a=new int[]{addIndex,subIndex,multiIndex,divIndex};
            Arrays.sort(a);
            return a[3];
        }
    }

    //supplementary closing bracket
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

    //Judge whether there is only operator in ()
    public boolean checkspe(String str){
        int addIndex = str.lastIndexOf("(+)");
        int subIndex = str.lastIndexOf("(-)");
        int multiIndex = str.lastIndexOf("(*)");
        int divIndex = str.lastIndexOf("(/)");
        int pointIndex = str.lastIndexOf("(.)");
        int bracket = str.lastIndexOf("()");
        return addIndex != -1 || subIndex != -1 || multiIndex != -1 || divIndex != -1 || pointIndex != -1 || bracket != -1 ;
    }

    //judge whether is exception info
    public boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(cardNum);
        return !m.matches();
    }

    //settle operator input
    public ArrayList<String> setOperator(String str_show, String operator, String str_hide){
        Log.d("Main", "press "+operator);
        String warnInfo = init_String;
        if (checkLastSym(str_show) || checkPoint(str_show)){
            str_show = str_show.substring(0,str_show.length()-1)+operator;
            str_hide = str_show.substring(0,str_show.length()-1)+operator;
        }else if (checkLBracket(str_show)){
            warnInfo = "WARNING：缺少左操作数";
            switch (operator) {
                case "+":
                    str_hide = str_hide + "0" + operator;
                    str_show = str_show + operator;
                    break;
                case "-":
                    str_hide = str_hide + "0" + operator;
                    str_show = str_show + operator;
                    warnInfo = init_String;
                    break;
                case "*":
                case "/":
                    str_hide = str_hide + "1" + operator;
                    str_show = str_show + operator;
                    break;
            }
        }else {
            str_show = str_show + operator;
            str_hide = str_hide + operator;
        }
        ArrayList<String> setOperatorlist = new ArrayList<>();
        setOperatorlist.add(str_hide);
        setOperatorlist.add(str_show);
        setOperatorlist.add(warnInfo);
        return setOperatorlist;
    }
    //settle operand input
    public ArrayList<String> setOperand(String str_show, String operand, String str_hide){
        Log.d("Main", "press "+operand);
        String warnInfo = init_String;
        if(checkInit(str_show)) {
            str_show = operand;
            str_hide = operand;
        }else if(checkRBracket(str_show)){
            str_hide = str_hide + "*" + operand;
            str_show = str_show + operand;
            warnInfo = "缺少操作符";
        }else if(checkZero(str_show)){
            Log.d("Main","reject input");
        }else {
            str_show = str_show + operand;
            str_hide = str_hide + operand;
        }
        ArrayList<String> setOperandlist = new ArrayList<>();
        setOperandlist.add(str_hide);
        setOperandlist.add(str_show);
        setOperandlist.add(warnInfo);
        return setOperandlist;
    }

    //exit app delay
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if((System.currentTimeMillis() - mExitTime)>2000){
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                mExitTime =System.currentTimeMillis();
            }else {
                finish();
            }
            return true;
        }
        return  super.onKeyDown(keyCode,event);
    }
}
