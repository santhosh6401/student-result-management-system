package com.student.result.service;

import com.student.result.model.Result;
import com.student.result.model.Student;

import java.util.Objects;
import java.util.Scanner;

public class ResultService {

    public static void getStudentDetail(Result result) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\nstudent's options :: " +
                    "\n\nif you want to see the student detail please enter your register number in below :: " +
                    "\n\nif you want exit please press :: E or e");
            System.out.println("\n\nenter your option :: ");
            String option = scanner.nextLine();
            switch (option) {
                case "E":
                case "e":
                    System.out.println("\nStudent logout successfully.....\n\n*****************************************\n");
                    return;
                default:
                    Student student = null;
                    for (Student studentDetail : result.getStudentList()) {
                        if (studentDetail.getRollNo().equals(option)) {
                            student = studentDetail;
                            break;
                        }
                    }

                    if (Objects.nonNull(student)) {
                        System.out.println("\n\nResult Detail ...... \n\n******************************************\n" + student.displayDetails());
                    } else {
                        System.out.println("\n\nOOPS !! ==> record not found , try again or contact staff\n\n******************************************\n");
                    }
            }
        }

    }
}
