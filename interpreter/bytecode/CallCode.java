package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    private ArrayList<String> arguments;
    private int destinationAddress;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(destinationAddress - 1);
    }

    public String toString() {
        String string = "CALL " + this.getArgs().get(0) + "        ", arg = this.arguments.get(0);
        int baseID = arg.indexOf("<<");
        for(int i = 0; i < baseID; i++)
            string += arg.charAt(i);

        if(baseID == -1)
            string += arguments.get(0);

        return string;
    }

    public ArrayList<String> getArgs(){
        return this.arguments;
    }

    public void setDestinationAddress(int newDestinationAddress){
        this.destinationAddress = newDestinationAddress;
    }
}
