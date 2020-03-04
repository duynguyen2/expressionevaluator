package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    private ArrayList<String> arguments;
    private int destinationAddress, value;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(destinationAddress - 1);
        this.value = virtualMachine.peekRunTimeStack();
    }

    @Override
    public String toString() {
        String string = "CALL " + this.getArgs().get(0) + "     ", arg = this.arguments.get(0), append = "";
        int baseID = arg.indexOf("<");
        if(baseID < 0)
            append += this.arguments.get(0);
        else
            append += this.arguments.get(0).substring(0, baseID);

        if(this.value > 0)
            string += append + "(" + this.value + ")";
        else
            string += append + "()";

        return string;
    }

    public ArrayList<String> getArgs(){
        return this.arguments;
    }

    public void setDestinationAddress(int newDestinationAddress){
        this.destinationAddress = newDestinationAddress;
    }
}
