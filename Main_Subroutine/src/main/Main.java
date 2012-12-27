package main;

import java.io.*;
import java.util.ArrayList;


public class Main {
    private static final String INPUT_FILE_PATH="input.txt";
    private static final String OUTPUT_FILE_PATH="outpur.txt";

    private static ArrayList<String> textWords=new ArrayList<String>();
    private static ArrayList<ArrayList<Integer>> shiftedLineIndexs=new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> sortedLineIndexs=new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> linePositions=new ArrayList<Integer>();

    public static void main(String args[]){
        input();
        circularShift();
        alphabetizer();
        output();
        System.out.println("Complete!");
    }


    private static void input(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(INPUT_FILE_PATH));
            String line=reader.readLine();
            while (line!=null){
                String[] words=line.split(" ");
                linePositions.add(textWords.size());
                for(int i=0;i<words.length;i++){
                    textWords.add(words[i]);
                }
                line=reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

    private static void circularShift(){
        for(int i=0;i<linePositions.size();i++){
            int size=0;
            if(i!=linePositions.size()-1)
                size=linePositions.get(i+1)-linePositions.get(i);
            else
                size=textWords.size()-linePositions.get(i);

            int firstWordsIndex=linePositions.get(i);
            for(int j=0;j<size;j++){
                ArrayList<Integer> shiftedWordsIndexs=new ArrayList<Integer>();
                for(int k=0;k<size;k++){
                    shiftedWordsIndexs.add(firstWordsIndex+((j+k)%size));
                }
                shiftedLineIndexs.add(shiftedWordsIndexs);
            }
        }
    }

    private static void alphabetizer(){
        for(int i=0;i<shiftedLineIndexs.size();i++){
            sortedLineIndexs.add(shiftedLineIndexs.get(i));
        }
        for(int i=1;i<sortedLineIndexs.size();i++){
            String word=textWords.get(sortedLineIndexs.get(i).get(0));
            int index=0;
            for(index=i-1;index>=0;index--){
                String compareWord=textWords.get(sortedLineIndexs.get(index).get(0));
                if(word.compareTo(compareWord)<0){
                    sortedLineIndexs.set(index+1,sortedLineIndexs.get(index));
                }else{
                    break;
                }
            }
            sortedLineIndexs.set(index+1,shiftedLineIndexs.get(i));
        }
    }

    private static void output(){
        try {
            PrintWriter writer=new PrintWriter(new FileOutputStream(OUTPUT_FILE_PATH));
            for(int i=0;i<sortedLineIndexs.size();i++){
                String outString="";
                for(int j=0;j<sortedLineIndexs.get(i).size();j++){
                    outString+=textWords.get(sortedLineIndexs.get(i).get(j));
                    outString+=" ";
                }
                writer.println(outString);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
