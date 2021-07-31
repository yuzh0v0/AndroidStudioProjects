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


//    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        inputText =(TextView)findViewById(R.id.initialinput);
        symbolView =(TextView)findViewById(R.id.symbolView);
        inputTextView =(TextView)findViewById(R.id.inputTextView);
        resultView =(TextView)findViewById(R.id.resultView);



        Button chip_totest = (Button) findViewById(R.id.chip_topg2);
        Button button_num_1 = (Button) findViewById(R.id.button_1);
        Button button_num_2 = (Button) findViewById(R.id.button_2);
        Button button_num_3 = (Button) findViewById(R.id.button_3);
        Button button_num_4 = (Button) findViewById(R.id.button_4);
        Button button_num_5 = (Button) findViewById(R.id.button_5);
        Button button_num_6 = (Button) findViewById(R.id.button_6);
        Button button_num_7 = (Button) findViewById(R.id.button_7);
        Button button_num_8 = (Button) findViewById(R.id.button_8);
        Button button_num_9 = (Button) findViewById(R.id.button_9);
        Button button_num_0 = (Button) findViewById(R.id.button_10);
        Button button_add = (Button) findViewById(R.id.button_11);
        Button button_multi = (Button) findViewById(R.id.button_12);
        Button button_bracket_l = (Button) findViewById(R.id.button_13);
        Button button_del = (Button) findViewById(R.id.button_14);
        Button button_clr = (Button) findViewById(R.id.button_15);
        Button button_sub = (Button) findViewById(R.id.button_16);
        Button button_div = (Button) findViewById(R.id.button_17);
        Button button_bracket_r = (Button) findViewById(R.id.button_18);
        Button button_point = (Button) findViewById(R.id.button_19);
        Button button_equal = (Button) findViewById(R.id.button_20);

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
                    ArrayList<String> objectnum_1 = setNumber(InputString, "1", real_input, warning_info);
                    real_input = objectnum_1.get(0);
                    InputString = objectnum_1.get(1);
                    warning_info = objectnum_1.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //2
                case R.id.button_2:
                    ArrayList<String> objectnum_2 = setNumber(InputString, "2", real_input, warning_info);
                    real_input = objectnum_2.get(0);
                    InputString = objectnum_2.get(1);
                    warning_info = objectnum_2.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //3
                case R.id.button_3:
                    ArrayList<String> objectnum_3 = setNumber(InputString, "3", real_input, warning_info);
                    real_input = objectnum_3.get(0);
                    InputString = objectnum_3.get(1);
                    warning_info = objectnum_3.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //4
                case R.id.button_4:
                    ArrayList<String> objectnum_4 = setNumber(InputString, "4", real_input, warning_info);
                    real_input = objectnum_4.get(0);
                    InputString = objectnum_4.get(1);
                    warning_info = objectnum_4.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //5
                case R.id.button_5:
                    ArrayList<String> objectnum_5 = setNumber(InputString, "5", real_input, warning_info);
                    real_input = objectnum_5.get(0);
                    InputString = objectnum_5.get(1);
                    warning_info = objectnum_5.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //6
                case R.id.button_6:
                    ArrayList<String> objectnum_6 = setNumber(InputString, "6", real_input, warning_info);
                    real_input = objectnum_6.get(0);
                    InputString = objectnum_6.get(1);
                    warning_info = objectnum_6.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //7
                case R.id.button_7:
                    ArrayList<String> objectnum_7 = setNumber(InputString, "7", real_input, warning_info);
                    real_input = objectnum_7.get(0);
                    InputString = objectnum_7.get(1);
                    warning_info = objectnum_7.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //8
                case R.id.button_8:
                    ArrayList<String> objectnum_8 = setNumber(InputString, "8", real_input, warning_info);
                    real_input = objectnum_8.get(0);
                    InputString = objectnum_8.get(1);
                    warning_info = objectnum_8.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //9
                case R.id.button_9:
                    ArrayList<String> objectnum_9 = setNumber(InputString, "9", real_input, warning_info);
                    real_input = objectnum_9.get(0);
                    InputString = objectnum_9.get(1);
                    warning_info = objectnum_9.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //0
                case R.id.button_10:
                    ArrayList<String> objectnum_0 = setNumber(InputString, "0", real_input, warning_info);
                    real_input = objectnum_0.get(0);
                    InputString = objectnum_0.get(1);
                    warning_info = objectnum_0.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //键入加号
                case R.id.button_11:
//                    InputString = InputString +"+";
                    ArrayList<String> objectadd = setSym(InputString, "+", real_input, warning_info);
                    real_input = objectadd.get(0);
                    InputString = objectadd.get(1);
                    warning_info = objectadd.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //键入乘号
                case R.id.button_12:
//                    InputString = InputString +"*";
                    ArrayList<String> objectmulti = setSym(InputString, "*", real_input, warning_info);
                    real_input = objectmulti.get(0);
                    InputString = objectmulti.get(1);
                    warning_info = objectmulti.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //键入左括号
                case R.id.button_13:
