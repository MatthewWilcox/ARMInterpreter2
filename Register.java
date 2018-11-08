package com.example.aweso.arminterpreter;

public class Register
{
    private String humanReadableName; //X13
    private int decimalRegisterNumber; //13
    private String fiveBitBinaryRegisterNumber;//"1101"
    private int value; //the current value of stored in the register

    public Register(String humanReadableName)
    {
        this.humanReadableName = humanReadableName;
        //"X13" -> "13"
        this.decimalRegisterNumber = Integer.parseInt(humanReadableName.substring(1));
        this.fiveBitBinaryRegisterNumber = ARMap.decimalTo5BitBinary(this.decimalRegisterNumber);
        this.value = 0;
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