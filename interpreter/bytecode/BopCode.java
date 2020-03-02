package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode{
    private ArrayList<String> arguments;

    @Override
    public void init(ArrayList<String> args) {
        this.arguments = args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        String operation = this.arguments.get(0);
        int first_operand = 0, second_operand = 0;
        if (operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*") || operation.equals("==") || operation.equals("!=") || operation.equals("<=") || operation.equals(">") || operation.equals(">=") || operation.equals("<") || operation.equals("|") || operation.equals("&")) {
            second_operand = virtualMachine.popRunTimeStack();
            first_operand = virtualMachine.popRunTimeStack();
        }

        switch (operation) {
            case "+":
                virtualMachine.pushRunTimeStack(first_operand + second_operand);
                break;
            case "-":
                virtualMachine.pushRunTimeStack(first_operand - second_operand);
                break;
            case "/":
                virtualMachine.pushRunTimeStack(first_operand / second_operand);
                break;
            case "*":
                virtualMachine.pushRunTimeStack(first_operand * second_operand);
                break;
            case "==":
                int equal = 0;
                if (first_operand == second_operand)
                    equal = 1;

                virtualMachine.pushRunTimeStack(equal);
                break;
            case "!=":
                int notEqual = 0;
                if (first_operand != second_operand)
                    notEqual = 1;

                virtualMachine.pushRunTimeStack(notEqual);
                break;
            case "<=":
                int lessThanEqual = 0;
                if (first_operand <= second_operand)
                    lessThanEqual = 1;

                virtualMachine.pushRunTimeStack(lessThanEqual);
                break;
            case ">=":
                int greaterThanEqual = 0;
                if (first_operand >= second_operand)
                    greaterThanEqual = 1;

                virtualMachine.pushRunTimeStack(greaterThanEqual);
                break;
            case "<":
                int lessThan = 0;
                if (first_operand < second_operand)
                    lessThan = 1;

                virtualMachine.pushRunTimeStack(lessThan);
                break;
            case ">":
                int greaterThan = 0;
                if (first_operand > second_operand)
                    greaterThan = 1;

                virtualMachine.pushRunTimeStack(greaterThan);
                break;
            case "&":
                int and = 0;
                if ((first_operand == 1) && (second_operand == 1))
                    and = 1;

                virtualMachine.pushRunTimeStack(and);
                break;
            case "|":
                int or = 0;
                if ((first_operand == 1) || (second_operand == 1))
                    or = 1;

                virtualMachine.pushRunTimeStack(or);
                break;
        }
    }

}
