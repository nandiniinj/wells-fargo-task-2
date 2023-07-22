package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class FinancialAdvisor {

    @Id
    @GeneratedValue()
    private long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // Add other attributes specific to the FinancialAdvisor entity as needed

    @OneToMany(mappedBy = "financialAdvisor")
    private List<Client> clients;

    protected FinancialAdvisor() {
    }

    public FinancialAdvisor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Add getters and setters as required
}
