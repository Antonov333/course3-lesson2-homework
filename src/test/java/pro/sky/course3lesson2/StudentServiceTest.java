package pro.sky.course3lesson2;

import org.junit.jupiter.api.Test;
import pro.sky.course3lesson2.model.Student;
import pro.sky.course3lesson2.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    private static void loadTestStudents(StudentService studentService) {
        studentService.createStudent(new Student(1, "Nadia", 19));
        studentService.createStudent(new Student(2, "Ben", 18));
        studentService.createStudent(new Student(3, "Coy", 21));
        studentService.createStudent(new Student(4, "Naomi", 19));
        studentService.createStudent(new Student(5, "Elmer", 18));
    }

    @Test
    public void createStudentTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        Student newStudent = new Student(6, "Cary", 18);
        studentService.createStudent(newStudent);
        assertEquals(newStudent, studentService.readStudent(6));
    }

    @Test
    public void readStudentTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        Student expectedStudent = new Student(3, "Coy", 21);
        assertEquals(expectedStudent, studentService.readStudent(3));
    }

    @Test
    public void updateStudentTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        String simon = "Simon";
        int age26 = 26;
        Student expectedStudent = new Student(3, simon, age26);
        assertNotEquals(expectedStudent, studentService.readStudent(3));
        studentService.updateStudent(3, simon, age26);
        assertEquals(expectedStudent, studentService.readStudent(3));

    }

    @Test
    public void getByAgeTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(new Student(3, "Coy", 21));
        assertEquals(expectedList, studentService.getByAge(21));
    }

    @Test
    public void getStudentsTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        HashMap<Long, Student> expected = new HashMap<>();
        expected.put(1L, new Student(1, "Nadia", 19));
        expected.put(2L, new Student(2, "Ben", 18));
        expected.put(3L, new Student(3, "Coy", 21));
        expected.put(4L, new Student(4, "Naomi", 19));
        expected.put(5L, new Student(5, "Elmer", 18));
        assertEquals(expected, studentService.getStudents());
    }

    @Test
    public void sendDownTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        Student student = new Student(5, "Elmer", 18);
        assertEquals(student, studentService.readStudent(5));
        assertEquals(student, studentService.sendDown(student));
        assertFalse(studentService.getStudents().containsValue(student));

    }

    @Test
    public void selectedByAgeTest() {
        StudentService studentService = new StudentService(new HashMap<>());
        loadTestStudents(studentService);
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(new Student(3, "Coy", 21));
        assertEquals(expectedList, studentService.selectedByAge(21));
    }
}
