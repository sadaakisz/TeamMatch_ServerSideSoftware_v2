public class OnlineState implements State {
    public void doAction(Context context){
        System.out.println("Player is online.");
        context.setState(this);
    }
    public String toString(){
        return "Online State";
    }
}