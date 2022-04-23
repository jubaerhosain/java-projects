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

    public boolean studentSignUp(String fileName, Student student) {
        List<Object> students =  getInformation(fileName);
        try {
            for(Object object: students) {
                Student currentObject = (Student) object;
                if(student.matchEmail(currentObject.getEmail()))
                    return false;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException at StudentSignUp.");
        }
        objectIO.appendObject(fileName, student);
        return true;
    }

    public boolean teacherSignUp(String fileName, Teacher teacher) {
        List<Object> teachers =  getInformation(fileName);
        try {
            for(Object object: teachers) {
                Teacher currentObject = (Teacher) object;
                if(teacher.matchEmail(currentObject.getEmail()))
                    return false;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException at TeacherSignUp.");
        }
        objectIO.appendObject(fileName, teacher);
        return true;
    }

    public boolean studentLogIn(String fileName, EMPair emPair) {
        List<Object> personList = objectIO.readObjects(fileName);
        for(Object person: personList) {
            Student student = (Student) person;
            if(student.matchEmail(emPair.getEmail()) && student.matchPassword(emPair.getPassword()))
                return true;
        }
        return false;
    }

    public boolean teacherLogIn(String fileName, EMPair emPair) {
        List<Object> personList = objectIO.readObjects(fileName);
        for(Object person: personList) {
            Teacher teacher = (Teacher) person;
            if(teacher.matchEmail(emPair.getEmail()) && teacher.matchPassword(emPair.getPassword()))
                return true;
        }
        return false;
    }

    public List<Object> getInformation(String fileName) {
        return objectIO.readObjects(fileName);
    }
}
