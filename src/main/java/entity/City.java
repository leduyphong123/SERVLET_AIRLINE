package entity;

public class City {
    private int id;
    private String name;
    private String shortName;

    public City() {
    }

    public City(int id, String name, String shortName) {
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
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
