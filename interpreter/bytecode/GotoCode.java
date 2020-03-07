package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode{
    private ArrayList<String> arguments;
    private int destinationAddress;

    @Override
    public void init(ArrayList<String> args) { this.arguments = args; }

    @Override
    public void execute(VirtualMachine virtualMachine) { virtualMachine.setProgramCounter(this.destinationAddress - 1); }

    @Override
    public String toString() {
        return "GOTO " + this.arguments.get(0);
    }

    public ArrayList<String> getArgs() {
        return this.arguments;
    }

    public void setDestinationAddress(int newDestinationAddress) {
        this.destinationAddress = newDestinationAddress;
    }
}
