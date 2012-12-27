package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public class EventManager {
    private ArrayList<InputListener> inputListeners=new ArrayList<InputListener>();
    private ArrayList<ShiftListener> shiftListeners=new ArrayList<ShiftListener>();
    private ArrayList<SortListener> sortListeners=new ArrayList<SortListener>();

    private static EventManager instance;
    private EventManager(){}

    public static EventManager getInstance(){
        if(instance==null){
            return new EventManager();
        }
        else{
            return instance;
        }
    }

    public void addInputListener(InputListener listener){
        inputListeners.add(listener);
    }

    public void addShiftListeners(ShiftListener listener){
        shiftListeners.add(listener);
    }

    public void addSortListeners(SortListener listener){
        sortListeners.add(listener);
    }

    public void notifyEvent(Event event){
        switch (event.getSource()){
            case Event.INPUT:
                for (InputListener listener:inputListeners){
                    listener.perform(event);
                }
                break;
            case Event.CIRCULAR_SHIFTER:
                for (ShiftListener listener:shiftListeners){
                    listener.perform(event);
                }
                break;
            case Event.ALPHABETIZER:
                for (SortListener listener:sortListeners){
                    listener.perform(event);
                }
                break;
        }
    }
}
