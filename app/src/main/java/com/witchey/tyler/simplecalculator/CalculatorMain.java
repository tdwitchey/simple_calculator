package com.witchey.tyler.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorMain extends AppCompatActivity {

    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;

    private Button ctrlDel;
    private Button ctrlClear;
    private Button ctrlDiv;
    private Button ctrlMulti;
    private Button ctrlMinus;
    private Button ctrlPlus;
    private Button ctrlEqual;
    private Button ctrlNegative;
    private Button ctrlDecimal;

    private TextView mainDisplay;

    private float mValue1, mValue2;
    private String negativeHolder;

    private boolean addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZero = findViewById(R.id.num0);
        btnOne = findViewById(R.id.num1);
        btnTwo = findViewById(R.id.num2);
        btnThree = findViewById(R.id.num3);
        btnFour = findViewById(R.id.num4);
        btnFive = findViewById(R.id.num5);
        btnSix = findViewById(R.id.num6);
        btnSeven = findViewById(R.id.num7);
        btnEight = findViewById(R.id.num8);
        btnNine = findViewById(R.id.num9);

        ctrlDel = findViewById(R.id.delete);
        ctrlClear = findViewById(R.id.clear);
        ctrlDiv = findViewById(R.id.div);
        ctrlMulti = findViewById(R.id.multi);
        ctrlMinus = findViewById(R.id.minus);
        ctrlPlus = findViewById(R.id.plus);
        ctrlEqual = findViewById(R.id.equal);
        ctrlNegative = findViewById(R.id.negative);
        ctrlDecimal = findViewById(R.id.decimal);

        mainDisplay = findViewById(R.id.mainDisplay);

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "9");
            }
        });

        ctrlDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainDisplay.getText() != null || mainDisplay.getText() != "") {
                    mainDisplay.setText(mainDisplay.getText().subSequence(0, mainDisplay.length() - 1));
                }
                else{
                    mainDisplay.setText(null);
                }
            }
        });

        ctrlClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(null);
            }
        });

        ctrlDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(mainDisplay.getText() + "");
                division = true;
                mainDisplay.setText(null);
            }
        });
        ctrlMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(mainDisplay.getText() + "");
                multiplication = true;
                mainDisplay.setText(null);
            }
        });
        ctrlMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(mainDisplay.getText() + "");
                subtraction = true;
                mainDisplay.setText(null);
            }
        });
        ctrlPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue1 = Float.parseFloat(mainDisplay.getText() + "");
                addition = true;
                mainDisplay.setText(null);
            }
        });

        ctrlEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue2 = Float.parseFloat(mainDisplay.getText() + "");
                if(addition){
                    mainDisplay.setText(mValue1 + mValue2 + "");
                    addition = false;
                }
                if(subtraction){
                    mainDisplay.setText(mValue1 - mValue2 + "");
                    subtraction = false;
                }
                if(multiplication){
                    mainDisplay.setText(mValue1 * mValue2 + "");
                    multiplication = false;
                }
                if(division){
                    mainDisplay.setText(mValue1 / mValue2 + "");
                    division = false;
                }
            }
        });

        ctrlNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainDisplay.getText().charAt(0) == '-'){
                    mainDisplay.setText(mainDisplay.getText().subSequence(1, mainDisplay.length()));
                }
                else{
                    negativeHolder = mainDisplay.getText() + "";
                    mainDisplay.setText('-' + negativeHolder);
                }
            }
        });

        ctrlDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainDisplay.getText() == null || mainDisplay.getText() == ""){
                    mainDisplay.setText("0.");
                }

                int count = 0;
                for (int i = 0; i < mainDisplay.length(); i++){
                    if (mainDisplay.getText().charAt(i) == '.'){
                        count += 1;
                    }
                }
                if (count < 1){
                    mainDisplay.setText(mainDisplay.getText() + ".");
                }
            }
        });
    }
}
