package com.mycompany.firstjobapp.company.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.firstjobapp.company.Company;
import com.mycompany.firstjobapp.company.CompanyService;
import com.mycompany.firstjobapp.company.CompanyRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @JsonIgnore
    private  CompanyRepository companyRepository;
    //private  CompanyService companyService;

    //@Lazy
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        //this.companyService = companyService;
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company,Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
}
