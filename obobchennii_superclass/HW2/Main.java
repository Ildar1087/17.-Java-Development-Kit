package HW2;


import HW2.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
