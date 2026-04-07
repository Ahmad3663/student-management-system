package com.comp2154.student_system.config;
import com.comp2154.student_system.model.*; import com.comp2154.student_system.repository.*; import java.util.List; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*;
@Configuration public class DataLoader {
 @Bean CommandLineRunner seedData(StudentRepository studentRepository, CourseRepository courseRepository, GradeRepository gradeRepository, UserRepository userRepository){
   return args -> {
    if(studentRepository.count()==0){ studentRepository.saveAll(List.of(new Student(1,"Ahmad Ashoor","ahmad@example.com"), new Student(2,"Lina Noor","lina@example.com"), new Student(3,"Omar Ali","omar@example.com"))); }
    if(courseRepository.count()==0){ courseRepository.saveAll(List.of(new Course("COMP2154","System Development Project","Prof. Smith"), new Course("COMP2139","Web Application Development","Prof. Chen"), new Course("COMP2147","Mobile App Development","Prof. Brown"))); }
    if(userRepository.count()==0){ userRepository.saveAll(List.of(new AppUser("admin","admin123",UserRole.ADMIN,null), new AppUser("instructor","teach123",UserRole.INSTRUCTOR,null), new AppUser("student1","student123",UserRole.STUDENT,1))); }
    if(gradeRepository.count()==0){ Course c1=courseRepository.findByCode("COMP2154").orElseThrow(); Course c2=courseRepository.findByCode("COMP2139").orElseThrow(); gradeRepository.saveAll(List.of(new Grade(1,c1,88,"A"), new Grade(1,c2,92,"A+"), new Grade(2,c1,76,"B+"), new Grade(3,c2,69,"C+"))); }
   };
 }
}
