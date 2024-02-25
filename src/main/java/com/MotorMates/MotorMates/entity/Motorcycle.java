package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Motorcycle")
@Table(
        name = "motorcycle"
)
public class Motorcycle {
    @Id
    @SequenceGenerator(
            name = "motorcycle_sequence",
            sequenceName = "motorcycle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "motorcycle_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "brand",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String brand;
    @Column(
            name = "model",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String model;
    @Column(
            name = "year",
            nullable = false
    )
    private int year;
    @Column(
            name = "displacement",
            nullable = false
    )
    private int displacement;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registered_user_id", referencedColumnName = "id")
    private RegisteredUser registeredUser;

    public Long getId() {
        return id;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public Motorcycle(String brand, String model, int year, int displacement) {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setDisplacement(displacement);
    }
    public Motorcycle() {

    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }


    @Override
    public String toString() {
        return "MotorcycleTest{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", displacement=" + displacement +
                '}';
    }

    public void pairToRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}
