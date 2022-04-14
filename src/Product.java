public class Product
{
    private String name;
    private String description;
    private String ID;
    private Double cost;


    public Product(String ID, String name, String description, Double cost)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public Double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String toCSVDataRecord()
    {
        return ID + ", " + name + ", " + description + ", " + cost;
    }
}