//                    InputString = InputString +"(";
                    warning_info = init_String;
                    if(support.checkInit(InputString)){
                        InputString = "(";
                        real_input = "(";
                    }else if(support.checkPoint(InputString)) {
                    //拒绝键入
                        Log.d("Main","reject input");
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

                //删除
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
                //清空
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
                //键入减号
                case R.id.button_16:
//                    InputString = InputString +"-";

                    ArrayList<String> objectsub = setSym(InputString, "-", real_input, warning_info);
                    real_input = objectsub.get(0);
                    InputString = objectsub.get(1);
                    warning_info = objectsub.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    break;
                //键入除号
                case R.id.button_17:
//                    InputString = InputString +"/";
                    ArrayList<String> objectdiv = setSym(InputString, "/", real_input, warning_info);

                    real_input = objectdiv.get(0);
                    InputString = objectdiv.get(1);
                    warning_info = objectdiv.get(2);
                    inputText.setText(InputString);
                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;
                //键入右括号
                case R.id.button_18:
//                    InputString = InputString +")";
                    warning_info = init_String;
                    if(support.checkInit(InputString) || support.checkPoint(InputString) || support.checkRBracket(InputString)) {
                    //拒绝键入
                        Log.d("Main","reject input");
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
                //键入小数点
                case R.id.button_19:
                    warning_info = init_String;

                    if(support.checkPoint(InputString)||support.checksym(InputString)==-2){
                        Log.d("aaa","lose");
                    }else if(support.checkLastNum(InputString)){
                        InputString = InputString + ".";
                        real_input = real_input + ".";
                        Log.d("aaa","getin");
                    }
                    Log.d("aaa", InputString);
                    Log.d("aaa", real_input);


                    symbolView.setText(warning_info);
                    inputText.setText(InputString);
                    break;

                case R.id.chip_topg2:
                    Intent intent = new Intent(MainActivity.this,SecodMainActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                case R.id.button_20:
                    warning_info = init_String;
                    if (support.checkLastSym(InputString) || support.checkPoint(InputString)) {
                        InputString = InputString.substring(0, InputString.length() - 1);
                        real_input = real_input.substring(0, real_input.length() - 1);
                    }

//                    Log.d("aaa", InputString);
//                    Log.d("aaa", realinput);

                    InputString = support.addRBracket(InputString);
                    real_input = support.addRBracket(real_input);

                    if (support.checkspe(InputString)) {
                        warning_info = "ERROR";
                        symbolView.setText(warning_info);

                    } else {
                        Calculate_Symbol = "=";
                        symbolView.setText(Calculate_Symbol);
                        inputTextView.setText(InputString);

                        Log.d("aaa", InputString);
                        Log.d("aaa", real_input);

                        ResultString = new JNI().callcalcu(real_input);

                        if (support.judgeContainsStr(ResultString)) {
                            double value = Double.parseDouble(ResultString);
                            DecimalFormat decimalFormat = new DecimalFormat("###################.#######");
                            ResultString = decimalFormat.format(value);
                        }
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
                //删除
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
                //清空
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
                //键入等号，开始计算
                case R.id.button_20:
                    warning_info = init_String;
                    if (support.checkLastSym(InputString) || support.checkPoint(InputString)) {
                        InputString = InputString.substring(0, InputString.length() - 1);
                        real_input = real_input.substring(0, real_input.length() - 1);
                    }

//                    Log.d("aaa", InputString);
//                    Log.d("aaa", realinput);

                    InputString = support.addRBracket(InputString);
                    real_input = support.addRBracket(real_input);

                    if (support.checkspe(InputString)) {
                        warning_info = "ERROR";
                        symbolView.setText(warning_info);

                    } else {
                        Calculate_Symbol = "=";
                        symbolView.setText(Calculate_Symbol);
                        inputTextView.setText(InputString);

                        Log.d("aaa", InputString);
                        Log.d("aaa", real_input);

                        ResultString = new JNI().callcalcu(real_input);

                        if (support.judgeContainsStr(ResultString)) {
                            double value = Double.parseDouble(ResultString);
                            DecimalFormat decimalFormat = new DecimalFormat("########################.#######");
                            ResultString = decimalFormat.format(value);
                        }
                        resultView.setText(ResultString);

//                        if(support.judgeContains(ResultString)){
//                            resultView.setText(ResultString);
//                        }else{
//                            double value = Double.valueOf(ResultString);
//                            DecimalFormat decimalFormat = new DecimalFormat("######################.#######");
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
    }

    //处理输入符号
    public ArrayList<String> setSym(String mstr, String thesym, String rstr, String warninfo){
        warning_info = init_String;
        if (support.checkLastSym(mstr) || support.checkPoint(mstr)){
            mstr = mstr.substring(0,mstr.length()-1)+thesym;
            rstr = mstr.substring(0,mstr.length()-1)+thesym;
        }else if (support.checkLBracket(mstr)){
            warninfo = "WARNING：缺少左操作数";
            switch (thesym) {
                case "+":
                    rstr = rstr + "0" + thesym;
                    mstr = mstr + thesym;
                    break;
                case "-":
                    rstr = rstr + "0" + thesym;
                    mstr = mstr + thesym;
                    warninfo = init_String;
                    break;
                case "*":
                case "/":
                    rstr = rstr + "1" + thesym;
                    mstr = mstr + thesym;
                    break;
            }
        }else {
            mstr = mstr + thesym;
            rstr = rstr + thesym;
        }
        ArrayList<String> setsymlist = new ArrayList<>();
        setsymlist.add(rstr);
        setsymlist.add(mstr);
        setsymlist.add(warninfo);
        return setsymlist;
    }

    //处理输入数字
    public ArrayList<String> setNumber(String mstr, String thenum, String rstr, String warninfo){
        warning_info = init_String;
        if(support.checkInit(mstr)) {
            mstr = thenum;
            rstr = thenum;
        }else if(support.checkRBracket(mstr)){
            rstr = rstr + "*" + thenum;
            mstr = mstr + thenum;
            warninfo = "缺少操作符";
        }else if(support.checkZero(mstr)){
            //拒绝键入
            Log.d("Main","reject input");
        }else {
            mstr = mstr + thenum;
            rstr = rstr + thenum;
        }
        ArrayList<String> setnumlist = new ArrayList<>();
        setnumlist.add(rstr);
        setnumlist.add(mstr);
        setnumlist.add(warninfo);
        return setnumlist;
    }

    //退出APP延迟
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
