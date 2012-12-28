package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class Alphabetizer implements KnowldgeSource{

    @Override
    public void applyKnowledge(Blackboard blackboard) {
        ArrayList<ArrayList<String>> words=blackboard.getShiftedLines();
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
        blackboard.refreshSortedLines(words);
    }
}
