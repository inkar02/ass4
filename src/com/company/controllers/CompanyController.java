
package com.company.controllers;

        import com.company.entities.Company;
        import com.company.repositories.interfaces.ICompanyRepository;

        import java.util.List;

public class CompanyController {
    private final ICompanyRepository repo;

    public CompanyController(ICompanyRepository repo) {
        this.repo = repo;
    }

    public String createCompany(String name, String project, int totalcost) {
        Company company = new Company(name, project, totalcost);

        boolean created = repo.createCompany(company);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getCompany(int id) {
        Company company = repo.getCompany(id);

        return (company == null ? "User was not found!" : company.toString());
    }

    public String getAllUsers() {
        List<Company> companies = repo.getAllCompanies();

        return companies.toString();
    }
}
