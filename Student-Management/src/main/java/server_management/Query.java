package server_management;

import com.example.studentmanagement.EMPair;
import com.example.studentmanagement.Person;
import com.example.studentmanagement.Student;
import com.example.studentmanagement.Teacher;

import java.util.List;

public class Query {
    private ObjectIO objectIO;

    public Query() {
        this.objectIO = new ObjectIO();
    }

    public boolean signUp(String fileName, Object object) {
        Person person = (Person) object;
        List<Object> objects =  getInformation(fileName);
        try {
            for(Object obj: objects) {
                Person current = (Person) obj;
                if(person.matchEmail(current.getEmail()))
                    return false;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException at SignUp.");
        }
        objectIO.appendObject(fileName, object);
        return true;
    }

    public boolean logIn(String fileName, EMPair emPair) {
        List<Object> personList = objectIO.readObjects(fileName);
        for(Object obj: personList) {
            Person current = (Person) obj;
            if(current.matchEmail(emPair.getEmail()) && current.matchPassword(emPair.getPassword()))
                return true;
        }
        return false;
    }

    public List<Object> getInformation(String fileName) {
        return objectIO.readObjects(fileName);
    }
}
