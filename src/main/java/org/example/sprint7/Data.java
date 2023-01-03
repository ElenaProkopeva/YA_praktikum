package org.example.sprint7;

public class Data {
    private String name;
    private String about;
    private String avatar;
    private String _id;
    private String email;

    public Data(String name, String about, String avatar, String _id, String email) {
        this.name = name;
        this.about = about;
        this.avatar = avatar;
        this._id = _id;
        this.email = email;
    }

    public Data() {
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getAvatar() {
        return avatar;
    }

    public String get_id() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}