package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class Filter {
    private Pipe pipe;
    protected ArrayList<ArrayList<String>> in_words=new ArrayList<ArrayList<String>>();
    protected ArrayList<ArrayList<String>> out_words=new ArrayList<ArrayList<String>>();

    public void register_out_Pipe(Pipe pipe){
        this.pipe=pipe;
    }

    public abstract ArrayList<ArrayList<String>> doFilter();
    public void perform(ArrayList<ArrayList<String>> words){
        if (words!=null)
            this.in_words=words;
        out_words=doFilter();
        if(pipe!=null)
            pipe.receive(out_words);
    }

}
