package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Support support = new Support();

    String InputString ="";
    String Calculate_Symbol = "";
    String ResultString = "";
    String init_Value = "0";
    String init_String = "";
    String real_input = "";
    String warning_info = "";
    private long mExitTime = 0;
    private TextView inputText,symbolView,inputTextView,resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        inputText = findViewById(R.id.initialinput);
        symbolView = findViewById(R.id.symbolView);
        inputTextView = findViewById(R.id.inputTextView);
        resultView = findViewById(R.id.resultView);

        Button chip_totest = findViewById(R.id.chip_topg2);
        Button button_num_1 = findViewById(R.id.button_1);
        Button button_num_2 = findViewById(R.id.button_2);
        Button button_num_3 = findViewById(R.id.button_3);
        Button button_num_4 = findViewById(R.id.button_4);
        Button button_num_5 = findViewById(R.id.button_5);
        Button button_num_6 = findViewById(R.id.button_6);
        Button button_num_7 = findViewById(R.id.button_7);
        Button button_num_8 = findViewById(R.id.button_8);
        Button button_num_9 = findViewById(R.id.button_9);
        Button button_num_0 = findViewById(R.id.button_10);
        Button button_add = findViewById(R.id.button_11);
        Button button_multi = findViewById(R.id.button_12);
        Button button_bracket_l = findViewById(R.id.button_13);
        Button button_del = findViewById(R.id.button_14);
        Button button_clr = findViewById(R.id.button_15);
        Button button_sub = findViewById(R.id.button_16);
        Button button_div = findViewById(R.id.button_17);
        Button button_bracket_r = findViewById(R.id.button_18);
        Button button_point = findViewById(R.id.button_19);
        Button button_equal = findViewById(R.id.button_20);

        button_num_1.setOnClickListener(this);
        button_num_2.setOnClickListener(this);
        button_num_3.setOnClickListener(this);
        button_num_4.setOnClickListener(this);
        button_num_5.setOnClickListener(this);
        button_num_6.setOnClickListener(this);
        button_num_7.setOnClickListener(this);
        button_num_8.setOnClickListener(this);
        button_num_9.setOnClickListener(this);
        button_num_0.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_multi.setOnClickListener(this);
        button_bracket_l.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_clr.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_bracket_r.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_equal.setOnClickListener(this);


        chip_totest.setOnClickListener(this);
        InputString = init_Value;
        inputText.setText(InputString);
        real_input = InputString;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        if(InputString.length()<=50){
            switch (v.getId()){
                //1
                case R.id.button_1:
                    ArrayList<String> objectnum_1 = setOperand(InputString, "1", real_input, warning_info);
                    real_input = objectnum_1.get(0);
                    InputString = objectnum_1.get(1);
                    warning_info = objectnum_1.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //2
                case R.id.button_2:
                    ArrayList<String> objectnum_2 = setOperand(InputString, "2", real_input, warning_info);
                    real_input = objectnum_2.get(0);
                    InputString = objectnum_2.get(1);
                    warning_info = objectnum_2.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //3
                case R.id.button_3:
                    ArrayList<String> objectnum_3 = setOperand(InputString, "3", real_input, warning_info);
                    real_input = objectnum_3.get(0);
                    InputString = objectnum_3.get(1);
                    warning_info = objectnum_3.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //4
                case R.id.button_4:
                    ArrayList<String> objectnum_4 = setOperand(InputString, "4", real_input, warning_info);
                    real_input = objectnum_4.get(0);
                    InputString = objectnum_4.get(1);
                    warning_info = objectnum_4.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //5
                case R.id.button_5:
                    ArrayList<String> objectnum_5 = setOperand(InputString, "5", real_input, warning_info);
                    real_input = objectnum_5.get(0);
                    InputString = objectnum_5.get(1);
                    warning_info = objectnum_5.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //6
                case R.id.button_6:
                    ArrayList<String> objectnum_6 = setOperand(InputString, "6", real_input, warning_info);
                    real_input = objectnum_6.get(0);
                    InputString = objectnum_6.get(1);
                    warning_info = objectnum_6.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //7
                case R.id.button_7:
                    ArrayList<String> objectnum_7 = setOperand(InputString, "7", real_input, warning_info);
                    real_input = objectnum_7.get(0);
                    InputString = objectnum_7.get(1);
                    warning_info = objectnum_7.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //8
                case R.id.button_8:
                    ArrayList<String> objectnum_8 = setOperand(InputString, "8", real_input, warning_info);
                    real_input = objectnum_8.get(0);
                    InputString = objectnum_8.get(1);
                    warning_info = objectnum_8.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //9
                case R.id.button_9:
                    ArrayList<String> objectnum_9 = setOperand(InputString, "9", real_input, warning_info);
                    real_input = objectnum_9.get(0);
                    InputString = objectnum_9.get(1);
                    warning_info = objectnum_9.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //0
                case R.id.button_10:
                    ArrayList<String> objectnum_0 = setOperand(InputString, "0", real_input, warning_info);
                    real_input = objectnum_0.get(0);
                    InputString = objectnum_0.get(1);
                    warning_info = objectnum_0.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '+'
                case R.id.button_11:
                    ArrayList<String> objectadd = setOperator(InputString, "+", real_input, warning_info);
                    real_input = objectadd.get(0);
                    InputString = objectadd.get(1);
                    warning_info = objectadd.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '*'
                case R.id.button_12:
                    ArrayList<String> objectmulti = setOperator(InputString, "*", real_input, warning_info);
                    real_input = objectmulti.get(0);
                    InputString = objectmulti.get(1);
                    warning_info = objectmulti.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '('
                case R.id.button_13:
                    warning_info = init_String;
                    if(support.checkInit(InputString)){
                        InputString = "(";
                        real_input = "(";
                    }else if(support.checkPoint(InputString)) {
                        Log.d("set LBracket","reject input");
                    }else if(support.checkLastSym(InputString)){
                        InputString = InputString +"(";
                        real_input = real_input + "(";
                    }else if(support.checkLastNum(InputString)){
                        warning_info = "WARNING:缺少操作符";
                        InputString = InputString +"(";
                        real_input = real_input + "*(";
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;

                //delete
                case R.id.button_14:
                    warning_info = init_String;
                    StringBuilder deltempmstr = new StringBuilder();
                    String deltemprstr;
                    char[] cha = InputString.toCharArray();
                    String aimchar = InputString.substring(InputString.length() - 1);
                    int aimindex = real_input.lastIndexOf(aimchar);
                    for (int i = 0; i < InputString.length() - 1; i++) {
                        deltempmstr.append(cha[i]);
                    }
                    deltemprstr = real_input.substring(0, aimindex);

                    if (InputString.length() > 1) {
                        InputString = deltempmstr.toString();
                        real_input = deltemprstr;
                    } else {
                        InputString = init_Value;
                        real_input = init_Value;
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //clear
                case R.id.button_15:
                    InputString = init_Value;
                    real_input = init_Value;
                    warning_info = init_String;
                    symbolView.setText(null);
                    inputTextView.setText(null);
                    resultView.setText(null);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '-'
                case R.id.button_16:
                    ArrayList<String> objectsub = setOperator(InputString, "-", real_input, warning_info);
                    real_input = objectsub.get(0);
                    InputString = objectsub.get(1);
                    warning_info = objectsub.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '/'
                case R.id.button_17:
                    ArrayList<String> objectdiv = setOperator(InputString, "/", real_input, warning_info);

                    real_input = objectdiv.get(0);
                    InputString = objectdiv.get(1);
                    warning_info = objectdiv.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input ')'
                case R.id.button_18:
                    warning_info = init_String;
                    if(support.checkInit(InputString) || support.checkPoint(InputString) || support.checkLBracket(InputString)) {
                        Log.d("set RBracket","reject input");
                    }else if(support.checkLastSym(InputString)){
                        warning_info = "WARNING:缺少右操作数";
                        if(support.checkaddsub(InputString)){
                            InputString = InputString +")";
                            real_input = real_input + "0)";
                        }else {
                            InputString = InputString +")";
                            real_input = real_input + "1)";
                        }
                    }else {
                        InputString = InputString +")";
                        real_input = real_input + ")";
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '.'
                case R.id.button_19:
                    warning_info = init_String;
                    if(support.checkPoint(InputString)||support.checksym(InputString)==-2){
                        Log.d("set point","lose");
                    }else if(support.checkLastNum(InputString)){
                        InputString = InputString + ".";
                        real_input = real_input + ".";
                        Log.d("set point","getin");
                    }
                    Log.d("set point", InputString);
                    Log.d("set point", real_input);

                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //nav to page2
                case R.id.chip_topg2:
                    Log.d("Main", "nav to page2");
                    Intent intent = new Intent(MainActivity.this,SecodMainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                //input = ,start calculate
                case R.id.button_20:
                    warning_info = init_String;
                    if (support.checkLastSym(InputString) || support.checkPoint(InputString)) {
                        InputString = InputString.substring(0, InputString.length() - 1);
                        real_input = real_input.substring(0, real_input.length() - 1);
                    }

                    InputString = support.addRBracket(InputString);
                    real_input = support.addRBracket(real_input);

                    if (support.checkspe(InputString)) {
                        warning_info = "ERROR";
                        symbolView.setText(warning_info);

                    } else {
                        Calculate_Symbol = "=";
                        symbolView.setText(Calculate_Symbol);
                        inputTextView.setText(InputString);

                        Log.d("Main", InputString);
                        Log.d("Main", real_input);

                        ResultString = new JNI().callCalcu(real_input);

                        if (support.judgeContainsStr(ResultString)) {
                            double value = Double.parseDouble(ResultString);
                            DecimalFormat decimalFormat = new DecimalFormat("###################.#######");
                            ResultString = decimalFormat.format(value);
                        }
                        Log.d("Main", ResultString);
                        resultView.setText(ResultString);

//                        if(support.judgeContains(ResultString)){
//                            resultView.setText(ResultString);
//                        }else{
//                            double value = Double.valueOf(ResultString);
//                            DecimalFormat decimalFormat = new DecimalFormat("################.#######");
//                            ResultString = decimalFormat.format(value);
//                            resultView.setText(ResultString);
//                        }
                    }

                    InputString = init_Value;
                    real_input = init_Value;
                    inputText.setText(InputString);
                    break;
                default:
                    break;
            }
        }

        else{
            warning_info = "WARNING: OUT OF SPACE";
            switch (v.getId()) {
                //delete
                case R.id.button_14:
                    warning_info = init_String;
                    StringBuilder deltempmstr = new StringBuilder();
                    String deltemprstr;
                    char[] cha = InputString.toCharArray();
                    String aimchar = InputString.substring(InputString.length() - 1);
                    int aimindex = real_input.lastIndexOf(aimchar);
                    for (int i = 0; i < InputString.length() - 1; i++) {
                        deltempmstr.append(cha[i]);
                    }
                    deltemprstr = real_input.substring(0, aimindex);

                    if (InputString.length() > 1) {
                        InputString = deltempmstr.toString();
                        real_input = deltemprstr;
                    } else {
                        InputString = init_Value;
                        real_input = init_Value;
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //clear
                case R.id.button_15:
                    InputString = init_Value;
                    real_input = init_Value;
                    warning_info = init_String;
                    symbolView.setText(null);
                    inputTextView.setText(null);

                    resultView.setText(null);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '=',start calculate
                case R.id.button_20:
                    warning_info = init_String;
                    if (support.checkLastSym(InputString) || support.checkPoint(InputString)) {
                        InputString = InputString.substring(0, InputString.length() - 1);
                        real_input = real_input.substring(0, real_input.length() - 1);
                    }

                    Log.d("Main", InputString);
                    Log.d("Main", real_input);

                    InputString = support.addRBracket(InputString);
                    real_input = support.addRBracket(real_input);

                    if (support.checkspe(InputString)) {
                        warning_info = "ERROR";
                        symbolView.setText(warning_info);

                    } else {
                        Calculate_Symbol = "=";
                        symbolView.setText(Calculate_Symbol);
                        inputTextView.setText(InputString);
                        ResultString = new JNI().callCalcu(real_input);

                        if (support.judgeContainsStr(ResultString)) {
                            double value = Double.parseDouble(ResultString);
                            DecimalFormat decimalFormat = new DecimalFormat("########################.#######");
                            ResultString = decimalFormat.format(value);
                        }
                        Log.d("Main", ResultString);
                        resultView.setText(ResultString);
                    }

                    InputString = init_Value;
                    real_input = init_Value;
                    inputText.setText(InputString);
                    break;
                default:
                    break;
            }
        }
    }

    //settle operator input
    public ArrayList<String> setOperator(String str_show, String operator, String str_hide, String warnInfo){
        Log.d("Main", "press "+operator);
        warning_info = init_String;
        if (support.checkLastSym(str_show) || support.checkPoint(str_show)){
            str_show = str_show.substring(0,str_show.length()-1)+operator;
            str_hide = str_show.substring(0,str_show.length()-1)+operator;
        }else if (support.checkLBracket(str_show)){
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
    public ArrayList<String> setOperand(String str_show, String operand, String str_hide, String warnInfo){
        Log.d("Main", "press "+operand);
        warning_info = init_String;
        if(support.checkInit(str_show)) {
            str_show = operand;
            str_hide = operand;
        }else if(support.checkRBracket(str_show)){
            str_hide = str_hide + "*" + operand;
            str_show = str_show + operand;
            warnInfo = "缺少操作符";
        }else if(support.checkZero(str_show)){
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
