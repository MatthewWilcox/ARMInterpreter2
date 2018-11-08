package com.example.aweso.arminterpreter;

import java.util.Arrays;

public class BinaryValue
{
    private int numberOfBits;
    private byte[] theBits;

    public BinaryValue(int numberOfBits)
    {
        this.numberOfBits = numberOfBits;
        this.theBits = new byte[numberOfBits];
        Arrays.fill(this.theBits, (byte)0);
    }

    public void display()
    {
        String answer = "";
        for(int i = 0; i < this.theBits.length; i++)
        {
            answer += this.theBits[i];
        }
        System.out.println(answer);
    }

    public BinaryValue(String bin)
    {
        //this.numberOfBits = bin.length();
        //this.theBits = new byte[this.numberOfBits];
        this(bin.length());
        for(int i = 0; i < bin.length(); i++)
        {
            this.theBits[i] = bin.charAt(i) == '0'? (byte)0:(byte)1;
        }
    }
}
