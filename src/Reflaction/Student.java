package Reflaction;

public class Student {
    private long id;
    private String name;
    public int classNum;

    static {
        System.out.println("student static block code");
    }

    public Student() {
        System.out.println("construct method");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

