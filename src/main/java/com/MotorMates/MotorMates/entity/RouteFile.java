package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "routefile")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RouteFile {
    @Id
    @UuidGenerator
    private UUID id;

    private String routeFileName;
    private String type;

    @Lob
    private byte[] data;

    public RouteFile(String filename, String contentType, byte[] bytes) {
    }
}
