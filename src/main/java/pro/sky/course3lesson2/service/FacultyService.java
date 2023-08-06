package pro.sky.course3lesson2.service;

import org.springframework.stereotype.Service;
import pro.sky.course3lesson2.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {

    HashMap<Long, Faculty> faculties = new HashMap<>();

    public FacultyService() {
    }

    public Collection<Faculty> getFaculties() {
        return faculties.values();
    }

    public Faculty getById(long id) {
        return faculties.get(Long.valueOf(id));
    }

    public List<Faculty> getFacultiesByColor(String color) {
        System.out.println("color = " + color);
        List<Faculty> coloredByColor = faculties.values().stream().filter(faculty -> faculty.getColor().equals(color)).toList();
        System.out.println("coloredByColor = " + coloredByColor);
        return coloredByColor;
    }

    public Faculty createFaculty(Faculty faculty) {
        Long id = Long.valueOf(faculty.getId());
        faculties.put(id, faculty);
        return faculties.get(id);
    }

    public Faculty updateFaculty(long id, Faculty faculty) {
        return faculties.put(Long.valueOf(id), faculty);
    }

    public HashMap<Long, Faculty> loadExampleFaculties() {
        final int one = 1, two = 2, three = 3, four = 4, five = 5, six = 6;
        final String silver = "silver",
                white = "white",
                green = "green",
                blue = "blue",
                black = "black",
                yellow = "yellow",
                pink = "pink";

        faculties.put(Long.valueOf(one), new Faculty(Long.valueOf(one), "Commercial Cycling", silver));
        faculties.put(Long.valueOf(two), new Faculty(Long.valueOf(two), "Road Bicycle Racing", yellow));
        faculties.put(Long.valueOf(three), new Faculty(Long.valueOf(three), "Mountain Bike Racing", green));
        faculties.put(Long.valueOf(four), new Faculty(Long.valueOf(four), "Bikepacking", blue));

        return faculties;
    }


}
