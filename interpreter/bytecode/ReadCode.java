package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) { this.arguments = args; }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        while(!in.hasNextInt()){
            System.out.print("Enter an Integer: ");
            in.next();
        }
        virtualMachine.pushRunTimeStack(in.nextInt());
    }

    @Override
    public String toString() {
        return "READ";
    }
}
