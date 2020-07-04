class MessageData implements Player {
    ArrayList<String> messages;
    int size = messages.size();
    boolean newMessage = false;
    ArrayList<Observer> observerList;
    public MessageData() {
        observerList = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }
    @Override
    public void notifyObservers() {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(newMessage);
        }
    }
    // get latest runs from stadium
    private boolean getLatestMessage() {
        if(size != messages.size()) {
            size = messages.size();
            return true;
        }
        else return false;

    }
    // This method is used update displays
// when data changes
    public void dataChanged() {
//get latest data
        newMessage = getLatestMessage();
        notifyObservers();
    }
}
