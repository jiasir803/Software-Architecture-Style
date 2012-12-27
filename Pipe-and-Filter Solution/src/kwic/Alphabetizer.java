package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:36
 * To change this template use File | Settings | File Templates.
 */
public class Alphabetizer extends Filter{

    @Override
    public ArrayList<ArrayList<String>> doFilter() {
        for(int i=1;i<in_words.size();i++){
            String word=in_words.get(i).get(0);
            ArrayList<String> line=in_words.get(i);
            int index=0;
            for(index=i-1;index>=0;index--){
                String compareWord=in_words.get(index).get(0);
                if(word.compareTo(compareWord)<0){
                    in_words.set(index+1,in_words.get(index));
                }else{
                    break;
                }
            }
            in_words.set(index+1,line);
        }
        return in_words;
    }
}
