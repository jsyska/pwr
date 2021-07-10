package exc.five;

public class Student {
    private int index;
    private String name;
    private String surename;

    public Student(int index, String name, String surename) {
        this.index = index;
        this.name = name;
        this.surename = surename;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                '}';
    }
}
