package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;


import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "RiderProfile")
@Table(
        name = "rider_profile"
)
public class RiderProfile {

    @Id
    @SequenceGenerator(
            name = "rider_profile_sequence",
            sequenceName = "rider_profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "rider_profile_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public RiderProfile(String typeOfRider, double totalDistance) {
        setTypeOfRider(typeOfRider);
        setTotalDistance(totalDistance);
    }
    public RiderProfile(){

    }

    @Override
    public String toString() {
        return "RiderProfile{" +
                "id=" + id +
                ", typeOfRider='" + typeOfRider + '\'' +
                ", totalDistance=" + totalDistance +
                '}';
    }
}
