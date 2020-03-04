package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode{
    private ArrayList<String> arguments;
    private int destinationAddress;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int bool = virtualMachine.popRunTimeStack();
        if(bool == 0)
            virtualMachine.setProgramCounter(destinationAddress - 1);
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + arguments.get(0);
    }

    public ArrayList<String> getArgs() {
        return this.arguments;
    }

    public void setDestinationAddress(int newDestinationAddress) {
        this.destinationAddress = newDestinationAddress;
    }
}
