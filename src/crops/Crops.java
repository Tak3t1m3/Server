package crops;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


@MappedSuperclass
public class Crops implements Serializable {


    private String name;
    private Image image;
    private double weight, cost, quantity;
    private boolean available;
    private File imagefile;

    private String owner;
    @Id
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

    public Byte[] getImage() {
        // return (Byte[]) image;
        if(image!=null)
            return new Byte[(int)image.toString().length()];
        else
            return null;    }

    public void setImage(byte[] image) {


        try {
            this.image = Image.impl_fromPlatformImage(ImageIO.read(new ByteArrayInputStream(image)));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
