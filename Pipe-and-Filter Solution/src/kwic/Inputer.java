package kwic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:36
 * To change this template use File | Settings | File Templates.
 */
public class Inputer extends Filter{
    private final String INPUT_FILE_PATH="input.txt";
    private ArrayList<ArrayList<String>> textWords=new ArrayList<ArrayList<String>>();

    @Override
    public ArrayList<ArrayList<String>> doFilter() {
        try {
            BufferedReader reader=new BufferedReader(new FileReader(INPUT_FILE_PATH));
            String line=reader.readLine();
            while (line!=null){
                String[] words=line.split(" ");
                ArrayList<String> wordsList=new ArrayList<String>();
                for(int i=0;i<words.length;i++){
                    wordsList.add(words[i]);
                }
                textWords.add(wordsList);
                line=reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e1){
        }
        return textWords;
    }
}
