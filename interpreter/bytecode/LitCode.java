package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LitCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushRunTimeStack(Integer.parseInt(this.arguments.get(0)));
    }

    @Override
    public String toString() {
        String str = "LIT " + this.arguments.get(0);
        if (this.arguments.size() == 2)
            str += " " + this.arguments.get(1) + "\tint " + this.arguments.get(1);

        return str;
    }

    public ArrayList<String> getArgs(){
        return this.arguments;
    }
}
