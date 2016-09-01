package com.imooc.carlisle.calculator;

import android.app.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
/*
bug:
1.负数
//2.dot不清零
//3.按C store清零
//4.double和int类型满值
5.不能连续输入.和各种运算符
6.不能重复按运算符
*/
public class MainActivity extends Activity implements View.OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_dot;
    Button btn_clear;
    Button btn_del;
    Button btn_add;
    Button btn_substract;
    Button btn_mutiply;
    Button btn_divide;
    Button btn_equal;
    EditText et_input;
    /**
     * store用来储存上一次运算的结果，但是按clear会清楚它
     */
    double store = 0;

    /**
     * 用作一次计算后清除显示的判断标志
     */
    boolean flag = false;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_0 = (Button) findViewById(R.id.btn_zero);
        btn_1 = (Button) findViewById(R.id.btn_one);
        btn_2 = (Button) findViewById(R.id.btn_two);
        btn_3 = (Button) findViewById(R.id.btn_three);
        btn_4 = (Button) findViewById(R.id.btn_four);
        btn_5 = (Button) findViewById(R.id.btn_five);
        btn_6 = (Button) findViewById(R.id.btn_six);
        btn_7 = (Button) findViewById(R.id.btn_seven);
        btn_8 = (Button) findViewById(R.id.btn_eight);
        btn_9 = (Button) findViewById(R.id.btn_nine);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_substract = (Button) findViewById(R.id.btn_substract);
        btn_mutiply = (Button) findViewById(R.id.btn_mutiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);

        et_input = (EditText) findViewById(R.id.input_et);

        //实现监听事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_substract.setOnClickListener(this);
        btn_mutiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View view) {
        if (flag && view.getId() != R.id.btn_equal
                && view.getId() != R.id.btn_add
                && view.getId() != R.id.btn_substract
                && view.getId() != R.id.btn_mutiply
                && view.getId() != R.id.btn_divide
                && view.getId() != R.id.btn_dot
                && view.getId() != R.id.btn_del
                ) {
            et_input.setText("");
            flag = false;
        }
        String str = et_input.getText().toString();
        switch (view.getId()) {
            case R.id.btn_zero:
            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_nine: {
                et_input.setText(str + ((Button) view).getText());
                break;
            }
            case R.id.btn_dot: {
                flag = false;

                if (str.contains(".")) {
                    break;
                }
                et_input.setText(str + ((Button) view).getText());
                break;
            }
            case R.id.btn_add: {
                flag = false;

                if (str.substring(str.length() - 1).equals("+")
                        || str.substring(str.length() - 1).equals("×")
                        || str.substring(str.length() - 1).equals("÷")) {
                    et_input.setText(str.substring(0, str.length() - 1) + ((Button) view).getText());
                    break;
                } else if (str.contains("+")
                        || str.contains("-")
                        || str.contains("×")
                        || str.contains("÷")) {
                    getResult();
                    break;
                }

                et_input.setText(str + ((Button) view).getText());
                break;
            }
            case R.id.btn_substract: {
                flag = false;

                if (str.substring(str.length() - 1).equals("+")
                        || str.substring(str.length() - 1).equals("-")
                        || str.substring(str.length() - 1).equals("×")
                        || str.substring(str.length() - 1).equals("÷")) {
                    et_input.setText(str.substring(0, str.length() - 1) + ((Button) view).getText());
                    break;
                } else if (str.contains("+")
                        || str.contains("-")
                        || str.contains("×")
                        || str.contains("÷")) {
                    getResult();
                    break;
                }

                et_input.setText(str + ((Button) view).getText());
                break;
            }
            case R.id.btn_mutiply: {
                flag = false;

                if (str.substring(str.length() - 1).equals("+")
                        || str.substring(str.length() - 1).equals("-")
                        || str.substring(str.length() - 1).equals("×")
                        || str.substring(str.length() - 1).equals("÷")) {
                    et_input.setText(str.substring(0, str.length() - 1) + ((Button) view).getText());
                    break;
                } else if (str.contains("+")
                        || str.contains("-")
                        || str.contains("×")
                        || str.contains("÷")) {
                    getResult();
                    break;
                }

                et_input.setText(str + ((Button) view).getText());
                break;
            }
            case R.id.btn_divide: {
                flag = false;

                if (str.substring(str.length() - 1).equals("+")
                        || str.substring(str.length() - 1).equals("-")
                        || str.substring(str.length() - 1).equals("×")
                        || str.substring(str.length() - 1).equals("÷")) {
                    et_input.setText(str.substring(str.length() - 1) + ((Button) view).getText());
                    break;
                } else if (str.contains("+")
                        || str.contains("-")
                        || str.contains("×")
                        || str.contains("÷")) {
                    getResult();
                    break;
                }

                et_input.setText(str + ((Button) view).getText());
                break;
            }
            case R.id.btn_clear: {
                store = 0;
                et_input.setText("");
                break;
            }
            case R.id.btn_del: {
                flag = false;
                if (!str.equals("")) {
                    if (str.substring(str.length() - 1).equals(" ")) {
                        et_input.setText(str.substring(0, str.length() - 3));
                    } else {
                        et_input.setText(str.substring(0, str.length() - 1));
                    }
                }
                break;
            }
            case R.id.btn_equal: {
                getResult();
                break;
            }
        }
    }

    /**
     * 按=获取结果函数
     */
    private void getResult() {
        if (flag) {
            flag = false;
            return;
        }
        flag = true;
        double result = 0.0;
        /**
         * x用来储存运算符出现的位置数
         */
        int x = 0;
        String temp = et_input.getText().toString();
        if (temp.equals("")) {
            return;
        }
        if (!temp.contains("+") && !temp.contains("-") && !temp.contains("×") && !temp.contains("÷")) {
            return;
        }
        if(temp.contains("+")){
            x = temp.indexOf("+");
        }else if(temp.contains("-")){
            x = temp.indexOf("-", 1);
        }
        else if(temp.contains("×")){
            x = temp.indexOf("×");
        }
        else if(temp.contains("÷")){
            x = temp.indexOf("÷");
        }
        String s1 = temp.substring(0, x);
        String op = temp.substring(x, x+1);
        String s2 = temp.substring(x+1);

        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "+":
                    result = d1 + d2;
                    break;
                case "-":
                    result = d1 - d2;
                    break;
                case "×":
                    result = d1 * d2;
                    break;
                case "÷":
                    if (d2 == 0) {
                        result = 0;
                    } else {
                        result = d1 / d2;
                    }
                    break;
            }

            if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {
                et_input.setText((long)result + "");
                store =  result;
            } else {
                et_input.setText(result + "");
                store = result;
            }
        }
        else if (!s1.equals("") && s2.equals("")) {
            et_input.setText(s1 + "");
            store = Double.parseDouble(s1);
        }
        else if (s1.equals("") && !s2.equals("")) {
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "+":
                    result = store + d2;
                    break;
                case "-":
                    result = store - d2;
                    break;
                case "×":
                    result = store * d2;
                    break;
                case "÷":
                    if (d2 == 0) {
                        result = 0;
                    } else {
                        result = store / d2;
                    }
                    break;
            }
            if (!s1.contains(".") && !s2.contains(".")) {
                et_input.setText((long)result + "");
                store =  result;
            } else {
                et_input.setText(result + "");
                store = result;
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.imooc.carlisle.calculator/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.imooc.carlisle.calculator/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
