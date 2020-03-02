package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    private int n;

    @Override
    public void init(ArrayList<String> args) {
        this.n = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for(int i = 0; i < n; i++)
            virtualMachine.popRunTimeStack();
    }

    public String toString() {
        return "POP " + this.n;
    }

}
