package crud_practice.my_course.controller;

import crud_practice.my_course.entity.Course;
import crud_practice.my_course.exception.ErrorResponse;
import crud_practice.my_course.repository.CourseRepository;
import crud_practice.my_course.service.CourseService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id) {
        Course course = courseService.getCourseById(id).orElse(null);
        if (course == null) {
            ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.CONFLICT, "등록되지 않은 강의입니다.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @Valid @RequestBody Course course) {
        Course existingCourse = courseService.getCourseById(id).orElse(null);
        if (existingCourse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingCourse.setName(course.getName());
        existingCourse.setDate(course.getDate());
        existingCourse.setClassRoom(course.getClassRoom());
        existingCourse.setStartTime(course.getStartTime());
        existingCourse.setEndTime(course.getEndTime());

        Course updatedCourse = courseService.updateCourse(existingCourse);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") Long id) {
        Course course = courseService.getCourseById(id).orElse(null);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




