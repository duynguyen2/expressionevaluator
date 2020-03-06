package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.load(Integer.parseInt(arguments.get(0)));
    }

    @Override
    public String toString() {
        String str = "LOAD " + this.arguments.get(0);
        if (this.arguments.size() == 2)
            str += " " + this.arguments.get(1);

        return str;
    }

    public ArrayList<String> getArgs(){
        return this.arguments;
    }
}
