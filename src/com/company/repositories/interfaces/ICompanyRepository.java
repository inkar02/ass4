package com.company.repositories.interfaces;

import com.company.entities.Company;

import java.util.List;

public interface ICompanyRepository {
    boolean createCompany(Company company);
    Company getCompany(int id);
    List<Company> getAllCompanies();
}