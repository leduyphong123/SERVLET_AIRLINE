package entity;

public class City {
    private int id;
    private String name;
    private String shortName;
    private boolean state;

    public City() {
    }

    public City(int id, String name, String shortName, boolean state) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
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
                ", state=" + state +
                '}';
    }
}
