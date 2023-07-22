package com.wellsfargo.counselor.entity;
import javax.persistence.*;

@Entity
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    private String advisorName;

    // Constructors
    public FinancialAdvisor() {}

    public FinancialAdvisor(String advisorName) {
        this.advisorName = advisorName;
    }

    // Getters and Setters
    public Long getAdvisorId() {
        return advisorId;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }
}

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String clientName;

    @ManyToOne
    @JoinColumn(name = "advisorId")
    private FinancialAdvisor financialAdvisor;

    // Constructors
    public Client() {}

    public Client(String clientName, FinancialAdvisor financialAdvisor) {
        this.clientName = clientName;
        this.financialAdvisor = financialAdvisor;
    }

    // Getters and Setters
    public Long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public FinancialAdvisor getFinancialAdvisor() {
        return financialAdvisor;
    }

    public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) {
        this.financialAdvisor = financialAdvisor;
    }
}

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    // Constructors
    public Portfolio() {}

    public Portfolio(Client client) {
        this.client = client;
    }

    // Getters and Setters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @ManyToOne
    @JoinColumn(name = "portfolioId")
    private Portfolio portfolio;

    private String name;
    private String category;
    private String purchaseDate;
    private double purchasePrice;
    private int quantity;

    // Constructors
    public Security() {}

    public Security(Portfolio portfolio, String name, String category, String purchaseDate, double purchasePrice, int quantity) {
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getSecurityId() {
        return securityId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
