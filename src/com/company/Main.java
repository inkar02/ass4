package com.company;

import com.company.controllers.CompanyController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.CompanyRepository;
import com.company.repositories.interfaces.ICompanyRepository;

public class Main {

    public static void main(String[] args) {

        IDB db = new PostgresDB();
        ICompanyRepository repo = new CompanyRepository(db);
        CompanyController controller = new CompanyController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
