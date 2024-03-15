package HW2;


//    static void test(List<Integer> list){
//        if(list instanceof LinkedList<Integer>){ // Если list является LinkedList<Integer>
//            LinkedList<Integer> list1 = (LinkedList<Integer>) list;
//        }
//    }


import HW2.domain.Server;

public class Client {
    private Server server;
    private boolean connected;
    private String name;
    private ClientView view;

    public Client(ClientView view, Server server) {
        this.view = view;
        this.server = server;


    }

    /**
     * Метод подключения к серверу
     * будет сообщать GUI, что пора подключатся
     */
    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            printText("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null) {
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

     /** Метод для проверки отсоединения от сервера
     *  */
     public void disconnect(){
         if(connected){
             connected = false;
             view.disconnectFromServer();
             server.disconnectUser(this);
             printText("Вы были отключены от сервера!");

         }
     }



    /**
     * Метод для отправки сообщения
     * от view. Если сообщение, что-то содержит,
     * то сообщение будет отправлено на сервер,
     * иначе будет выведено сообщение, что нет подключения
     * к серверу
     */

    public void sendMessage(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                server.message(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу!");
        }
    }

    /**
     * Метод показа сообщения
     * пользователю о подключении
     */
    private void printText(String text) {
        view.sendMessage(text);
    }

    /** Сервер нам посылает сообщение
     *  */
    public void serverAnswer(String answer){
        printText(answer);
    }

    public String getName() {
        return name;
    }
}
