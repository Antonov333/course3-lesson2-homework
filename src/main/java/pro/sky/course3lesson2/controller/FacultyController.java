package pro.sky.course3lesson2.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;
import pro.sky.course3lesson2.model.Faculty;
import pro.sky.course3lesson2.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public Collection<Faculty> getAll() {
        return facultyService.getFaculties();
    }

    @GetMapping(path = "/{id}")
    public Faculty getFacultyById(@PathVariable long id) {
        long facultyId = id;
        return facultyService.getById(facultyId);
    }

    @GetMapping(path = "/{color}")
    public List<Faculty> getByColor(@PathVariable String color) {
        return facultyService.getFacultiesByColor(color);
    }

    @PostMapping
    public void createFaculty(@RequestBody Faculty faculty) {
        facultyService.createFaculty(faculty);
    }

}
