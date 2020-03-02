package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args){
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        if(arguments.get(0).equals("ON"))
            virtualMachine.dump_on();
        else
            virtualMachine.dump_off();
    }

    public String toString() {
        return ("DUMP " + arguments.get(0));
    }

    public ArrayList<String> getArgs() {
        return this.arguments;
    }
}
