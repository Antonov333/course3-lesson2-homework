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
        return getFaculties().stream().filter(faculty -> faculty.getColor().equals(color)).toList();
    }

    public void createFaculty(Faculty faculty) {
        faculties.put(Long.valueOf(faculty.getId()), faculty);
    }


}
