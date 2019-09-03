package com.belajarspringboot.Dao;

import com.belajarspringboot.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){

            {
                put(1, new Student(1, "Amar","Android Developer"));
                put(2, new Student(2, "Dhani","Backend Programmer"));
                put(3, new Student(3, "Ubed", "Backend Programmer"));
                put(4, new Student(4, "Bintang","UI/ UX"));

            }

        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentByid(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student){

        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);

    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
