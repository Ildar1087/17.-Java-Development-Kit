package HW2;






import HW2.ui.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ClientView{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;



    private JTextArea log;
    private JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    private JPasswordField password;
    private JButton btnLogin, btnSend;
    private JPanel headerPanel;
    private Client client;


    public ClientGUI(ServerWindow server){
        this.client = new Client (this, server.getServer());
//        this.server = server;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(server.getX() - 500, server.getY());

        createPanel();

        setVisible(true);
    }

    public void answer(String text){
        appendLog(text);
    }

    /** Метод ввода логина, при котором мы сообщаем серверу,
     * что мы подключились и убираем верхнюю панель */
    private void connectToServer() {
        if (client.connectToServer(tfLogin.getText())){
            hideHeaderPanel(false);
            }
        }


    public void disconnectFromServer() {
            hideHeaderPanel(true);
            client.disconnect();
    }

/** Метод изменения видимости панели */
    private void hideHeaderPanel(boolean visible){
        headerPanel.setVisible(visible);
    }

    /** Метод отправки сообщения из графической оболочки
     * Мы сообщаем клиенту, что хотим отправить сообщение со следующим
     * содержанием. tfMessage.setText("") обнуляет графическое окно
     * */
    private void sendMessage(){
        client.sendMessage(tfMessage.getText());
        tfMessage.setText("");
    }


    /** Метод для добавления на центральное окно сообщения */
    private void createPanel(){
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }
//    public void message(){
//        if (connected){
//            String text = tfMessage.getText();
//            if (!text.equals("")){
//                server.message(name + ": " + text);
//                tfMessage.setText("");
//            }
//        } else {
//            appendLog("Нет подключения к серверу");
//        }
//
//    }

    private void appendLog(String text){
        log.append(text + "\n");
    }


    private Component createHeaderPanel(){
        headerPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Ivan Ivanovich");
        password = new JPasswordField("123456");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel());
        headerPanel.add(tfLogin);
        headerPanel.add(password);
        headerPanel.add(btnLogin);

        return headerPanel;
    }

    private Component createLog(){
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    sendMessage();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
        super.processWindowEvent(e);
    }

    /**Метод выводит сообщение в центральную консоль,
     * при появлении сообщения */
    @Override
    public void sendMessage(String text) {
        appendLog(text); // В лог выводит сообщение
    }
}