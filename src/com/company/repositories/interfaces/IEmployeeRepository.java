package com.company.repositories.interfaces;

import com.company.entities.Company;
import com.company.entities.Company;

import java.util.List;
 interface IEmployeeReprository {
    boolean createUser(Company user);
    Company getUser(int id);
    List<Company> getAllUsers();
}