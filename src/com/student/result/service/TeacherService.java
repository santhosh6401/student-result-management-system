package com.student.result.service;

import com.student.result.model.Result;
import com.student.result.model.Student;

import java.util.*;

public class TeacherService {


    public static void teacherOptions(Result result) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n******************************************\n\n" +
                    "choose the following option for below \n" +
                    "1 :: insert the student result \n" +
                    "2 :: display the all students result \n" +
                    "3 :: display individual student result based on name \n" +
                    "4 :: display individual student result based on roll no \n" +
                    "5 :: update the student result based on roll no \n" +
                    "6 :: remove student result based on roll no \n" +
                    "7 :: display the students result based on PASS or FAIL \n" +
                    "8 :: display the student result based on rank \n" +
                    "9 :: exit the program \n " +
                    "\n\n******************************************\n\n" +
                    "enter your option :: ");

            String option = scanner.nextLine();
            ArrayList<String> options = new ArrayList<>();
            options.add("1");
            options.add("2");
            options.add("3");
            options.add("4");
            options.add("5");
            options.add("6");
            options.add("7");
            options.add("8");
            options.add("9");

            option = options.contains(option) ? option : "NA";

            switch (option) {
                case "1": //insert the student result
                    option1(result);
                    break;

                case "2": //display the all students result
                    option2(result);
                    break;

                case "3": //display individual student result based on name
                    option3(result);
                    break;

                case "4": //display individual student result based on roll no
                    option4(result);
                    break;

                case "5": //update the student result based on roll no
                    option5(result);
                    break;

                case "6": //remove student result based on roll no
                    option6(result);
                    break;

                case "7": //display the students result based on PASS or FAIL
                    option7(result);
                    break;

                case "8": //display the student result based on rank
                    option8(result);
                    break;

                case "9": //logout
                    System.out.println("\nstaff logout successfully.....:(\n\n******************************************\n\n");
                    return;

                case "NA": //invalid option
                    System.out.println("\n invalid option code please check again .....\n\n******************************************\n\n");
                    break;
            }
        }
    }


    private static void option8(Result result) {
        if (!result.getStudentList().isEmpty()) {
            System.out.println("\ndisplay the all students details based on rank");

            //bubble sort

            int n = result.getStudentList().size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (result.getStudentList().get(j).getTotalScore() < result.getStudentList().get(j + 1).getTotalScore()) {
                        // Swap elements at j and j+1
                        Student temp = result.getStudentList().get(j);
                        result.getStudentList().set(j, result.getStudentList().get(j + 1));
                        result.getStudentList().set(j + 1, temp);
                    }
                }
            }
            ArrayList<Student> list = result.getStudentList();
            int count = 0;
            for (Student studentResult : list) {
                System.out.println("\nRank :: " + (++count) + "\n ....... Student Details ....... \n" + studentResult.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option7(Result result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\ndisplay the students details based on result :: enter PASS || FAIL \n");
        String results = scanner.nextLine();
        ArrayList<Student> studentsValue = new ArrayList<>();
        for (int i = 0; i < result.getStudentList().size(); i++) {
            if (result.getStudentList().get(i).getResult().equalsIgnoreCase(results)) {
                studentsValue.add(result.getStudentList().get(i));
            }
        }
        if (!studentsValue.isEmpty()) {
            for (Student studentResult : studentsValue) {
                System.out.println("\n ....... Student Details ....... \n" + studentResult.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option6(Result result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nremove the students details based on roll number\n");
        String rollNo = scanner.nextLine();
        ArrayList<Student> studentsList = new ArrayList<>();
        for (int i = 0; i < result.getStudentList().size(); i++) {
            if (result.getStudentList().get(i).getRollNo().equalsIgnoreCase(rollNo)) {
                studentsList.add(result.getStudentList().get(i));
            }
        }
        if (!studentsList.isEmpty()) {
            for (Student studentResult : studentsList) {
                result.getStudentList().remove(studentResult);
                System.out.println("\n .......removed student details ....... \n\n" + studentResult.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option5(Result result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nupdate the students details based on roll number\n");
        String roll = scanner.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < result.getStudentList().size(); i++) {
            if (result.getStudentList().get(i).getRollNo().equalsIgnoreCase(roll)) {
                students.add(result.getStudentList().get(i));
            }
        }
        if (!students.isEmpty()) {
            for (Student studentResult : students) {
                System.out.println("\n ....... old student details ....... \n\n" + studentResult.displayDetails());
                int index = result.getStudentList().indexOf(studentResult);
                System.out.println("\nupdating the student result\n\n");
                Student student = new Student();
                String value;
                int count;
                System.out.println("enter the student name :: ");
                value = scanner.nextLine();
                student.setStudentName(value);
                System.out.println("enter the subject count :: ");
                count = scanner.nextInt();
                if (count == 0) {
                    System.out.println("no subject mentioning...");
                } else {
                    System.out.println(count + " subject you mentioned!!!");
                    Map<String, Integer> subject = new HashMap<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("enter the subject name :: " + (i + 1));
                        String subjectName = scanner.next();
                        System.out.println("enter the subject score :: " + (i + 1));
                        Integer score = scanner.nextInt();
                        subject.put(subjectName, score);
                    }
                    student.setSubjectAndScore(subject);
                    student.setAverageScore(getAverageScore(subject));
                    student.setResult(getResult(subject));
                    student.setTotalScore(getTotalScore(subject));
                }
                result.getStudentList().set(index, student);
                System.out.println("\n ....... Student Details ....... \n" + student.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option4(Result result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\ndisplay the students details based on roll number\n");
        String roll = scanner.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < result.getStudentList().size(); i++) {
            if (result.getStudentList().get(i).getRollNo().equalsIgnoreCase(roll)) {
                students.add(result.getStudentList().get(i));
            }
        }
        if (!students.isEmpty()) {
            for (Student studentResult : students) {
                System.out.println("\n ....... Student Details ....... \n\n" + studentResult.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option3(Result result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\ndisplay the students details based on name\n");
        String name = scanner.nextLine();
        ArrayList<Student> studentDetails = new ArrayList<>();
        for (int i = 0; i < result.getStudentList().size(); i++) {
            if (result.getStudentList().get(i).getStudentName().equalsIgnoreCase(name)) {
                studentDetails.add(result.getStudentList().get(i));
            }
        }
        if (!studentDetails.isEmpty()) {
            for (Student studentResult : studentDetails) {
                System.out.println("\n ....... Student Details ....... \n" + studentResult.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option2(Result result) {
        if (!result.getStudentList().isEmpty()) {
            System.out.println("\ndisplay the all students details");
            for (Student studentResult : result.getStudentList()) {
                System.out.println("\n ....... Student Details ....... \n" + studentResult.displayDetails());
            }
            return;
        }
        System.out.println("\nOOPS! no record is found....\n");
    }

    private static void option1(Result result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\ninserting the student result\n\n");
        Student student = new Student();
        String value;
        int count;
        System.out.println("enter the roll number :: ");
        value = scanner.nextLine();
        student.setRollNo(value);
        System.out.println("enter the student name :: ");
        value = scanner.nextLine();
        student.setStudentName(value);
        System.out.println("enter the subject count :: ");
        count = scanner.nextInt();
        if (count == 0) {
            System.out.println("no subject mentioning...");
        } else {
            System.out.println(count + " subject you mentioned!!!");
            Map<String, Integer> subject = new HashMap<>();
            for (int i = 0; i < count; i++) {
                System.out.println("enter the subject name :: " + (i + 1));
                String subjectName = scanner.next();
                System.out.println("enter the subject score :: " + (i + 1));
                Integer score = scanner.nextInt();
                subject.put(subjectName, score);
            }
            student.setSubjectAndScore(subject);
            student.setAverageScore(getAverageScore(subject));
            student.setResult(getResult(subject));
            student.setTotalScore(getTotalScore(subject));
        }
        result.getStudentList().add(student);
        System.out.println("\n ....... Student Details ....... \n" + student.displayDetails());
    }

    private static int getTotalScore(Map<String, Integer> subject) {
        Integer total = 0;
        if (subject.size() > 0) {
            for (Map.Entry<String, Integer> entry : subject.entrySet()) {
                total = entry.getValue() + total;
            }
        }
        return total;
    }

    private static String getResult(Map<String, Integer> subject) {

        if (subject.size() > 0) {
            for (Map.Entry<String, Integer> entry : subject.entrySet()) {
                if (entry.getValue() <= 35) {
                    return "FAIL";
                }
            }
            return "PASS";
        }
        return "FAIL";
    }

    private static double getAverageScore(Map<String, Integer> subject) {

        if (subject.size() > 0) {
            Integer sum = 0;
            for (Map.Entry<String, Integer> entry : subject.entrySet()) {
                sum = entry.getValue() + sum;
            }
            return sum.doubleValue() / subject.size();
        }
        return 0;
    }
}
