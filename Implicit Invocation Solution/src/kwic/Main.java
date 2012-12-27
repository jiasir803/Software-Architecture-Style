package kwic;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:22
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]){
        EventManager manager=EventManager.getInstance();
        Inputer inputer=new Inputer();
        CircularShifter circularShifter=new CircularShifter();
        Alphabetizer alphabetizer=new Alphabetizer();
        Outputer outputer=new Outputer();

        manager.addInputListener(circularShifter);
        manager.addShiftListeners(alphabetizer);
        manager.addSortListeners(outputer);

        inputer.input();
    }
}
