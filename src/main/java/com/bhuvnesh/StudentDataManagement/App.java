package com.bhuvnesh.StudentDataManagement;

import java.util.Scanner;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        StudentCrud studentCrud = new StudentCrud();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Add Student
                    Student student = new Student();
                    System.out.print("Enter Roll No: ");
                    student.setRollno(scanner.nextInt());
                    System.out.print("Enter Name: ");
                    student.setName(scanner.next());
                    System.out.print("Enter Marks: ");
                    student.setMarks(scanner.nextInt());
                    studentCrud.saveStudent(student);
                    break;

                case 2: // View Student
                    System.out.print("Enter Roll No: ");
                    int rollno = scanner.nextInt();
                    Student retrievedStudent = studentCrud.getStudent(rollno);
                    if (retrievedStudent != null) {
                        System.out.println(retrievedStudent);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3: // View All Students
                    List<Student> students = studentCrud.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 4: // Update Student
                    System.out.print("Enter Roll No of the student to update: ");
                    rollno = scanner.nextInt();
                    Student studentToUpdate = studentCrud.getStudent(rollno);
                    if (studentToUpdate != null) {
                        System.out.print("Enter new Name: ");
                        studentToUpdate.setName(scanner.next());
                        System.out.print("Enter new Marks: ");
                        studentToUpdate.setMarks(scanner.nextInt());
                        studentCrud.updateStudent(studentToUpdate);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5: // Delete Student
                    System.out.print("Enter Roll No to delete: ");
                    rollno = scanner.nextInt();
                    studentCrud.deleteStudent(rollno);
                    System.out.println("Student deleted.");
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
