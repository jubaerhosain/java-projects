package client_management;

import java.net.Socket;
import java.util.List;

public interface ClientPerson {
    public <Type> boolean signUp(Type object, Socket socket);
    public <Type> boolean logIn(Type object, Socket socket);
    public List<Object> getInformation(Socket socket);
}
