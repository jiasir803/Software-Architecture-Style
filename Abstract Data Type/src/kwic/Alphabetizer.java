package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class Alphabetizer {
    private ArrayList<ArrayList<String>> words;

    public void receiveWords(ArrayList<ArrayList<String>> shiftedWords){
        this.words=shiftedWords;
    }

    public ArrayList<ArrayList<String>> getSortedWords(){
        return this.words;
    }

    public void sortWords(){
        for(int i=1;i<words.size();i++){
            String word=words.get(i).get(0);
            ArrayList<String> line=words.get(i);
            int index=0;
            for(index=i-1;index>=0;index--){
                String compareWord=words.get(index).get(0);
                if(word.compareTo(compareWord)<0){
                    words.set(index+1,words.get(index));
                }else{
                    break;
                }
            }
            words.set(index+1,line);
        }
    }
}
