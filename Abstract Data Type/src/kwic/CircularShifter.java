package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class CircularShifter {
    private ArrayList<ArrayList<String>> words;
    private ArrayList<ArrayList<String>> shiftedWords=new ArrayList<ArrayList<String>>();

    public void shift(){
        for(int i=0;i<words.size();i++){
            int size=words.get(i).size();
            for(int j=0;j<size;j++){
                ArrayList<String> tempShiftedWordsLine=new ArrayList<String>();
                for(int k=0;k<size;k++){
                    tempShiftedWordsLine.add(words.get(i).get((j+k)%size));
                }
                shiftedWords.add(tempShiftedWordsLine);
            }
        }
    }

    public ArrayList<ArrayList<String>> getShiftedWords() {
        return shiftedWords;
    }

    public void receiveWords(ArrayList<ArrayList<String>> words) {
        this.words = words;
    }
}
