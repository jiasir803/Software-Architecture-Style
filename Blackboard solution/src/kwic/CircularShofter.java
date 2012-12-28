package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class CircularShofter implements KnowldgeSource{
    @Override
    public void applyKnowledge(Blackboard blackboard) {
        ArrayList<ArrayList<String>> words=blackboard.getTextLines();
        ArrayList<ArrayList<String>> shiftedWords=new ArrayList<ArrayList<String>>();
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

        blackboard.refreshShiftedLines(shiftedWords);
    }
}
