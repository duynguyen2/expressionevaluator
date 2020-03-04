package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.store(Integer.parseInt(this.arguments.get(0)));
    }

    @Override
    public String toString() {
        String str = "STORE " + this.arguments.get(0);
        if (this.arguments.size() == 2)
            str += " " + this.arguments.get(1) + "    " + this.arguments.get(1) + " = ";

        return str;
    }

    public ArrayList<String> getArgs() {
        return arguments;
    }
}
