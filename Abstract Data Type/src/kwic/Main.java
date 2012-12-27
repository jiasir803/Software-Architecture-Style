package kwic;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]){
        InputStore inputStore=new InputStore();
        inputStore.intput();

        CircularShifter circularShifter=new CircularShifter();
        circularShifter.receiveWords(inputStore.getWords());
        circularShifter.shift();

        Alphabetizer alphabetizer=new Alphabetizer();
        alphabetizer.receiveWords(circularShifter.getShiftedWords());
        alphabetizer.sortWords();

        Outputer outputer=new Outputer();
        outputer.setWords(alphabetizer.getSortedWords());
        outputer.output();
    }
}
