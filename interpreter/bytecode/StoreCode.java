package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    private ArrayList<String> arguments;
    private int n;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        n = virtualMachine.store(Integer.parseInt(this.arguments.get(0)));
    }

    @Override
    public String toString() {
        String str = "STORE " + this.arguments.get(0);
        if (this.arguments.size() == 2)
            str += "   " + this.arguments.get(1) + " = ";

        str += n;
        return str;
    }

    public ArrayList<String> getArgs() {
        return arguments;
    }
}
