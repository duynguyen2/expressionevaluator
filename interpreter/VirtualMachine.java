package interpreter;

import java.util.Stack;

import interpreter.bytecode.*;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean isDumping;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while(isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if (isDumping && !(code instanceof DumpCode)) {
                System.out.println(code.toString());
                runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public void dump_off() { isDumping = false; }

    public void dump_on() { isDumping = true; }

    public int popRunTimeStack(){ return runTimeStack.pop(); }

    public void pushRunTimeStack(int newReturnAddress){ runTimeStack.push(newReturnAddress); }

    public int peekRunTimeStack(){ return runTimeStack.peek(); }

    public void popFrameStack(){ runTimeStack.popFrame(); }

    public void newFrameAt(int offset){ runTimeStack.newFrameAt(offset); }

    public void setProgramCounter(int pc){ programCounter = pc; }

    public int getProgramCounter(){ return programCounter; }

    public int popReturnAddress(){ return returnAddress.pop(); }

    public void pushReturnAddress(int newReturnAddress){ returnAddress.push(newReturnAddress); }

    public int store(int offset){ return runTimeStack.store(offset); }

    public int load(int offset){ return runTimeStack.load(offset); }

    public void halt(){ isRunning = false; }
}
