package kwic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class Outputer implements KnowldgeSource{
    private final String OUTPUT_FILE_PATH="outpur.txt";

    @Override
    public void applyKnowledge(Blackboard blackboard) {
        ArrayList<ArrayList<String>> sortedWords=blackboard.getSortedLines();
        try {
            PrintWriter writer=new PrintWriter(new FileOutputStream(OUTPUT_FILE_PATH));
            for(int i=0;i<sortedWords.size();i++){
                String outString="";
                for(int j=0;j<sortedWords.get(i).size();j++){
                    outString+=sortedWords.get(i).get(j);
                    outString+=" ";
                }
                writer.println(outString);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
