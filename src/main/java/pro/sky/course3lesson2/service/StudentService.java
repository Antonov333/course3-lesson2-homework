package pro.sky.course3lesson2.service;

//import org.springframework.http.HttpStatusCode;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.course3lesson2.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    private HashMap<Long, Student> students = new HashMap<>();

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

    public List<Student> getByAge(int age) {
        return students.values().stream().filter(s -> s.getAge() == age).toList();
    }

    public HashMap<Long, Student> getStudents() {
        return students;
    }

    public HashMap<Long, Student> loadExampleStudents(int number) {
        for (int i = 0; i < number; i++) {
            students.put(Long.valueOf(i + 1), new Student(i + 1, randomName(), randomAge(18, 25)));
        }
        return students;
    }

    public Student sendDown(Student student) {
        if (students.remove(student.getId(), student)) {
            return student;
        }
        return null;
    }

    public List<Student> selectedByAge(int age) {
        return students.values().stream().filter(student -> student.getAge() == age).toList();
    }

    private String randomName() {
        Lorem lorem = new LoremIpsum();
        return lorem.getFirstName();
    }

    private int randomAge(int origin, int bound) {
        Random random = new Random();
        return random.nextInt(origin, bound);
    }

    private boolean checkStudentData(String name, int age) {
        if (!name.equals("") & name != null & age > 16) {
            return true;
        }
        return false;
    }

}
