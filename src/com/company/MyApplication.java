package com.company;

import com.company.controllers.CompanyController;

import java.util.Scanner;

public class MyApplication {
    private final CompanyController controller;
    private final Scanner scanner;

    public MyApplication(CompanyController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }


    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1, 2, 3)");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCompaniesMenu();
                } else if (option == 2) {
                    getCompanyByIdMenu();
                } else if (option == 3) {
                    createCompanyMenu();
                } else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }
    public void getAllCompaniesMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }
    public void getCompanyByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getCompany(id);
        System.out.println(response);
    }
    public void createCompanyMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter project");
        String project = scanner.next();
        System.out.println("Please enter totalcost");
        int totalcost = scanner.nextInt();
        String response = controller.createCompany(name, project, totalcost);
        System.out.println(response);
    }
}