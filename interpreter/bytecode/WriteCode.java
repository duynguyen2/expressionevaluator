package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) { this.arguments = args; }

    @Override
    public void execute(VirtualMachine virtualMachine) { System.out.println(virtualMachine.peekRunTimeStack()); }

    @Override
    public String toString() {
        return "WRITE";
    }
}
