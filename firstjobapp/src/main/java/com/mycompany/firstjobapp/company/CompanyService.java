package com.mycompany.firstjobapp.company;

import java.util.List;


public interface CompanyService {
    List<Company> getAllCompanies();

    //boolean updateCompany(Long id, Company company);
    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

}
