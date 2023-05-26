package com.student.result;

import com.student.result.model.Result;
import com.student.result.service.ResultService;
import com.student.result.service.TeacherService;

import java.util.Scanner;

public class Main {

    private static ResultService resultService;

    private static TeacherService teacherService;

    public static void main(String[] args) {

        Result result = new Result();

        Scanner scanner = new Scanner(System.in);

        System.out.println("......  Student Result Management System  .......  \n \n ");

        while (true) {

            System.out.println("       Login \n");
            System.out.println("if are you student enter :: S or s\n\n" +
                    "if you are a staff enter :: T or t\n\n" +
                    "if you want to terminate the program :: E or e\n\n" +
                    "enter your option :: ");
            String option = scanner.nextLine();

            switch (option) {
                case "s":
                case "S":
                    resultService.getStudentDetail(result);
                    break;
                case "t":
                case "T":
                    System.out.println("please enter your username");
                    String userName = scanner.nextLine();
                    System.out.print("please enter your password\n");
                    String password = scanner.nextLine();
                    if (userName.equalsIgnoreCase("admin") && password.equals("Pass@1234")) {
                        System.out.println("staff login successfully\n\n");
                        teacherService.teacherOptions(result);
                    } else {
                        System.out.println("login failed please check the username and password\n\n******************************************\n");
                    }
                    break;
                case "E":
                case "e":
                    System.out.println("\nprogram terminated...:( \n\n******************************************\n");
                    return;
                default:
                    System.out.println("Invalid input please check again...\n\n******************************************\n");
                    break;
            }
        }
    }
}
