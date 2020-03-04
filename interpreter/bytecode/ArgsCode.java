package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAt(Integer.parseInt(this.arguments.get(0)));
    }

    @Override
    public String toString() {
        return "ARGS " + Integer.parseInt(this.arguments.get(0));
    }
}
