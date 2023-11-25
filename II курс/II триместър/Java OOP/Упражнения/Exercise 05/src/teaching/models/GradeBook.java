package teaching.models;

import models.Student;

import java.util.*;

public class GradeBook {

    private Set<Student> students = new HashSet<>();

    private Map<Student, List<Integer>> studentGrades = new HashMap<>();

    public void addStudent(Student st){
        students.add(st);
    }

    public void addGrade(final Student student, int grade){
        if(studentGrades.containsKey(student)){
            List<Integer> grades = studentGrades.get(student);
            grades.add(grade);
        }else{
            final List<Integer> grades = new ArrayList<>();
            grades.add(grade);
            studentGrades.put(student,grades);
        }
    }

    public double getFinalGrade(Student student){
        List<Integer> grades = studentGrades.get(student);
        double temp = 0;
        for (int grade:grades) {
            temp +=grade;
        }
        return temp/grades.size();
    }

}

