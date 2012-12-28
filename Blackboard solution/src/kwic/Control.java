package kwic;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class Control {
    public void doKwic(){
        Blackboard blackboard=Blackboard.getInstance();
        Inputer inputer=new Inputer();
        CircularShofter circularShofter=new CircularShofter();
        Alphabetizer alphabetizer=new Alphabetizer();
        Outputer outputer=new Outputer();

        inputer.applyKnowledge(blackboard);
        circularShofter.applyKnowledge(blackboard);
        alphabetizer.applyKnowledge(blackboard);
        outputer.applyKnowledge(blackboard);

    }
}
