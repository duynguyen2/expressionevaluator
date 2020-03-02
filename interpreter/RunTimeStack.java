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

    public void dump(){
        String str = "";
        for(int i = 0; i < framePointer.size(); i++){
            str = "[";
            if(i == framePointer.size() - 1)
                for(int j = framePointer.peek(); j < runTimeStack.size(); j++)
                    str += runTimeStack.get(j) + ",";

            else{
                int index = framePointer.get(i + 1);
                for(int k = framePointer.get(i); k < framePointer.get(i) + index; k++)
                    str += runTimeStack.get(k) + ",";

            }

            if(str.charAt(str.length() - 1) == ',')
                str = str.substring(0, str.length() - 1);

            str += "]";
        }
        System.out.println(str);
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
