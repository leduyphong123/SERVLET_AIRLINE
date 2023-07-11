package entity;

public class Airplane {
    private int id;
    private String name;
    private String shortName;
    private int capacity;
    private int alId;

    public Airplane() {
    }

    public Airplane(int id, String name, String shortName, int capacity, int alId) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.capacity = capacity;
        this.alId = alId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public int getAlId() {
        return alId;
    }

    public void setAlId(int alId) {
        this.alId = alId;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", capacity=" + capacity +
                ", alId=" + alId +
                '}';
    }
}
