package dto;

public class AirplaneDTO {
    private int id;
    private String name;
    private String shortName;
    private int capacity;
    private int alId;
    private String alName;
    private String alShortName;

    public AirplaneDTO() {
    }

    public AirplaneDTO(int id, String name, String shortName, int capacity, int alId, String alName, String alShortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.capacity = capacity;
        this.alId = alId;
        this.alName = alName;
        this.alShortName = alShortName;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAlId() {
        return alId;
    }

    public void setAlId(int alId) {
        this.alId = alId;
    }

    public String getAlName() {
        return alName;
    }

    public void setAlName(String alName) {
        this.alName = alName;
    }

    public String getAlShortName() {
        return alShortName;
    }

    public void setAlShortName(String alShortName) {
        this.alShortName = alShortName;
    }

    @Override
    public String toString() {
        return "AirplaneDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", capacity=" + capacity +
                ", alId=" + alId +
                ", alName='" + alName + '\'' +
                ", alShortName='" + alShortName + '\'' +
                '}';
    }
}
