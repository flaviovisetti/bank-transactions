package br.com.fvs.routinetransactions.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "operation_type_id")
    private OperationsType operationsType;

    private BigDecimal amount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar eventDate = Calendar.getInstance();

    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public OperationsType getOperationsType() {
        return operationsType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Calendar getEventDate() {
        return eventDate;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setOperationsType(OperationsType operationsType) {
        this.operationsType = operationsType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setEventDate(Calendar eventDate) {
        this.eventDate = eventDate;
    }
}
