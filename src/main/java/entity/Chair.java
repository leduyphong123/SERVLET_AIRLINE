package entity;

public class Chair {
    private int id;
    private String name;
    private boolean state;

    public Chair() {
    }

    public Chair(int id, String name,boolean state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
