package interpreter;

import java.util.Stack;

import interpreter.bytecode.*;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean isDumping = true;

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
                this.runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public RunTimeStack getRunTimeStack(){ return this.runTimeStack; }

    public int popRunTimeStack(){ return this.runTimeStack.pop(); }

    public void pushRunTimeStack(int newReturnAddress){ this.runTimeStack.push(newReturnAddress); }

    public int peekRunTimeStack(){ return this.runTimeStack.peek(); }

    public void popFrameStack(){ this.runTimeStack.popFrame(); }

    public void newFrameAt(int offset){ this.runTimeStack.newFrameAt(offset); }

    public void setProgramCounter(int pc){ this.programCounter = pc; }

    public int getProgramCounter(){ return this.programCounter; }

    public int popReturnAddress(){ return this.returnAddress.pop(); }

    public void pushReturnAddress(int newReturnAddress){ this.returnAddress.push(newReturnAddress); }

    public int store(int offset){ return this.runTimeStack.store(offset); }

    public int load(int offset){ return this.runTimeStack.load(offset); }

    public void halt(){ this.isRunning = false; }
}
