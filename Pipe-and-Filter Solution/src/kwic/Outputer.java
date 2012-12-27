package kwic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:36
 * To change this template use File | Settings | File Templates.
 */
public class Outputer extends  Filter{
    private final String OUTPUT_FILE_PATH="outpur.txt";

    @Override
    public ArrayList<ArrayList<String>> doFilter() {
        try {
            PrintWriter writer=new PrintWriter(new FileOutputStream(OUTPUT_FILE_PATH));
            for(int i=0;i<in_words.size();i++){
                String outString="";
                for(int j=0;j<in_words.get(i).size();j++){
                    outString+=in_words.get(i).get(j);
                    outString+=" ";
                }
                writer.println(outString);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
