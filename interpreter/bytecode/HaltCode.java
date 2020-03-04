package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.halt();
    }

    @Override
    public String toString() {
        return "HALT";
    }

}
