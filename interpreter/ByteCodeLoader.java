
package interpreter;

import interpreter.bytecode.ByteCode;

import javax.swing.text.DefaultEditorKit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts. Can also use the split function in the String class.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String line;
        Program program = new Program();
        try{
            while((line = byteSource.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line);
                String byteCodeName = tokenizer.nextToken(" "), byteCodeClassName = CodeTable.getClassName(byteCodeName);
                Class c = Class.forName("interpreter.bytecode." + byteCodeClassName);
                ByteCode byteCode = (ByteCode) c.getDeclaredConstructor().newInstance();
                ArrayList<String> args = new ArrayList<>();
                while(tokenizer.hasMoreTokens())
                    args.add(tokenizer.nextToken());

                byteCode.init(args);
                program.addCode(byteCode);
            }
        }
        catch(Exception x){
        }

        program.resolveAddress(program);
        return program;
    }

}
