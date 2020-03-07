package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String str;
    private boolean dumpChange;

    @Override
    public void init(ArrayList<String> args){
        this.str = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        if(this.str.equals("ON"))
            this.dumpChange = true;
        else
            this.dumpChange = false;

        virtualMachine.getRunTimeStack().dump();
    }

    public String toString() { return "DUMP " + str; }

}
