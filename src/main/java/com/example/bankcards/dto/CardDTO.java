package com.example.bankcards.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardDTO {

    private Long id;
    private String cardNumberMasked;
    private String ownerName;
    private LocalDate expiryDate;
    private String status;
    private BigDecimal balance;

    public CardDTO() {

    }

    public CardDTO(Long id, String cardNumberMasked, String ownerName, LocalDate expiryDate, String status, BigDecimal balance) {
        this.id = id;
        this.cardNumberMasked = cardNumberMasked;
        this.ownerName = ownerName;
        this.expiryDate = expiryDate;
        this.status = status;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumberMasked() {
        return cardNumberMasked;
    }

    public void setCardNumberMasked(String cardNumberMasked) {
        this.cardNumberMasked = cardNumberMasked;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
