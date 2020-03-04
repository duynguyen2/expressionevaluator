package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void dump(){
        Iterator it = this.framePointer.iterator();
        int nextFrame, currentFrame = (Integer) it.next();
        for (int i = 0; i < this.framePointer.size(); i++) {
            if (it.hasNext()) {
                nextFrame = (Integer) it.next();
            } else {
                nextFrame = this.runTimeStack.size();
            }

            System.out.print("[");

            for (int j = currentFrame; j < nextFrame; j++) {
                System.out.print(this.runTimeStack.get(j));
                if (j != nextFrame - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            currentFrame = nextFrame;
        }
        System.out.println();
    }

    public int peek(){
        if(runTimeStack.isEmpty())
            return 0;
        else
            return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    public int pop(){
        if(runTimeStack.size() == 0)
            System.exit(-1);

        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    public int store(int offset){
        int value = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, value);
        return value;
    }

    public int load(int offset){
        int value = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offset){ framePointer.push(runTimeStack.size() - offset); }

    public void popFrame(){
        int n = runTimeStack.get(runTimeStack.size() - 1);
        while(runTimeStack.size() != framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size() - 1 );
        }
        framePointer.pop();
        runTimeStack.add(n);
    }
}
