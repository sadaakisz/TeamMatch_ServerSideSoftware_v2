class NewMessage implements Observer {
    private boolean newMessage = false;
    public void update(boolean newMessage) {
        if(newMessage == true) this.newMessage = true;
        display();
        this.newMessage = false;
    }
    public void display() {
        System.out.println("\nNew message: \n");
    }
}