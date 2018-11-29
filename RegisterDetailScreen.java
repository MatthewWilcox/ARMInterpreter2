package com.example.aweso.arminterpreter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterDetailScreen extends AppCompatActivity
{
    private TextView registerNameTV, decimalValueTV, binaryValueTV;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_detail_screen);
        this.registerNameTV = (TextView)this.findViewById(R.id.registerNameTV);
        this.decimalValueTV = (TextView)this.findViewById(R.id.decimalValueTV);
        this.binaryValueTV = (TextView)this.findViewById(R.id.binaryValueTV);
        String registerName = this.getIntent().getStringExtra("detailRegisterName");
        this.registerNameTV.setText(String.format("%s Register Detail", registerName));

        Register theRegister = ARMap.findRegisterWithName(registerName);
        this.decimalValueTV.setText("" + theRegister.getValue());
        this.binaryValueTV.setText(Register.toBinaryString(theRegister.getValue()));
    }
}