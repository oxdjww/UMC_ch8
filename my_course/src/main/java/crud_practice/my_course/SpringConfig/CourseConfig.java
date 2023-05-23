package crud_practice.my_course.SpringConfig;

import crud_practice.my_course.controller.CourseController;
import crud_practice.my_course.repository.CourseRepository;
import crud_practice.my_course.service.CourseService;
import crud_practice.my_course.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "crud_practice.my_course.repository")
public class CourseConfig {
    @Bean
    public CourseService courseService() {
        return new CourseServiceImpl();
    }


}
