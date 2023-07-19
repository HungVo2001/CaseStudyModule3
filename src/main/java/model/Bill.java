package model;

public class Bill {
    private int id;
    private int user_id;
    private long date;
    private double total;
    private Status status;

    public Bill() {
    }

    public Bill(int id, int user_id, long date, double total, Status status) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
