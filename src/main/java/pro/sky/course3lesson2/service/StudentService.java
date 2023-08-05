package pro.sky.course3lesson2.service;

//import org.springframework.http.HttpStatusCode;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.course3lesson2.model.Student;

import java.util.HashMap;

@Service
public class StudentService {

    private HashMap<Long, Student> students = new HashMap<>();
    private long totalNumberOfStudent;

    public StudentService(HashMap<Long, Student> students) {
        this.students = students;
    }

    //    CRUD

    public Student createStudent(Student student) {
        Student returnStudent = students.put(Long.valueOf(student.getId()), student);
        return returnStudent;
    }

    public Student readStudent(long id) {
        return students.get(Long.valueOf(id));
    }

    public Student updateStudent(long id, String newName, int newAge) {
        if (checkStudentData(newName, newAge)) {
            Long key = Long.valueOf(id);
            students.get(key).setName(newName);
            students.get(key).setAge(newAge);
            return students.get(key);
        } else {
            return (Student) ResponseEntity.status(410);
        }
    }

    private boolean checkStudentData(String name, int age) {
        return true;
    }

}
