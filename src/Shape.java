import java.util.Date;

public abstract class Shape implements Drawable {
    private Date dateCreated;
    private String color;

    public Shape() {
        this.dateCreated = new Date();
    }

    public Shape(String color) {
        this.color = color;
        this.dateCreated = new Date();
    }

    public Date getDateCreated() {return dateCreated;}

    public abstract double getArea();
    public abstract double getPerimeter();
}
