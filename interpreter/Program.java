package interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress(Program program) {
        HashMap<String, Integer> label = new HashMap<>();
        for(int i = 0; i < this.program.size(); i++){
            ByteCode byteCode = this.program.get(i);
            if(byteCode instanceof LabelCode)
                label.put(((LabelCode) byteCode).getArgs().get(0), i);

        }

        for(int i = 0; i < this.program.size(); i++){
            ByteCode byteCode = this.program.get(i);
            if(byteCode instanceof FalseBranchCode){
                int value = label.get(((FalseBranchCode) byteCode).getArgs().get(0));
                ((FalseBranchCode) byteCode).setDestinationAddress(value);
            }
            else if (byteCode instanceof GotoCode) {
            int value = label.get(((GotoCode) byteCode).getArgs().get(0));
            ((GotoCode) byteCode).setDestinationAddress(value);
            }
            else if (byteCode instanceof CallCode) {
            int value = label.get(((CallCode) byteCode).getArgs().get(0));
            ((CallCode) byteCode).setDestinationAddress(value);
            }
        }
    }

    private int getSize(){
        return this.program.size();
    }

    protected void addCode(ByteCode byteCode){ this.program.add(byteCode); }
}
