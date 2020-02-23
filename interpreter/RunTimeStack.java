package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(VirtualMachine virtualMachine){
        System.out.println(virtualMachine);
    }

    public int peek(){
        if(runTimeStack.isEmpty()){
            System.out.println("PEEK: Empty");
            return 0;
        }
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    public int pop(){
        if(runTimeStack.size() == 0){
            System.out.println("Empty runtimestack");
            System.exit(-2);
        }
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    public int store(int offset){
        if(runTimeStack.isEmpty()){
            System.out.println("Empty runtimestack");
            System.exit(-4);
        }
        int n = this.pop();
        runTimeStack.add(framePointer.peek() - offset, n);
        return n;
    }

    public int load(int offset){
        if(runTimeStack.isEmpty()){
            System.out.println("Empty runtimestack");
        }
        int n = runTimeStack.get(framePointer.peek() - offset);
        this.push(n);
        return n;
    }

    public int newFrameAt(int offset){
        int n = runTimeStack.get(framePointer.peek() - offset);
        framePointer.push(n);
        return n;
    }

    public void popFrame(){
        int value = this.peek();
        int fp = framePointer.pop();
        while(runTimeStack.size() >= fp){
            if(runTimeStack.isEmpty()){
                System.out.println("Empty runtimestack");
                System.exit(-3);
            }
            this.pop();
        }
        this.push(value);
    }
}
