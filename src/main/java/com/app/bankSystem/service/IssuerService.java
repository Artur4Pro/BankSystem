package com.app.bankSystem.service;

import com.app.bankSystem.entity.Issuer;
import com.app.bankSystem.repo.IssuerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuerService {
    @Autowired
    private IssuerRepo issuerRepo;

    public void createIssuer(Issuer issuer) {
        issuerRepo.save(issuer);
    }

    public void deleteIssuer(Long id) {
        issuerRepo.delete(issuerRepo.findById(id).get());
    }

    public void updateIssuer(Long id, Issuer issuer) {
        Issuer find = issuerRepo.findById(id).get();
        find.setBankName(issuer.getBankName());
        find.setBankType(issuer.getBankType());
        find.setBankCode(issuer.getBankCode());
        find.setBranchCode(issuer.getBranchCode());
        find.setAddress(issuer.getAddress());
        issuerRepo.save(find);

    }

    public Issuer getIssuerById(Long id) {
        return issuerRepo.findById(id).get();
    }

}
