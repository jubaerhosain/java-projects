package server_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectIO {

    public ObjectIO() {

    }

    public synchronized void appendObject(String fileName, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage() + ", " + this.getClass());
        }
    }

    public synchronized List<Object> readObjects(String fileName) {
        List<Object> objects = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            while (fis.available() != 0) {
                // create a new ObjectInputStream each time
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object object =  ois.readObject();
                objects.add(object);
            }
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage() + ", " + this.getClass());
        }

        return objects;
    }
}















