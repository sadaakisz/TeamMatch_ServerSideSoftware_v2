public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        OnlineState onlineState = new OnlineState();
        onlineState.doAction(context);

        System.out.println(context.getState().toString());

        OfflineState offlineState = new OfflineState();
        offlineState.doAction(context);

        System.out.println(context.getState().toString());
    }
}