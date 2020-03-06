package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private String str;

    @Override
    public void init(ArrayList<String> args) {
        this.str = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAt(Integer.parseInt(this.str));
    }

    @Override
    public String toString() {
        return "ARGS " + Integer.parseInt(this.str);
    }
}
