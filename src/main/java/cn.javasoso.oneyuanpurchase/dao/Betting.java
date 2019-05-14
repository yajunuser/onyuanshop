package cn.javasoso.oneyuanpurchase.dao;

public class Betting {
    private String user;
    private int bettingcount;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getBettingcount() {
        return bettingcount;
    }

    public void setBettingcount(int bettingcount) {
        this.bettingcount = bettingcount;
    }

    public Betting(String user, int bettingcount) {
        this.user = user;
        this.bettingcount = bettingcount;
    }

    public Betting() {
    }
}
