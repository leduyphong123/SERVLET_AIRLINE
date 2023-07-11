package entity;

public class Airline {
    private int id;
    private String name;
    private String shortName;

    public Airline() {
    }

    public Airline(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
