package com.example.aweso.arminterpreter;

import android.content.Intent;

public class Register
{
    private String humanReadableName; //X13
    private int decimalRegisterNumber; //13
    private String fiveBitBinaryRegisterNumber;//"1101"
    private int value; //the current value of stored in the register
    private static int bitSize = 32;

    public Register(String humanReadableName)
    {
        this.humanReadableName = humanReadableName;
        //"X13" -> "13"
        this.decimalRegisterNumber = Integer.parseInt(humanReadableName.substring(1));
        this.fiveBitBinaryRegisterNumber = ARMap.decimalTo5BitBinary(this.decimalRegisterNumber);
        this.value = 0;
    }

    private static String flipBits(String bin)
    {
        String answer = "";
        for(int i = 0; i < bin.length(); i++)
        {
            answer += bin.charAt(i)=='0'?'1':'0';
        }
        return answer;
    }

    public static String toBinaryString(int value)
    {
        if(value < 0)
        {
            String bin = ARMap.decimalToNBitBinary(value * -1, Register.bitSize);
            String flipped = Register.flipBits(bin);
            //String encoded = ARMap.decimalToNBitBinary(Integer.parseInt(flipped, 2) + 1, Register.bitSize);
            long l = Long.parseLong(flipped,2);
            l += 1;
            String twosComp = ARMap.decimalToNBitBinary(l, Register.bitSize);
            return twosComp;
        }
        else
        {
            return ARMap.decimalToNBitBinary(value, Register.bitSize);
        }

    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getHumanReadableName() {
        return humanReadableName;
    }

    public int getDecimalRegisterNumber() {
        return decimalRegisterNumber;
    }

    public String getFiveBitBinaryRegisterNumber() {
        return fiveBitBinaryRegisterNumber;
    }

    public int getValue() {
        return value;
    }
}