package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    private ArrayList<String> arguments;
    private String function;
    private int destinationAddress, value;

    @Override
    public void init(ArrayList<String> args) {
        this.function = args.get(0);
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
        String str = "CALL ", append;
        int baseID = this.function.indexOf("<");
        if(baseID < 0)
            append = this.function+ "\t" + this.function;
        else
            append = this.function.substring(0, baseID) + "\t" + this.function.substring(0, baseID);

        if(this.value > 0)
            str += append + "(" + this.value + ")";
        else
            str += append + "()";

        return str;
    }

    public ArrayList<String> getArgs(){
        return this.arguments;
    }

    public void setDestinationAddress(int newDestinationAddress){
        this.destinationAddress = newDestinationAddress;
    }
}
