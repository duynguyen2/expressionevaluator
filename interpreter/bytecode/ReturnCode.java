package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    private ArrayList<String> arguments;
    private String function = "";
    private int value;

    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty())
            this.function = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.popFrameStack();
        this.value = virtualMachine.peekRunTimeStack();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
    }

    @Override
    public String toString() {
        String str = "RETURN ", temp = "";
        int baseID = this.function.indexOf("<");
        if(baseID < 0)
            temp = this.function;
        else
            temp = this.function.substring(0,baseID) + "\texit " + this.function.substring(0, baseID) + ": " + this.value;

        return str + temp;
    }

}
