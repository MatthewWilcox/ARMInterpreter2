package com.example.aweso.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARMap.init();
        //ARMap.lookupInstruction("ADD").display();
    }

    public void registersButtonPressed(View v)
    {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    public void executeButtonPressed(View v)
    {
        //Read the instruction from the instructionET and appropriately
        //execute it
        //For example, if instructionET contained: ADD X0, X1, X2
        //Your code should grab the value from X1 and X2, add them
        //together, and store the result in X0
        EditText instructionET = (EditText) findViewById(R.id.instructionET);
        String evaluate = instructionET.getText().toString();
        String[] evaluateThis = evaluate.split(",", 4);
        int storeHere = Integer.parseInt(evaluateThis[1].substring(1));
        int bucketToAddAt = Integer.parseInt(evaluateThis[2].substring(1));
        int secondBucketToAddAt = Integer.parseInt(evaluateThis[3].substring(1));
        int firstValueToAdd = ARMap.registers[bucketToAddAt].getValue();
        int secondValueToAdd = ARMap.registers[secondBucketToAddAt].getValue();
        int answer = firstValueToAdd + secondValueToAdd;
        ARMap.registers[storeHere].setValue(answer);


    }
}
