package com.Security_Agency.demo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "revenue")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "receipt_date", nullable = false)
    private Date receiptDate;

    @Column(name = "revenue_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal revenueAmount;

    @ManyToOne
    @JoinColumn(name = "contract_serial_number_id", nullable = false)
    private Contracts contract;

    public Revenue() {}

    public Revenue(Date receiptDate, BigDecimal revenueAmount, Contracts contract) {
        this.receiptDate = receiptDate;
        this.revenueAmount = revenueAmount;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public BigDecimal getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(BigDecimal revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public Contracts getContract() {
        return contract;
    }

    public void setContract(Contracts contract) {
        this.contract = contract;
    }
}
