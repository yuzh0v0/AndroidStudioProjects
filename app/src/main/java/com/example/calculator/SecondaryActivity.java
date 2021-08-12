package com.example.calculator;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.litepal.LitePal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;


public class SecondaryActivity extends AppCompatActivity implements View.OnClickListener {

    SecondaryActivitySupport SASupport = new SecondaryActivitySupport();
    private long mExitTime = 0;
    String path;
    TextView tv;
    double case_count;
    double case_right;
    double pass_rate;
    InputStreamReader importstream = null;
    BufferedReader reader =null;
    int storenum = 0;
    List<Order> order_list;
    NumberFormat nf = NumberFormat.getPercentInstance();
    private TextView View_case_count,View_pass_rate;
    private EditText formula_add_edit;
    private EditText expect_value_edit ;
    public String formula_add , expect_value , single_result;

    public String[] datastore={"","","","","","","","","","","","","","","","","",
            "","","","","","","","", "","","","","","","","","","","","","","","",
            "", "", "","","","","","","","","","","","","","","","","","","","",""};
    public static String[] datastoreclear={"","","","","","","","","","","","","","",
            "","","","","","","","","","","", "","","","","","","","","","","","","",
            "","","", "", "","","","","","","","","","","","","","","","","","","","",""};
    public ListView case_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        case_listView = findViewById(R.id.list_view);
        Button chip_topg1 = findViewById(R.id.chip_topg1);
        Button btn_add_case = findViewById(R.id.btn_addsingletest);
        Button btn_import_cases = findViewById(R.id.btn_import_cases);
        Button btn_import_default_cases = findViewById(R.id.btn_import_default_cases);
        Button btn_export_cases = findViewById(R.id.btn_export_cases);
        Button btn_start_testing = findViewById(R.id.btn_start_testing);
        Button btn_table_clean = findViewById(R.id.btn_table_clean);
        formula_add_edit = findViewById(R.id.formula_add_edit);
        expect_value_edit = findViewById(R.id.expect_value_edit);
        View_case_count = findViewById(R.id.View_case_count);
        View_pass_rate = findViewById(R.id.View_pass_rate);

        chip_topg1.setOnClickListener(this);
        btn_add_case.setOnClickListener(this);
        btn_import_cases.setOnClickListener(this);
        btn_import_default_cases.setOnClickListener(this);
        btn_export_cases.setOnClickListener(this);
        btn_start_testing.setOnClickListener(this);
        btn_table_clean.setOnClickListener(this);

        ArrayAdapter<String> adapter_init = new ArrayAdapter<>(SecondaryActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                datastore);
        case_listView.setAdapter(adapter_init);

