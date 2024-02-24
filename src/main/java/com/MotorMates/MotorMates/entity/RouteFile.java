package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "routefile")
public class RouteFile {
    @Id
    @UuidGenerator
    private UUID id;

    private String routeFileName;
    private String type;

    @Lob
    private byte[] data;

    public String getRouteFileName() {
        return routeFileName;
    }

    public void setRouteFileName(String routeFileName) {
        this.routeFileName = routeFileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public RouteFile(UUID id, String routeFileName, String type, byte[] data) {
        this.id = id;
        this.routeFileName = routeFileName;
        this.type = type;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RouteFile() {
    }

    public RouteFile(String filename, String contentType, byte[] bytes) {
    }
}
