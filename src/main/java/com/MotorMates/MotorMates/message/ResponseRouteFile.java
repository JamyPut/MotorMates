package com.MotorMates.MotorMates.message;

import lombok.Data;

@Data
public class ResponseRouteFile {
    private String name;
    private String url;
    private String type;
    private long size;

    public ResponseRouteFile(String routeFileName, String routeFileDownloadUri, String type, int length) {
    }
}
