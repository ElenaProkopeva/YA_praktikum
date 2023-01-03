package org.example.sprint7;

public class User {
    private Data data;

    public User(Data data) {
        this.data = data;
    }

    public User() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
