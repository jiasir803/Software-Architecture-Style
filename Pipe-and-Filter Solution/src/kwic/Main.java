package kwic;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午12:23
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]){
        Filter input=new Inputer();
        Filter circularShifter=new CircularShifter();
        Filter Alphabetizer=new Alphabetizer();
        Filter output=new Outputer();

        Pipe pipe1=new TextLinePipe();
        Pipe pipe2=new TextLinePipe();
        Pipe pipe3=new TextLinePipe();

        input.register_out_Pipe(pipe1);
        pipe1.register_out_filter(circularShifter);
        circularShifter.register_out_Pipe(pipe2);
        pipe2.register_out_filter(Alphabetizer);
        Alphabetizer.register_out_Pipe(pipe3);
        pipe3.register_out_filter(output);

        input.perform(null);
    }
}
