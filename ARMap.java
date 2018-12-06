package com.example.aweso.arminterpreter;

import java.util.Arrays;

public class ARMap
{
    //Final Fields
    public static final int MEMORY_SIZE = 64;
    private static String[] instructions = {"ADD", "SUB"};
    private static int[] instructionMappings = {1112, 1624};
    public static Register[] registers = new Register[31];
    public static int[] memory = new int[ARMap.MEMORY_SIZE];
    public static String[] instructionSyntaxMap = {
            "ADD DestReg, SrcReg1, SrcReg2",
            "ADDI DestReg, SrcReg1, Immediate",
            "SUB DestReg, SrcReg1, SrcReg2",
            "SUBI DestReg, SrcReg1, Immediate",
            "LDUR DestReg, [BaseAddressReg, Offset]",
            "STUR SrcReg, [BaseAddressReg, Offset]",
            "MOVZ DestReg, Immediate"
    };

    public static void init()
    {
        //initialize memory
        Arrays.fill(ARMap.memory, 0);

        for(int i = 0; i < ARMap.registers.length; i++)
        {
            ARMap.registers[i] = new Register("X" + i);
        }
    }

    public static Register findRegisterWithName(String nameOfRegister)
    {
        for(Register r : ARMap.registers)
        {
            if(r.getHumanReadableName().equalsIgnoreCase(nameOfRegister))
            {
                return r;
            }
        }
        return null;
    }

    public static BinaryValue lookupInstruction(String instruction)
    {
        instruction = instruction.toUpperCase();
        for(int i = 0; i < instructions.length; i++)
        {
            if(instructions[i].equals(instruction))
            {
                return new BinaryValue(decimalTo11BitBinary(instructionMappings[i]));
            }
        }
        return null;  //we assume every mapping is found, so this should never get hit!
    }

    public static String decimalTo5BitBinary(int opCode)
    {
        return ARMap.decimalToNBitBinary(opCode, 5);
    }

    private static String decimalTo11BitBinary(int opCode)
    {
        return ARMap.decimalToNBitBinary(opCode, 11);
    }

    public static String decimalToNBitBinary(long opCode, int numBits)
    {
        String answer = "";
        while(opCode > 0)
        {
            answer = (opCode%2) + answer;
            opCode /= 2;
        }

        for(int i = answer.length(); i < numBits; i++)
        {
            answer = 0 + answer;
        }
        return answer;
    }
}