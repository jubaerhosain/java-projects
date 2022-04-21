package server_management;

import com.example.studentmanagement.EMPair;
import com.example.studentmanagement.Student;
import com.example.studentmanagement.Teacher;

import java.util.List;

public class Query {
    private ObjectIO objectIO;

    public Query() {
        this.objectIO = new ObjectIO();
    }

    public boolean signUp(String fileName, Object object) {
        objectIO.appendObject(fileName, object);
        return true;
    }

    public boolean logIn(String fileName, Object pair, String objectType) {
        EMPair emPair = (EMPair) pair;
        List<Object> personList = objectIO.readObjects(fileName);

        if(objectType.equals("student")) {
            for(Object person: personList) {
                Student student = (Student) person;
                if(student.matchEmail(emPair.getEmail()) && student.matchPassword(emPair.getPassword()))
                    return true;
            }
            return false;
        }
        else if(objectType.equals("teacher")) {
            for(Object person: personList) {
                Teacher teacher = (Teacher) person;
                if(teacher.matchEmail(emPair.getEmail()) && teacher.matchPassword(emPair.getPassword()))
                    return true;
            }
            return false;
        }

        return true;
    }

    public List<Object> getInformation(String fileName) {
        List<Object> objects = objectIO.readObjects(fileName);
        return null;
    }
}
