package HW2.domain;



import HW2.Client;
import HW2.repository.Repository;
import HW2.ui.ServerView;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private boolean work;
    private ServerView serverView;
    private List<Client> clientList;
    private Repository repository;

    public Server(ServerView serverView, Repository repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientList = new ArrayList<>();
    }
     public void start(){
        if(work){
            showOnWindow("Сервер уже был запущен");
        } else {
            work = true;
            showOnWindow("Сервер запущен!");
        }
     }

     public void stop(){
        if(!work){
            showOnWindow("Сервер уже был остановлен");
        } else {
            work = false;
            for(Client client: clientList){
                disconnectUser(client);
            }
            showOnWindow("Сервер остановлен!");
        }
     }

     public void disconnectUser(Client client) {
        clientList.remove(client);
        if(client!= null) {
            client.disconnect();
            showOnWindow(client.getName() + " отключился от беседы.");
        }
     }

     public boolean connectUser(Client client){
         if (!work) {
             return false;
         }
         clientList.add(client);
         showOnWindow(client.getName() + " подключился к беседе.");
         return true;
     }

     public void message(String text) {
        if(!work){
            return;
        }
        text += "";
        showOnWindow(text);  // отображаем в текстовом поле
        answerAll(text);  // отправляем всем в чате
        saveInHistory(text); // сохраняем в истории
     }

     /** Метод для возврата истории, при подключении
      * клиента к серверу */
     public String getHistory(){
        return repository.load();
     }

    /** Метод для рассылки всем клиентам сообщении */
     private void answerAll(String text) {
        for (Client client: clientList){
            client.serverAnswer(text);
        }
     }

     /** Метод для обращения к GUI и показа сообщений */
     private void showOnWindow(String text) {
        serverView.showMessage(text + "\n"); }

    /**Метод для сохранения истории переписки клиентов,
     * загружается из репозитория */
    private void saveInHistory(String text){
        repository.save(text);
    }

    public ServerView getServerView() {
        return serverView;
    }
}
