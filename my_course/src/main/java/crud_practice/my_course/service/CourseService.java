package crud_practice.my_course.service;

import crud_practice.my_course.entity.Course;

import java.util.List;
import java.util.Optional;


public interface CourseService {
    Course createCourse(Course course);

    Optional<Course> getCourseById(Long cId);

    List<Course> getAllCourses();

    Course updateCourse(Course course);

    void deleteCourse(Long cId);
}
