package com.app.bankSystem.controller;

import com.app.bankSystem.entity.Issuer;
import com.app.bankSystem.repo.IssuerRepo;
import com.app.bankSystem.service.IssuerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class IssuerController {
    private IssuerService issuerService;

    IssuerController(IssuerService issuerService) {
        this.issuerService = issuerService;
    }

    @PostMapping("/issuer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createIssuer(@RequestBody Issuer issuer) {
        issuerService.createIssuer(issuer);
    }

    @DeleteMapping("/issuer/delete/{id}")
    public void deleteIssuer(@PathVariable("id") Long id) {
        issuerService.deleteIssuer(id);
    }

    @PutMapping("/issuer/update/{id}")
    public void updateIssuer(@PathVariable("id") Long id,@RequestBody Issuer issuer) {
        issuerService.updateIssuer(id, issuer);
    }

    @GetMapping("issuer/get/{id}")
    public Issuer getIssuerById(@PathVariable("id") Long id) {
        return issuerService.getIssuerById(id);
    }


}
