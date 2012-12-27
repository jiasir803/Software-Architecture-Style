package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class Alphabetizer implements ShiftListener{
    @Override
    public void perform(Event event) {
        System.out.println("alphabetizer perform");
        ArrayList<ArrayList<String>> words=event.getTextLines();
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
        EventManager eventManager=EventManager.getInstance();
        eventManager.notifyEvent(new Event(Event.ALPHABETIZER,words));
    }
}
