package com.example.aweso.arminterpreter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoryScreen extends AppCompatActivity
{
    private ViewGroup memoryVG;
    private EditText[] theMemoryETs = new EditText[ARMap.MEMORY_SIZE];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_screen);
        this.memoryVG = (ViewGroup)this.findViewById(R.id.memoryVG);
        EditText tempET;
        TextView indexTV;
        LinearLayout horizontalVG;

        for(int i = 0; i < ARMap.MEMORY_SIZE; i++)
        {
            tempET = new EditText(this);
            tempET.setText("" + ARMap.memory[i]);
            tempET.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);

            //save to theMEmoryETs
            this.theMemoryETs[i] = tempET;

            //2 things point to the memory that is stored in tempET

            indexTV = new TextView(this);
            indexTV.setText(i + " : ");
            horizontalVG = new LinearLayout(this);
            horizontalVG.setOrientation(LinearLayout.HORIZONTAL);
            horizontalVG.addView(indexTV);
            horizontalVG.addView(tempET);
            this.memoryVG.addView(horizontalVG);
        }
    }

    public void onSaveButtonClicked(View v)
    {
        for(int i = 0; i < ARMap.MEMORY_SIZE; i++)
        {
            ARMap.memory[i] = Integer.parseInt(this.theMemoryETs[i].getText().toString());
        }
        this.finish();
    }
}