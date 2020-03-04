package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.popFrameStack();
        int returnAddress = virtualMachine.popReturnAddress();
        virtualMachine.setProgramCounter(returnAddress);
    }

    @Override
    public String toString() {
        String str = "RETURN ";

        if (arguments.size() == 1) {
            str += this.arguments.get(0) + "    exit ";
            String arg = this.arguments.get(0);
            int baseID = arg.indexOf("<<");
            for (int i = 0; i < baseID; i++)
                str += arg.charAt(i);

            if (baseID == -1)
                str += this.arguments.get(0);

            str += ":";
        }

        return str;
    }

    public ArrayList<String> getArgs() {
        return this.arguments;
    }

}
