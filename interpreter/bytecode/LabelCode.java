package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {}

    public String toString() {
        return "LABEL " + arguments.get(0);
    }

    public ArrayList<String> getArgs(){
        return this.arguments;
    }
}
