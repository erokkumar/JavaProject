package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       
       StudentDao studentDao =  context.getBean("studentDao" , StudentDao.class);
       
//       Student student = new Student();
//       student.setId(1);
//       student.setStudentName("Rohit Kumar");
//       student.setStudentCity("Bhopal");
//       int rr = studentDao.insert(student);
//       System.out.println("Student added with id: " + rr);
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
        System.out.println("Welcome to the student management application");
        System.out.println("Press 1 to add new student");
        System.out.println("Press 2 to get student details");
        System.out.println("Press 3 to get all students");
        System.out.println("Press 4 to delete student");
        System.out.println("Press 5 to update student");
        System.out.println("Press 6 to exit");
       
        
        try {
        	int input = Integer.parseInt(br.readLine());
        	switch(input) {
        	case 1:
        		// add new student
        		System.out.println("Enter student id");
        		int studentId = Integer.parseInt(br.readLine());
        		System.out.println("Enter student name");
        		String studentName = br.readLine();
        		System.out.println("Enter student city");
        		String studentCity = br.readLine();
        		
        		//Creating student object
        		Student student = new Student();
        		student.setId(studentId);
        		student.setStudentName(studentName);
        		student.setStudentCity(studentCity);
        		
        		//Saving student to database
        		int r = studentDao.insert(student);
        		System.out.println("Student added with id: " + r);
        		System.out.println("**********************************************");
        		System.out.println();
        		break;
        	case 2:
        		// Display student details
        		System.out.println("Enter student id");
        		int studentId1 = Integer.parseInt(br.readLine());
        		Student student1 = studentDao.getStudent(studentId1);
        		//System.out.println("Student id: " + student1.getId() + ", Student name: " + student1.getStudentName() + ", Student city: " + student1.getStudentCity());
        		System.out.println("Student id:\t" + student1.getId() + 
                        "\tStudent name:\t" + student1.getStudentName() + 
                        "\tStudent city:\t" + student1.getStudentCity());

        		break;
        	case 3:
        		// Display all students
        		System.out.println("All students are: " + studentDao.getAllStudents().size());
        		List<Student> students = studentDao.getAllStudents();
        		for(Student s : students) {
					System.out.println("Student id: " + s.getId() + ", Student name: " + s.getStudentName() + ", Student city: " + s.getStudentCity());
				}
        		System.out.println("**********************************************");
        		System.out.println();
				break;
        	case 4:
        		// Delete student
        		System.out.println("Enter student id");
        		int studentId2 = Integer.parseInt(br.readLine());
        		Student student2 = studentDao.getStudent(studentId2);
        		if(student2 == null) {
					System.out.println("Student not found");
				} else {
					studentDao.deleteStudent(studentId2);
					System.out.println("Student deleted successfully");
				}
        		break;
        	case 5:
        		//Update student
        		System.out.println("Enter Student id");
        		int stId = Integer.parseInt(br.readLine());
        		Student student3 = studentDao.getStudent(stId);
        		if(student3 == null) {
        			System.out.println("Student Not Found");
        		}else {
        			System.out.println("Enter new Student name");
        			String newN = br.readLine();
        			System.out.println("Enter new Student City");
        			String newcity = br.readLine();
        			student3.setStudentName(newN);
        			student3.setStudentCity(newcity);
        			studentDao.updateStudent(student3);
        			System.out.println("Student data updated successfully");
        		}
        		break;
        	case 6:
        		// exit
        		flag = false;
        		System.out.println("Thank you for using the application");
        		
        	}
        
			
		} catch (Exception e) {
			System.out.println("Invalid input, please try again.");
			System.out.println(e.getMessage());
		    }
        
        }
    }
}
