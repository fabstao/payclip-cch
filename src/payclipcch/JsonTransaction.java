/*
 * (C) 2018 Fabian Salamanca Dominguez
 */
package payclipcch;

import java.util.Date;

/**
 *
 * @author fsalaman
 */
public class JsonTransaction {
    private double amount;
    private String description;
    private Date date;
    private int user_id;
    private String transaction_id;

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
    
    
}
