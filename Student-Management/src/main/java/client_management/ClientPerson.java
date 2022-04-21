package client_management;

import java.util.List;

public interface ClientPerson {
    public <Type> boolean signUp(Type object);
    public <Type> boolean logIn(Type object);
    public List<Object> getInformation();
}
