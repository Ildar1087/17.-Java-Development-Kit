package HW2;

/** В этом интерфейсе прописываются методы,
 * которые будут необходимы клиенту, для обращения к GUI */
public interface ClientView { // View графическая часть, что он должен делать
    void sendMessage(String message);
    void disconnectFromServer();


}
