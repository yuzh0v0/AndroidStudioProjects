package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
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


public class SecodMainActivity extends AppCompatActivity implements View.OnClickListener {
    String path;
    TextView tv;
    float case_count = 0;
    float case_right = 0;
    float pass_rate ;
    InputStreamReader importstream = null;
    BufferedReader reader =null;
    int storenum = 0;
    List<Order> order_list;
    NumberFormat nf = NumberFormat.getPercentInstance();
    private TextView View_case_count,View_pass_rate;
    private EditText formula_add_edit;
    private EditText expect_value_edit ;
    private long mExitTime = 0;
    public String formula_add , expect_value , single_result;
    public String[] datastore={"","","","","","","","","","","","","","","","","",
            "","","","","","","","", "","","","","","","","","","","","","","","",
            "", "", "","","","","","","","","","","","","","","","","","","","",""};
    public static String[] datastoreclear={"","","","","","","","","","","","","","",
            "","","","","","","","","","","", "","","","","","","","","","","","","",
            "","","", "", "","","","","","","","","","","","","","","","","","","","",""};
    public ListView caselistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secod_main);

        caselistView = findViewById(R.id.list_view);
        Button chip_topg1 = findViewById(R.id.chip_topg1);
        Button btn_add_case = findViewById(R.id.btn_addsingletest);
        Button btn_import_cases = findViewById(R.id.btn_import_cases);
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
        btn_export_cases.setOnClickListener(this);
        btn_start_testing.setOnClickListener(this);
        btn_table_clean.setOnClickListener(this);

        ArrayAdapter<String> adapter_init = new ArrayAdapter<>(SecodMainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                datastore);
        caselistView.setAdapter(adapter_init);


        LitePal.getDatabase();

