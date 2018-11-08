package com.example.aweso.arminterpreter;

public class ArmInstruction
{
    private BinaryValue instruction, destination, shifts, source2, source1;

    public ArmInstruction()
    {
        this.instruction = new BinaryValue(11);
        this.destination = new BinaryValue(5);
        this.shifts = new BinaryValue(6);
        this.source2 = new BinaryValue(5);
        this.source1 = new BinaryValue(5);
    }

    public ArmInstruction(String instruction, String destination, String sourceReg1, String sourceReg2)
    {
        this();

    }
}
