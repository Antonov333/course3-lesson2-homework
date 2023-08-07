package pro.sky.course3lesson2;

import org.junit.jupiter.api.Test;
import pro.sky.course3lesson2.model.Faculty;
import pro.sky.course3lesson2.service.FacultyService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FacultyServiceTest {

    @Test
    public void getFacultiesTest() {
        FacultyService facultyService = new FacultyService();
        Collection<Faculty> expected = loadTestFaculties(facultyService);
        Set<Faculty> expectedSet = new HashSet<>(expected);
        Collection<Faculty> actual = facultyService.getFaculties();
        Set<Faculty> actualSet = new HashSet<>(actual);
        assertEquals(expectedSet, actualSet);

    }

    @Test
    public void getByIdTest() {
        FacultyService facultyService = new FacultyService();
        loadTestFaculties(facultyService);
        Faculty expected = new Faculty(Long.valueOf(3), "Mountain Bike Racing", "green");
        assertEquals(expected, facultyService.getById(3L));
    }

    @Test
    public void getFacultiesByColorTest() {
        List<Faculty> expected = new ArrayList<>();
        expected.add(new Faculty(Long.valueOf(1), "Commercial Cycling", "silver"));
        FacultyService facultyService = new FacultyService();
        loadTestFaculties(facultyService);
        assertEquals(expected, facultyService.getFacultiesByColor("silver"));
    }

    @Test
    public void createFacultyTest() {
        FacultyService facultyService = new FacultyService();
        loadTestFaculties(facultyService);
        Faculty testFaculty = new Faculty(5, "Long Distance Bicycling", "blue");
        assertFalse(facultyService.getFaculties().contains(testFaculty));
        facultyService.createFaculty(testFaculty);
        assertTrue(facultyService.getFaculties().contains(testFaculty));
    }

    @Test
    public void updateFacultyTest() {
        FacultyService facultyService = new FacultyService();
        loadTestFaculties(facultyService);
        Faculty f = facultyService.getById(2);
        Faculty expectedFaculty = new Faculty(2, f.getName(), f.getColor());
        expectedFaculty.setColor("Lemon");
        expectedFaculty.setName("Road Cycling Racing");
        assertNotEquals(expectedFaculty, facultyService.getById(2));
        facultyService.updateFaculty(2, expectedFaculty);
        assertEquals(expectedFaculty, facultyService.getById(2));
    }

    private static Set<Faculty> loadTestFaculties(FacultyService facultyService) {
        final int one = 1, two = 2, three = 3, four = 4, five = 5, six = 6;
        final String silver = "silver",
                white = "white",
                green = "green",
                blue = "blue",
                black = "black",
                yellow = "yellow",
                pink = "pink";

        Set<Faculty> facultySet = new HashSet<>();
        facultySet.add(new Faculty(Long.valueOf(one), "Commercial Cycling", silver));
        facultySet.add(new Faculty(Long.valueOf(two), "Road Bicycle Racing", yellow));
        facultySet.add(new Faculty(Long.valueOf(three), "Mountain Bike Racing", green));
        facultySet.add(new Faculty(Long.valueOf(four), "Bikepacking", blue));

        for (Faculty f : facultySet
        ) {
            facultyService.createFaculty(f);
        }

        return facultySet;
    }


}
