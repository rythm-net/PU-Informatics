package teaching.models;

import models.Professor;
import models.Student;

import java.util.*;

public class Subject {
    private Set<Professor> teachers = new HashSet<>();
    private Set<Student> students = new HashSet<>();
    private Map<Student, List<Integer>> grades = new HashMap<>();

    public boolean addTeacher(Professor teacher) {
        return teachers.add(teacher);
    }
    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public void addGrade(Student student, int grade) {
        if (grades.containsKey(student)) {
            List<Integer> studentGrades = grades.get(student);
            studentGrades.add(grade);
        } else {
            List<Integer> studentGrades = new ArrayList<>();
            studentGrades.add(grade);
            grades.put(student,studentGrades);
        }
    }

    public double getFinalGrade(Student student) {
        List<Integer> studentGrades = grades.get(student);
        double temp = 0;
        for (int i:studentGrades) {
            temp += i;
        }
        return temp/studentGrades.size();
    }
}
