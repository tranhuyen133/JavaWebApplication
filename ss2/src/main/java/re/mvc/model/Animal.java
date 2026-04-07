package re.mvc.model;

public class Animal {
    private int id;
    private String name;
    private String description;
    private String url;
    private float price;

    public Animal() {
    }

    public Animal(int id, String name, String description, String url, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}