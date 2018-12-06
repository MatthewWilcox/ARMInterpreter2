package com.example.aweso.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;

public class InstructionPickerActivity extends AppCompatActivity
{
    private LinkedList<Button> theButtons = new LinkedList<Button>();
    private EditText instructionET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_picker);

        this.theButtons.add((Button)this.findViewById(R.id.addButton));
        this.theButtons.add((Button)this.findViewById(R.id.addiButton));
        this.theButtons.add((Button)this.findViewById(R.id.subButton));
        this.theButtons.add((Button)this.findViewById(R.id.subiButton));
        this.theButtons.add((Button)this.findViewById(R.id.ldurButton));
        this.theButtons.add((Button)this.findViewById(R.id.sturButton));
        this.theButtons.add((Button)this.findViewById(R.id.movzButton));
    }

    private int indexOfButton(Button b)
    {
        for(int i = 0; i < this.theButtons.size(); i++)
        {
            if(b == this.theButtons.get(i))
            {
                return i;
            }
        }
        return -1;
    }

    public void onInstructionButtonPressed(View v)
    {
        int posOfButton = this.indexOfButton((Button)v);
        this.instructionET = (EditText)this.findViewById(R.id.instructionET);
        String[] instructions = this.instructionET.getText().toString().split("\n");
        String answer = instructions[0];
        for(int i = 1; i < instructions.length; i++)
        {
            answer = answer + "\n" + instructions[i];
        }
        answer = answer + "\n" + (ARMap.instructionSyntaxMap[posOfButton]);
        this.instructionET.setText(answer);
        System.out.println(ARMap.instructionSyntaxMap[posOfButton]);
    }
}