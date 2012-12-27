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
            return instance=new EventManager();
        }
        else{
            return instance;
        }
    }

    public void addInputListener(InputListener listener){
        System.out.println("addInputListener");
        inputListeners.add(listener);
    }

    public void addShiftListeners(ShiftListener listener){
        System.out.println("addShiftListener");
        shiftListeners.add(listener);
    }

    public void addSortListeners(SortListener listener){
        System.out.println("addSortListener");
        sortListeners.add(listener);
    }

    public void notifyEvent(Event event){
        switch (event.getSource()){
            case Event.INPUT:
                System.out.println("input event throw");
                for (InputListener listener:inputListeners){
                    listener.perform(event);
                }
                break;
            case Event.CIRCULAR_SHIFTER:
                System.out.println("circular shifter throw");
                for (ShiftListener listener:shiftListeners){
                    listener.perform(event);
                }
                break;
            case Event.ALPHABETIZER:
                System.out.println("alphabetizer throw");
                for (SortListener listener:sortListeners){
                    listener.perform(event);
                }
                break;
        }
    }
}
