package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;


import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Rider")
@Table(
        name = "rider",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email")
        }
)
public class Rider {

    @Id
    @SequenceGenerator(
            name = "rider_sequence",
            sequenceName = "rider_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "rider_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "user_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "type_of_rider",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String typeOfRider;
    @Column(
            name = "total_distance"
    )
    private double totalDistance;
    @Column(
            name = "average_speed"
    )
    private double averageSpeed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfRider() {
        return typeOfRider;
    }

    public void setTypeOfRider(String typeOfRider) {
        this.typeOfRider = typeOfRider;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }


    public Rider(String username, String password, String email, String typeOfRider, double totalDistance, double averageSpeed) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setTypeOfRider(typeOfRider);
        setTotalDistance(totalDistance);
        setAverageSpeed(averageSpeed);
    }
    public Rider(){

    }
}
