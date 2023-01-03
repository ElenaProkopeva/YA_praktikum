package org.example.sprint7;

public class Profile {
    private String name;
    private String about;

    public Profile(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public Profile() {
    }

    public String getAbout() {
        return about;
    }

    public String getName() {
        return name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setName(String name) {
        this.name = name;
    }

}
