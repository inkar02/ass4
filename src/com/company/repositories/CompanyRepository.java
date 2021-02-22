package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Company;
import com.company.repositories.interfaces.ICompanyRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class CompanyRepository implements ICompanyRepository {
    private final IDB db;

    public CompanyRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCompany(Company company) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO companies(name,project,totalcost) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, company.getName());
            st.setString(2, company.getProject());
            st.setInt(3, company.getTotalcost());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Company getCompany(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,project,totalcost FROM companies WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Company company = new Company(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("project"),
                        rs.getInt("totalcost"));

                return company;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Company> getAllCompanies() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,project,totalcost FROM companies";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Company> companies = new LinkedList<>();
            while (rs.next()) {
                Company company = new Company(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("project"),
                        rs.getInt("totalcost"));

                companies.add(company);
            }

            return companies;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}