//        order_list = new ArrayList<>();
//        int len = Const.OrderInfo.orderOne.length;
//        for (int i = 0; i < len ; i++) {
//            Order order = new Order(Const.OrderInfo.orderOne[i][0],Const.OrderInfo.orderOne[i][1],Const.OrderInfo.orderOne[i][2],Const.OrderInfo.orderOne[i][3]);
//            order_list.add(order);
//        }

    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public   void  onClick(View v){
        switch (v.getId()) {
            //切换到第一页面
            case R.id.chip_topg1:
                Intent intent_nav = new Intent(SecodMainActivity.this, MainActivity.class);
                startActivity(intent_nav);
                finish();
                break;

            //添加单个测试用例
            case R.id.btn_addsingletest:
                TestCase testdome_add = new TestCase();
                formula_add=formula_add_edit.getText().toString();
                Toast.makeText(SecodMainActivity.this, formula_add,Toast.LENGTH_SHORT).show();
                expect_value=expect_value_edit.getText().toString();
                Toast.makeText(SecodMainActivity.this, expect_value,Toast.LENGTH_SHORT).show();

                testdome_add.setFormulas(formula_add);
                testdome_add.setExpectedValue(expect_value);
                single_result = new JNI().callcalcu(formula_add);
                testdome_add.setRealResult(single_result);
                testdome_add.setIspass(single_result.equals(expect_value));
                testdome_add.save();
                formula_add_edit.setText("");
                expect_value_edit.setText("");

                //读取数据库全部数据到集合
                List<TestCase>  setlistview = LitePal.findAll(TestCase.class);
                int listsize=0;
                int dbsize=setlistview.size();
                Log.d("import", String.valueOf(dbsize));
                //清空listview数组
                while( storenum <= 20) {
                    datastore[storenum]=datastoreclear[storenum];
                    storenum++;
                }
                //从集合写数据到数组
                do {
                    for (TestCase items: setlistview){
                        datastore[listsize] = items.getId()+"\t\t算式"+items.getFormulas()+"\t\t期望值为"+items.getExpectedValue()+"\t\t结果为"+items.getRealResult();
                        listsize ++;
                        Log.d("import", String.valueOf(listsize));
                    }
                }while (listsize<dbsize) ;
                ArrayAdapter<String> adapter = new ArrayAdapter<>(SecodMainActivity.this,
                        android.R.layout.simple_expandable_list_item_1,
                        datastore);
                caselistView.setAdapter(adapter);
                caselistView.setSelection(listsize-1);
                break;
            //导入测试用例
            case R.id.btn_import_cases:
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("file/*");
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(intent, 1);
                //清空数据库
                LitePal.deleteAll(TestCase.class);
                                //读取文件写入数据库
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

                    //ArrayList<String> objectstore = get_Data(testdome,datastore);
                    //ArrayList<String> testitems = new ArrayList<>();

                    //读取数据库全部数据到集合
                    List<TestCase>  setlistview_add = LitePal.findAll(TestCase.class);
                    int listsize_add=0;
                    int dbsize_add=setlistview_add.size();
                    Log.d("import", String.valueOf(dbsize_add));
                    //清空listview数组
                    while( storenum <= 60) {
                        datastore[storenum]=datastoreclear[storenum];
                        storenum++;
                    }
                    //从集合写数据到数组
                    do {
                        for (TestCase items: setlistview_add){
                            int outputindex = listsize_add + 1;
                            datastore[listsize_add] = outputindex +"\t\t计算式"+items.getFormulas()+"\t\t期望值为"+items.getExpectedValue();
                            ++listsize_add;
                            Log.d("import", String.valueOf(listsize_add));
                        }
                    } while (listsize_add < dbsize_add);
                    ArrayAdapter<String> adapter_add = new ArrayAdapter<>(SecodMainActivity.this,
                            android.R.layout.simple_expandable_list_item_1,
                            datastore);
                    caselistView.setAdapter(adapter_add);
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
            //导出测试完的用例到设备
            case R.id.btn_export_cases:
                try {
                    List<TestCase>  setlistview_exp = LitePal.findAll(TestCase.class);
                    order_list = new ArrayList<>();
                    int i = 0;
                    for (TestCase items: setlistview_exp) {
                        Order order = new Order(String.valueOf(i++),items.getFormulas(),items.getExpectedValue(),items.getRealResult(),items.getIsPass());
                        order_list.add(order);
                    }
                    FileExport.writeToExcel(SecodMainActivity.this,order_list,"orderTest");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //将导入的测试用例开始测试
            case R.id.btn_start_testing:
                //清空listview数组
                while( storenum <= 50) {
                    datastore[storenum]=datastoreclear[storenum];
                    storenum++;
                }
                ArrayAdapter<String> adapter_clear = new ArrayAdapter<>(SecodMainActivity.this,
                        android.R.layout.simple_expandable_list_item_1, datastore);
                caselistView.setAdapter(adapter_clear);
                Toast.makeText(this, "开始用例批量测试", Toast.LENGTH_SHORT).show();

                //测试并把结果写入数据库
                List<TestCase>  setlistview_test = LitePal.findAll(TestCase.class);
                for (TestCase items: setlistview_test){
                    case_count ++;
                    TestCase testtoupdate = new TestCase();
                    String tempresult = new JNI().callcalcu(items.getFormulas());
                    if(tempresult.equals(items.getExpectedValue())){
                        testtoupdate.setRealResult(tempresult);
                        testtoupdate.setIspass(true);
                        case_right ++;
                        testtoupdate.updateAll("id=?",String.valueOf(items.getId()));
                    }else {
                        testtoupdate.setRealResult(tempresult);
                        testtoupdate.updateAll("id=?",String.valueOf(items.getId()));
                    }
                }
                //再从数据库中取出并显示
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
                ArrayAdapter<String> adapter_result = new ArrayAdapter<>(SecodMainActivity.this,
                        android.R.layout.simple_expandable_list_item_1, datastore);
                caselistView.setAdapter(adapter_result);
                View_case_count.setText(String.valueOf((int)case_count));
                pass_rate = case_right/case_count;
                nf.setMaximumFractionDigits(1);
                View_pass_rate.setText(nf.format(pass_rate));
                break;
            case R.id.btn_table_clean: //清除页面显示的数据
                storenum = 0;
                while( storenum <= 50) {
                    datastore[storenum]=datastoreclear[storenum];
                    storenum++;
                }
                ArrayAdapter<String> adapter_import = new ArrayAdapter<>(SecodMainActivity.this,
                        android.R.layout.simple_expandable_list_item_1,
                        datastore);
                caselistView.setAdapter(adapter_import);
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
                path = getPath(this, uri);
                tv.setText(path);
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
            } else {
                path = getRealPathFromURI(uri);
                tv.setText(path);
                Toast.makeText(SecodMainActivity.this, path + "222222", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if(null!=cursor&&cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
            cursor.close();
        }
        return res;
    }

    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public String getDataColumn(Context context, Uri uri, String selection,
                                String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
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

