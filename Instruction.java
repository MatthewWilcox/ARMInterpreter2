package com.example.aweso.arminterpreter;

import java.util.LinkedList;

public class Instruction
{
    private String magicTrick;
    private String[] parameters;

    public Instruction(String instruction)
    {
        instruction = instruction.trim();
        int locationOfFirstSpace = instruction.indexOf(' ');
        this.magicTrick = instruction.substring(0, locationOfFirstSpace);

        String theRest = instruction.substring(locationOfFirstSpace).trim(); //"X0,[X1, 4]"
        this.parameters = theRest.split(","); // ["X0", "[X1", "4]"]
    }

    public void execute()
    {
        if(this.magicTrick.equalsIgnoreCase("ADD"))
        {
            Register destinationRegister = ARMap.findRegisterWithName(this.parameters[0]);
            Register input2Register = ARMap.findRegisterWithName(this.parameters[1]);
            Register input1Register = ARMap.findRegisterWithName(this.parameters[2]);
            destinationRegister.setValue(input2Register.getValue() + input1Register.getValue());
        }
        else if(this.magicTrick.equalsIgnoreCase("SUB"))
        {
            //write the code to Subtract input1 from input2 and store the result in destinationName
            Register destinationRegister = ARMap.findRegisterWithName(this.parameters[0]);
            Register input2Register = ARMap.findRegisterWithName(this.parameters[1]);
            Register input1Register = ARMap.findRegisterWithName(this.parameters[2]);
            destinationRegister.setValue(input2Register.getValue() - input1Register.getValue());
        }
        else if(this.magicTrick.equalsIgnoreCase("ADDI"))
        {
            //write the code to ADD input2 to an immediate value and store the result in destinationName
            Register destinationRegister = ARMap.findRegisterWithName(this.parameters[0]);
            Register input2Register = ARMap.findRegisterWithName(this.parameters[1]);
            int immediateValue = Integer.parseInt(this.parameters[2]);
            destinationRegister.setValue(input2Register.getValue() + immediateValue);
        }
        else if(this.magicTrick.equalsIgnoreCase("SUBI"))
        {
            //write the code to Subtract the immediate value in input1 from input2 and store the result in destinationName
            Register destinationRegister = ARMap.findRegisterWithName(this.parameters[0]);
            Register input2Register = ARMap.findRegisterWithName(this.parameters[1]);
            int immediateValue = Integer.parseInt(this.parameters[2]);
            destinationRegister.setValue(input2Register.getValue() - immediateValue);
        }
        else if(this.magicTrick.equalsIgnoreCase("LDUR"))
        {
            Register destinationRegister = ARMap.findRegisterWithName(this.parameters[0]);
            Register baseRegister = ARMap.findRegisterWithName(this.parameters[1].substring(1));
            String temp = this.parameters[2];
            int offset = Integer.parseInt(temp.substring(0, temp.length()-1));
            int baseAddressValue = baseRegister.getValue();
            int finalMemoryBucket = baseAddressValue + offset;
            destinationRegister.setValue(ARMap.memory[finalMemoryBucket]);
        }
        else if(this.magicTrick.equalsIgnoreCase("STUR"))
        {
            Register sourceRegister = ARMap.findRegisterWithName(this.parameters[0]);
            Register baseRegister = ARMap.findRegisterWithName(this.parameters[1].substring(1));
            String temp = this.parameters[2];
            int offset = Integer.parseInt(temp.substring(0, temp.length()-1));
            int baseAddressValue = baseRegister.getValue();
            int finalMemoryBucket = baseAddressValue + offset;
            ARMap.memory[finalMemoryBucket] = sourceRegister.getValue();
        }
        else if(this.magicTrick.equalsIgnoreCase("MOVZ"))
        {
            Register destinationRegister = ARMap.findRegisterWithName(this.parameters[0]);
            destinationRegister.setValue(Integer.parseInt(this.parameters[1].trim()));
        }
    }
}