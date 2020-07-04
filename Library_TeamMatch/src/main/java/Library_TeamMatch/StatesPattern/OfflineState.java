public class OfflineState implements State {
    public void doAction(Context context){
        System.out.println("Player is offline.");
        context.setState(this);
    }
    public String toString(){
        return "Offline State";
    }
}