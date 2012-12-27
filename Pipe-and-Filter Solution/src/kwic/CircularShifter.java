package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:36
 * To change this template use File | Settings | File Templates.
 */
public class CircularShifter extends Filter{
    @Override
    public ArrayList<ArrayList<String>> doFilter() {
        ArrayList<ArrayList<String>> shiftedWords=new ArrayList<ArrayList<String>>();
        for(int i=0;i<in_words.size();i++){
            int size=in_words.get(i).size();
            for(int j=0;j<size;j++){
                ArrayList<String> tempShiftedWordsLine=new ArrayList<String>();
                for(int k=0;k<size;k++){
                    tempShiftedWordsLine.add(in_words.get(i).get((j+k)%size));
                }
                shiftedWords.add(tempShiftedWordsLine);
            }
        }
        return shiftedWords;
    }
}
