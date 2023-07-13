package dto;

public class AirplaneDTO {
    private int id;
    private String name;
    private String shortName;
    private int capacity;
    private boolean state;
    private int alId;
    private String alName;

    public AirplaneDTO() {
    }

    public AirplaneDTO(int id, String name, String shortName, int capacity, boolean state, int alId, String alName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.capacity = capacity;
        this.state = state;
        this.alId = alId;
        this.alName = alName;
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

    @Override
    public String toString() {
        return "AirplaneDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", capacity=" + capacity +
                ", state=" + state +
                ", alId=" + alId +
                ", alName='" + alName + '\'' +
                '}';
    }
}
