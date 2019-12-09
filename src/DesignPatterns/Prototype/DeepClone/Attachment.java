package DesignPatterns.Prototype.DeepClone;

import java.io.Serializable;

public class Attachment implements Serializable {
    private String name;
    public void download() {
        System.out.println("attachment is downloading");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
