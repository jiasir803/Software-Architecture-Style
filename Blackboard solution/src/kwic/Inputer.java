package kwic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class Inputer implements KnowldgeSource{
    private final String INPUT_FILE_PATH="input.txt";

    @Override
    public void applyKnowledge(Blackboard blackboard) {
        ArrayList<ArrayList<String>> textWords=new ArrayList<ArrayList<String>>();

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

        blackboard.refreshTextLines(textWords);
    }
}
