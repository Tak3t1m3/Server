package crops;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.File;
import java.io.Serializable;


@MappedSuperclass
public abstract class Crops implements Serializable {


    protected String name;
    protected Image image;
    protected double weight, cost, quantity;
    protected boolean available;
    protected File imagefile;
    @Id
    protected String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Crops() {
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.cost = cost;
        this.quantity = quantity;
        this.available = available;
        this.imagefile = imagefile;


    }

    public Crops(String name, Image image, double weight, double cost, double quantity, boolean available, File imagefile) {
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.cost = cost;
        this.quantity = quantity;
        this.available = available;
        this.imagefile = imagefile;


    }

    public Crops(String name, double weight, double cost, double quantity, boolean available, File imagefile) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.quantity = quantity;
        this.available = available;
        this.imagefile = imagefile;
        this.image = image;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;

    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;

    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;

    }

    public File getImagefile() {
        return imagefile;
    }

    public void setImagefile(File imagefile) {
        this.imagefile = imagefile;
    }

    public void fileToImage(File file){
        Image img = new Image(file.toURI().toString());
    }

    public void thisFileToImage(){
        Image img = new Image(imagefile.toURI().toString());
    }
}
