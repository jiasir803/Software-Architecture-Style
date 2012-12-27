package kwic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class Inputer{
    private final String INPUT_FILE_PATH="input.txt";


    public void input(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(INPUT_FILE_PATH));
            String line=reader.readLine();
            ArrayList<ArrayList<String>> textLines=new ArrayList<ArrayList<String>>();
            while (line!=null){
                String[] words=line.split(" ");
                ArrayList<String> wordsList=new ArrayList<String>();
                for(int i=0;i<words.length;i++){
                    wordsList.add(words[i]);
                }
                textLines.add(wordsList);
                line=reader.readLine();
            }
            EventManager eventManager=EventManager.getInstance();
            eventManager.notifyEvent(new Event(Event.INPUT,textLines));
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e1){
        }
    }
}