        LitePal.getDatabase();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public   void  onClick(View v){
        switch (v.getId()) {
            case R.id.chip_topg1: // nav to page1
                Intent intent_nav = new Intent(SecondaryActivity.this, MainActivity.class);
                startActivity(intent_nav);
                finish();
                break;

            case R.id.btn_addsingletest: // add single test_case
                TestCase testdome_add = new TestCase();
                formula_add=formula_add_edit.getText().toString();
                Toast.makeText(SecondaryActivity.this, formula_add,Toast.LENGTH_SHORT).show();
                expect_value=expect_value_edit.getText().toString();
                Toast.makeText(SecondaryActivity.this, expect_value,Toast.LENGTH_SHORT).show();

                if(formula_add.equals("")||expect_value.equals("")){
                    break;
                }
                testdome_add.setFormulas(formula_add);
                testdome_add.setExpectedValue(expect_value);
                single_result = new JNI().callCalcu(formula_add);
                testdome_add.setRealResult(single_result);
                testdome_add.setIspass(single_result.equals(expect_value));
                testdome_add.save();
                formula_add_edit.setText("");
                expect_value_edit.setText("");

                // database -> stringArray
                List<TestCase>  setlistview = LitePal.findAll(TestCase.class);
                int listsize=0;
                int dbsize=setlistview.size();
                Log.d("import", String.valueOf(dbsize));
                // clear listview Array
                while( storenum <= 20) {
                    datastore[storenum]=datastoreclear[storenum];
                    storenum++;
                }
                do {
                    for (TestCase items: setlistview){
                        datastore[listsize] = "#\t\t算式"+items.getFormulas()+"\t\t期望值为"+items.getExpectedValue();
                        listsize ++;
                        Log.d("import", String.valueOf(listsize));
                    }
                }while (listsize<dbsize) ;
                ArrayAdapter<String> adapter = new ArrayAdapter<>(SecondaryActivity.this,
                        android.R.layout.simple_expandable_list_item_1,
                        datastore);
                case_listView.setAdapter(adapter);
                case_listView.setSelection(listsize-1);
                case_count +=1;
                View_case_count.setText(String.valueOf((int)case_count));
                pass_rate = case_right/case_count;
                nf.setMaximumFractionDigits(1);
                View_pass_rate.setText(nf.format(pass_rate));
                break;

            case R.id.btn_import_cases: // import testcase
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("./*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
                break;

            case R.id.btn_import_default_cases:
                LitePal.deleteAll(TestCase.class);
                try {
                    importstream = new InputStreamReader(getAssets().open("casestore.csv"));
                    reader = new BufferedReader(importstream);
                    String line;
                    String[] str;
                    while ((line = reader.readLine()) != null) {
                        str = line.split(",");
                        TestCase testdemo = new TestCase();
                        testdemo.setFormulas(str[0]);
                        testdemo.setExpectedValue(str[1]);
                        Log.d("import",testdemo.getFormulas());
                        Log.d("import",testdemo.getExpectedValue());
                        testdemo.save();
                    }
                    // database -> stringArray
                    List<TestCase>  setListview_add = LitePal.findAll(TestCase.class);
                    int listsize_add=0;
                    int dbsize_add=setListview_add.size();
//                    Log.d("import", String.valueOf(dbsize_add));
                    while( storenum <= 60) {
                        datastore[storenum]=datastoreclear[storenum];
                        storenum++;
                    }
                    do {
                        for (TestCase items: setListview_add){
                            int outputIndex = listsize_add + 1;
                            datastore[listsize_add] = outputIndex +"\t\t计算式"+items.getFormulas()
                                    +"\t\t期望值为"+items.getExpectedValue();
                            ++listsize_add;
//                            Log.d("import", String.valueOf(listsize_add));
                        }
                    } while (listsize_add < dbsize_add);
                    ArrayAdapter<String> adapter_add = new ArrayAdapter<>(SecondaryActivity.this,
                            android.R.layout.simple_expandable_list_item_1,
                            datastore);
                    case_listView.setAdapter(adapter_add);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    if(importstream !=null){
                        try {
                            importstream.close();
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                }
                break;

            case R.id.btn_export_cases: // export testcases
                try {
                    List<TestCase>  setlistview_exp = LitePal.findAll(TestCase.class);
                    order_list = new ArrayList<>();
                    int i = 0;
                    for (TestCase items: setlistview_exp) {
                        Order order = new Order(String.valueOf(i++),items.getFormulas(),items.getExpectedValue(),items.getRealResult(),items.getIsPass());
                        order_list.add(order);
                    }
                    Log.d("export", "start export");
                    FileExport.writeToExcel(SecondaryActivity.this,order_list,"orderTest");
                    Log.d("export", "end export");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btn_start_testing: // start test
                // clear listview array
                while( storenum <= 50) {
                    datastore[storenum]=datastoreclear[storenum];
                    storenum++;
                }
                ArrayAdapter<String> adapter_clear = new ArrayAdapter<>(SecondaryActivity.this,
                        android.R.layout.simple_expandable_list_item_1, datastore);
                case_listView.setAdapter(adapter_clear);
                Toast.makeText(this, "开始用例批量测试", Toast.LENGTH_SHORT).show();

                // write to database
                List<TestCase>  setlistview_test = LitePal.findAll(TestCase.class);
                case_count = 0;
                case_right = 0;
                for (TestCase items: setlistview_test){
                    case_count ++;
                    TestCase testtoupdate = new TestCase();
                    String tempresult = new JNI().callCalcu(items.getFormulas());
                    double expvalue = Double.parseDouble(items.getExpectedValue());
                    double realvalue = Double.parseDouble(tempresult);
                    double diffr = abs(realvalue-expvalue);
                    testtoupdate.setRealResult(tempresult);
                    if( diffr <= 0.1){
                        testtoupdate.setIspass(true);
                        case_right ++;
                    }else {
                        testtoupdate.setIspass(false);
                    }
                    testtoupdate.updateAll("id=?",String.valueOf(items.getId()));
                }
                List<TestCase>  setlistview_result = LitePal.findAll(TestCase.class);
                int listsize_add=0;
                int dbsize_add=setlistview_result.size();
                Log.d("import", String.valueOf(dbsize_add));
                do {
                    for (TestCase items: setlistview_result) {
                        datastore[listsize_add] = "计算式" + items.getFormulas() + "\t\t期望值为"+items.getExpectedValue()
                                +"\t\t实际结果为"+items.getRealResult()+"\t\t测试结果为" + items.getIsPass();
                        ++listsize_add;
                        Log.d("import", String.valueOf(listsize_add));
                    }
                } while (listsize_add < dbsize_add);
                ArrayAdapter<String> adapter_result = new ArrayAdapter<>(SecondaryActivity.this,
                        android.R.layout.simple_expandable_list_item_1, datastore);
                case_listView.setAdapter(adapter_result);
                View_case_count.setText(String.valueOf((int)case_count));
                    if(case_count!=0) {
                        pass_rate = case_right / case_count;
                        nf.setMaximumFractionDigits(1);
                        View_pass_rate.setText(nf.format(pass_rate));
                    }else {
                        View_pass_rate.setText("0.0%");
                    }
                break;

            case R.id.btn_table_clean: // clear listview
                LitePal.deleteAll(TestCase.class);
                storenum = 0;
                while( storenum <= 50) {
                    datastore[storenum]=datastoreclear[storenum];
                    storenum++;
                }
                ArrayAdapter<String> adapter_import = new ArrayAdapter<>(SecondaryActivity.this,
                        android.R.layout.simple_expandable_list_item_1,
                        datastore);
                case_listView.setAdapter(adapter_import);
                View_case_count.setText("0");
                View_pass_rate.setText("0.0%");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                path = uri.getPath();
                tv.setText(path);
                Toast.makeText(this, path + "11111", Toast.LENGTH_SHORT).show();
                return;
            }
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                path = SASupport.getPath(this, uri);
                tv.setText(path);
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
            } else {
                path = SASupport.getRealPathFromURI(uri);
                tv.setText(path);
                Toast.makeText(SecondaryActivity.this, path + "2", Toast.LENGTH_SHORT).show();
            }
        }
    }

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

