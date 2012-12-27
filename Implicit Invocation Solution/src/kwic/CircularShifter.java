package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class CircularShifter implements InputListener{

    @Override
    public void perform(Event event) {
        System.out.println("inputListener perform");
        ArrayList<ArrayList<String>> textLines=event.getTextLines();
        ArrayList<ArrayList<String>> shiftedWords=new ArrayList<ArrayList<String>>();
        for(int i=0;i<textLines.size();i++){
            int size=textLines.get(i).size();
            for(int j=0;j<size;j++){
                ArrayList<String> tempShiftedWordsLine=new ArrayList<String>();
                for(int k=0;k<size;k++){
                    tempShiftedWordsLine.add(textLines.get(i).get((j+k)%size));
                }
                shiftedWords.add(tempShiftedWordsLine);
            }
        }

        EventManager eventManager=EventManager.getInstance();
        eventManager.notifyEvent(new Event(Event.CIRCULAR_SHIFTER,shiftedWords));
    }
}
