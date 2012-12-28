package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class Blackboard {
    private static Blackboard instance;
    private ArrayList<ArrayList<String>> textLines=new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> shiftedLines=new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> sortedLines=new ArrayList<ArrayList<String>>();

    private Blackboard(){}

    public static Blackboard getInstance(){
        if(instance==null){
            return instance=new Blackboard();
        }
        else{
            return instance;
        }
    }

    public void addTextLines(ArrayList<String> line){
        textLines.add(line);
    }
    public void addShiftedLines(ArrayList<String> line){
        shiftedLines.add(line);
    }
    public void addSortedLines(ArrayList<String> line){
        sortedLines.add(line);
    }

    public void refreshTextLines(ArrayList<ArrayList<String>> lines){
        textLines=lines;
    }
    public void refreshShiftedLines(ArrayList<ArrayList<String>> lines){
        shiftedLines=lines;
    }
    public void refreshSortedLines(ArrayList<ArrayList<String>> lines){
        sortedLines=lines;
    }

    public ArrayList<ArrayList<String>> getTextLines() {
        return textLines;
    }

    public ArrayList<ArrayList<String>> getShiftedLines() {
        return shiftedLines;
    }

    public ArrayList<ArrayList<String>> getSortedLines() {
        return sortedLines;
    }
}
