package com.lolodmc70;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;
import androidx.appcompat.app.AppCompatActivity;



public class HomeActivity extends AppCompatActivity {

    double num1=0,num2=0;
    boolean Addition,Decimal,Subtract,Multiplication,Remainder,Division;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Button AC = findViewById(R.id.AC_buttom);
        Button plusDivMoins = findViewById(R.id.plusdivmoins_butom);
        Button refresh = findViewById(R.id.Refresh_buttom);
        Button mod = findViewById(R.id.mod_button);
        Button div = findViewById(R.id.div_button);
        Button mult = findViewById(R.id.mult_button);
        Button moins = findViewById(R.id.moins_button);
        Button plus = findViewById(R.id.plus_button);
        Button equals = findViewById(R.id.equals_button);
        Button nine = findViewById(R.id.nine_button);
        Button eight = findViewById(R.id.eight_buttom);
        Button seven = findViewById(R.id.seven_buttom);
        Button six = findViewById(R.id.six_button);
        Button five = findViewById(R.id.five_buttom);
        Button four = findViewById(R.id.four_buttom);
        Button three = findViewById(R.id.three_button);
        Button two = findViewById(R.id.two_buttom);
        Button one = findViewById(R.id.one_buttom);
        Button zero = findViewById(R.id.zero_buttom);
        Button point = findViewById(R.id.point_button);
        TextView result =  findViewById(R.id.result);
        EditText operation =  findViewById(R.id.operation);

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Decimal){

                }else{
            operation.setText(operation.getText()+".");
            Decimal=true;
                }
            }
        });

       /* AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText("");
                num1=0;
                num2=0;
            }
        });*/
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText("");
                result.setText("");
                num1=0;
                num2=0;
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userexp = operation.getText().toString();
                userexp.replaceAll("÷","/");
                userexp.replaceAll("×","*");

                Expression exp = new Expression(userexp);
                String result = String.valueOf(exp.calculate());

                operation.setText(result);
                operation.setSelection(result.length());

            }
        });


        plusDivMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(operation.getText().length() !=0 ){

                     num1=Float.parseFloat(operation.getText()+"");
                     Addition = true;
                     Decimal = false;
                     //operation.setText(null);
                     updateText("+");
               }
            }
        });

        moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length() !=0 ){

                    num1=Float.parseFloat(operation.getText()+"");
                    Subtract = true;
                    Decimal = false;
                   // operation.setText(null);
                    updateText("-");
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length() !=0 ){

                    num1=Float.parseFloat(operation.getText()+"");
                    Multiplication = true;
                    Decimal = false;
                 //   operation.setText(null);
                    updateText("×");
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length() !=0 ){

                    num1=Float.parseFloat(operation.getText()+"");
                    Division = true;
                    Decimal = false;
                    updateText("÷");
                    //operation.setText(null);
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                if(operation.getText().length() !=0 ){

                    num1=Float.parseFloat(operation.getText()+"");
                    Remainder = true;
                    Decimal = false;
                   // operation.setText(null);
                }
             }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("0");
                updateText("0");

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("1");
                updateText("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("2");
                updateText("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("3");
                updateText("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("4");
                updateText("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("5");
                updateText("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("6");
                updateText("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // displayOperation("7");
                updateText("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayOperation("8");
                updateText("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displayOperation("9");
                updateText("9");
            }
        });

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int curPos = operation.getSelectionStart();
                int txtLen = operation.getText().length();

                if(curPos != 0 && txtLen != 0 ){
                    SpannableStringBuilder section = (SpannableStringBuilder) operation.getText();
                    section.replace(curPos-1,curPos,"");
                    operation.setText(section);
                    operation.setSelection(curPos-1);
                }
            }
        });
    }



    private void displayOperation(String val) {
        TextView operation =  findViewById(R.id.operation);

        operation.setText(operation.getText()+""+val);
    }


    private void updateText(String strToAdd){
        EditText operation =  findViewById(R.id.operation);
       String oldStr = operation.getText().toString();
       int curPos = operation.getSelectionStart();
       String left = oldStr.substring(0,curPos);
        String right = oldStr.substring(curPos);
        if(getString(R.string.operation).equals(operation.getText().toString())){
            operation.setText(strToAdd);
        }
        else{
            operation.setText(String.format("%s%s%s",left,strToAdd,right));
            operation.setSelection(curPos+1);
        }


    }


}
