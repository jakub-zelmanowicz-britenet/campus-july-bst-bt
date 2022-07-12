package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Category {

    private final int id;
    private String name;

    public Category(int id) {
        this.id = id;
    }

    public Category() {
        this.id = Constants.INVALID_ID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
