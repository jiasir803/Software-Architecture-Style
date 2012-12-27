package kwic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-27
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class Pipe {
    protected Filter filter;

    public void register_out_filter(Filter filter){
        this.filter=filter;
    }

    public void receive(ArrayList<ArrayList<String>> words){
        filter.perform(words);
    }
}
