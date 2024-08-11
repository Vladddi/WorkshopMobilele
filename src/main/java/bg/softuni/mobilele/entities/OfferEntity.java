package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.enums.EngineEnum;
import bg.softuni.mobilele.entities.enums.TransmissionEnum;
import jakarta.persistence.*;
import org.springframework.ui.Model;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private int price;
    private int year;
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity user;


    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", year=" + year +
                ", transmission=" + transmission +
                ", model=" + model +
                ", user=" + user +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

