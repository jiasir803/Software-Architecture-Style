package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午9:50
 * To change this template use File | Settings | File Templates.
 */
public class Event {
    public static final int INPUT=1;
    public static final int ALPHABETIZER=2;
    public static final int CIRCULAR_SHIFTER=3;
    public static final int OUTPUT=4;

    private int source;
    private ArrayList<ArrayList<String>> textLines;

    public Event(int sourceType, ArrayList<ArrayList<String>> textLines) {
        this.source=sourceType;
        this.textLines = textLines;
    }

    public int getSource() {
        return source;
    }


    public ArrayList<ArrayList<String>> getTextLines() {
        return textLines;
    }    public void setTextLines(ArrayList<ArrayList<String>> textLines) {
        this.textLines = textLines;
    }
}
