package com.example.aweso.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public EditText instructionET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARMap.init();

        this.instructionET = (EditText)this.findViewById(R.id.instructionET);
        //ARMap.lookupInstruction("ADD").display();
    }

    public void registersButtonPressed(View v)
    {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    public void memoryButtonPressed(View v)
    {
        Intent i = new Intent(this, MemoryScreen.class);
        this.startActivity(i);
    }

    public void executeButtonPressed(View v)
    {
        //Read the instruction from the instructionET and appropriately
        //execute it
        //For example, if instructionET contained: ADD X0, X1, X2
        //Your code should grab the value from X1 and X2, add them
        //together, and store the result in X0
        String s = this.instructionET.getText().toString();
        String[] instructions = s.split("\n");
        System.out.println(instructions.length);
        for(int i = 0; i < instructions.length; i++)
        {
            Instruction instr = new Instruction(instructions[i]); //"ADD X0,X1,    X2"
            instr.execute();
        }
        Toast.makeText(this, "Execution Complete", Toast.LENGTH_SHORT).show();
    }

    public void addInstructionButtonPressed(View v)
    {
        Intent i = new Intent(this, InstructionPickerActivity.class);
        this.startActivity(i);
    }

    public void clearButtonPressed(View v)
    {
        this.instructionET.setText("");
    }

    public void removeLastButtonPressed(View v)
    {
        String[] instructions = this.instructionET.getText().toString().split("\n");
        String answer = instructions[0];
        for(int i = 1; i < instructions.length-1; i++)
        {
            answer = answer + "\n" + instructions[i];
        }
        this.instructionET.setText(answer);
    }
}