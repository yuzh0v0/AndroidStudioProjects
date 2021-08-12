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

    MainActivitySupport mainActivitySupport = new MainActivitySupport();
    private long mExitTime = 0;
    private final String INIT_VALUE = "0";
    String InputString, real_input, warning_info, ResultString, cal_Symbol;

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
        InputString = INIT_VALUE;
        inputText.setText(InputString);
        real_input = InputString;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        String INIT_STRING = "";
        if(InputString.length()<=50){
            switch (v.getId()){
                //input '1'
                case R.id.button_1:
                    ArrayList<String> objectnum_1 = mainActivitySupport.setOperand(InputString, "1", real_input);
                    real_input = objectnum_1.get(0);
                    InputString = objectnum_1.get(1);
                    warning_info = objectnum_1.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '2'
                case R.id.button_2:
                    ArrayList<String> objectnum_2 = mainActivitySupport.setOperand(InputString, "2", real_input);
                    real_input = objectnum_2.get(0);
                    InputString = objectnum_2.get(1);
                    warning_info = objectnum_2.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '3'
                case R.id.button_3:
                    ArrayList<String> objectnum_3 = mainActivitySupport.setOperand(InputString, "3", real_input);
                    real_input = objectnum_3.get(0);
                    InputString = objectnum_3.get(1);
                    warning_info = objectnum_3.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '4'
                case R.id.button_4:
                    ArrayList<String> objectnum_4 = mainActivitySupport.setOperand(InputString, "4", real_input);
                    real_input = objectnum_4.get(0);
                    InputString = objectnum_4.get(1);
                    warning_info = objectnum_4.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '5'
                case R.id.button_5:
                    ArrayList<String> objectnum_5 = mainActivitySupport.setOperand(InputString, "5", real_input);
                    real_input = objectnum_5.get(0);
                    InputString = objectnum_5.get(1);
                    warning_info = objectnum_5.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '6'
                case R.id.button_6:
                    ArrayList<String> objectnum_6 = mainActivitySupport.setOperand(InputString, "6", real_input);
                    real_input = objectnum_6.get(0);
                    InputString = objectnum_6.get(1);
                    warning_info = objectnum_6.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '7'
                case R.id.button_7:
                    ArrayList<String> objectnum_7 = mainActivitySupport.setOperand(InputString, "7", real_input);
                    real_input = objectnum_7.get(0);
                    InputString = objectnum_7.get(1);
                    warning_info = objectnum_7.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '8'
                case R.id.button_8:
                    ArrayList<String> objectnum_8 = mainActivitySupport.setOperand(InputString, "8", real_input);
                    real_input = objectnum_8.get(0);
                    InputString = objectnum_8.get(1);
                    warning_info = objectnum_8.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '9'
                case R.id.button_9:
                    ArrayList<String> objectnum_9 = mainActivitySupport.setOperand(InputString, "9", real_input);
                    real_input = objectnum_9.get(0);
                    InputString = objectnum_9.get(1);
                    warning_info = objectnum_9.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '0'
                case R.id.button_10:
                    ArrayList<String> objectnum_0 = mainActivitySupport.setOperand(InputString, "0", real_input);
                    real_input = objectnum_0.get(0);
                    InputString = objectnum_0.get(1);
                    warning_info = objectnum_0.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '+'
                case R.id.button_11:
                    ArrayList<String> objectadd = mainActivitySupport.setOperator(InputString, "+", real_input);
                    real_input = objectadd.get(0);
                    InputString = objectadd.get(1);
                    warning_info = objectadd.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '*'
                case R.id.button_12:
                    ArrayList<String> objectmulti = mainActivitySupport.setOperator(InputString, "*", real_input);
                    real_input = objectmulti.get(0);
                    InputString = objectmulti.get(1);
                    warning_info = objectmulti.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '('
                case R.id.button_13:
                    warning_info = INIT_STRING;
                    if(mainActivitySupport.checkInit(InputString)){
                        InputString = "(";
                        real_input = "(";
                    }else if(mainActivitySupport.checkPoint(InputString)) {
                        Log.d("set LBracket","reject input");
                    }else if(mainActivitySupport.checkLastSym(InputString)){
                        InputString = InputString +"(";
                        real_input = real_input + "(";
                    }else if(mainActivitySupport.checkLastNum(InputString)){
                        warning_info = "WARNING:缺少操作符";
                        InputString = InputString +"(";
                        real_input = real_input + "*(";
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;

                //delete
                case R.id.button_14:
                    warning_info = INIT_STRING;
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
                        InputString = INIT_VALUE;
                        real_input = INIT_VALUE;
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //clear
                case R.id.button_15:
                    InputString = INIT_VALUE;
                    real_input = INIT_VALUE;
                    warning_info = INIT_STRING;
                    symbolView.setText(null);
                    inputTextView.setText(null);
                    resultView.setText(null);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '-'
                case R.id.button_16:
                    ArrayList<String> objectsub = mainActivitySupport.setOperator(InputString, "-", real_input);
                    real_input = objectsub.get(0);
                    InputString = objectsub.get(1);
                    warning_info = objectsub.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //input '/'
                case R.id.button_17:
                    ArrayList<String> objectdiv = mainActivitySupport.setOperator(InputString, "/", real_input);

                    real_input = objectdiv.get(0);
                    InputString = objectdiv.get(1);
                    warning_info = objectdiv.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input ')'
                case R.id.button_18:
                    warning_info = INIT_STRING;
                    if(mainActivitySupport.checkInit(InputString) || mainActivitySupport.checkPoint(InputString) || mainActivitySupport.checkLBracket(InputString)) {
                        Log.d("set RBracket","reject input");
                    }else if(mainActivitySupport.checkLastSym(InputString)){
                        warning_info = "WARNING:缺少右操作数";
                        if(mainActivitySupport.checkaddsub(InputString)){
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
                    warning_info = INIT_STRING;
                    if(mainActivitySupport.checkPoint(InputString)|| mainActivitySupport.Last_operator(InputString)==-2){
                        Log.d("set point","lose");
                    }else if(mainActivitySupport.checkLastNum(InputString)){
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
                    Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                //input = ,start calculate
                case R.id.button_20:
                    warning_info = INIT_STRING;
                    if (mainActivitySupport.checkLastSym(InputString) || mainActivitySupport.checkPoint(InputString)) {
                        InputString = InputString.substring(0, InputString.length() - 1);
                        real_input = real_input.substring(0, real_input.length() - 1);
                    }

                    InputString = mainActivitySupport.addRBracket(InputString);
                    real_input = mainActivitySupport.addRBracket(real_input);

                    if (mainActivitySupport.checkspe(InputString)) {
                        warning_info = "ERROR";
                        symbolView.setText(warning_info);

                    } else {
                        cal_Symbol = "=";
                        symbolView.setText(cal_Symbol);
                        inputTextView.setText(InputString);

                        Log.d("Main", InputString);
                        Log.d("Main", real_input);

                        ResultString = new JNI().callCalcu(real_input);

                        if (mainActivitySupport.judgeContainsStr(ResultString)) {
                            double value = Double.parseDouble(ResultString);
                            DecimalFormat decimalFormat = new DecimalFormat("###################.#######");
                            ResultString = decimalFormat.format(value);
                        }
                        Log.d("Main", ResultString);
                        resultView.setText(ResultString);
                    }

                    InputString = INIT_VALUE;
                    real_input = INIT_VALUE;
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
                    warning_info = INIT_STRING;
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
                        InputString = INIT_VALUE;
                        real_input = INIT_VALUE;
                    }
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //clear
                case R.id.button_15:
                    InputString = INIT_VALUE;
                    real_input = INIT_VALUE;
                    warning_info = INIT_STRING;
                    symbolView.setText(null);
                    inputTextView.setText(null);

                    resultView.setText(null);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //input '=',start calculate
                case R.id.button_20:
                    warning_info = INIT_STRING;
                    if (mainActivitySupport.checkLastSym(InputString) || mainActivitySupport.checkPoint(InputString)) {
                        InputString = InputString.substring(0, InputString.length() - 1);
                        real_input = real_input.substring(0, real_input.length() - 1);
                    }

                    Log.d("Main", InputString);
                    Log.d("Main", real_input);

                    InputString = mainActivitySupport.addRBracket(InputString);
                    real_input = mainActivitySupport.addRBracket(real_input);

                    if (mainActivitySupport.checkspe(InputString)) {
                        warning_info = "ERROR";
                        symbolView.setText(warning_info);
                    } else {
                        cal_Symbol = "=";
                        symbolView.setText(cal_Symbol);
                        inputTextView.setText(InputString);
                        ResultString = new JNI().callCalcu(real_input);
                        //Format results
                        if (mainActivitySupport.judgeContainsStr(ResultString)) {
                            double value = Double.parseDouble(ResultString);
                            DecimalFormat decimalFormat = new DecimalFormat("#############################.#######");
                            ResultString = decimalFormat.format(value);
                        }
                        Log.d("Main", ResultString);
                        resultView.setText(ResultString);
                    }

                    InputString = INIT_VALUE;
                    real_input = INIT_VALUE;
                    inputText.setText(InputString);
                    break;
                default:
                    break;
            }
        }

    }
    //exit app delay
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == android.view.KeyEvent.KEYCODE_BACK){
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
