package com.tempconverter.saisreenivas.temperatureconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button convertToCelsius;
    private Button convertToFarh;
    private EditText inputValue;
    private TextView convertedValue;

    java.text.DecimalFormat round = new java.text.DecimalFormat("0.00");
    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertToCelsius = (Button) findViewById(R.id.cButton);
        convertToFarh = (Button) findViewById(R.id.fButton);
        inputValue = (EditText) findViewById(R.id.editTextInput);
        convertedValue = (TextView) findViewById(R.id.result);

        convertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String convertFrom = inputValue.getText().toString();
                if(convertFrom.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                }else{
                    double convertInitial = Double.parseDouble(convertFrom);
                    double output = convertToCel(convertInitial);
                    String result = String.valueOf(round.format(output));
                    convertedValue.setText(result + " C");
                    Log.v(TAG, "Hello from here");
                }

            }
        });

        convertToFarh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String convertFrom = inputValue.getText().toString();
                if(convertFrom.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                }else{
                    double convertInitial = Double.parseDouble(convertFrom);
                    double output = convertToFar(convertInitial);
                    String result = String.valueOf(output);
                    convertedValue.setText(result + " F");
                    Log.d(TAG, "Hello Again");
                }

            }
        });
    }

    public double convertToCel(double Farh){

        double result = (Farh - 32) *5/9;

        return result;
    }

    public double convertToFar(double Cel){

        double result = (Cel)*9/5 + 32;

        return result;
    }

}
