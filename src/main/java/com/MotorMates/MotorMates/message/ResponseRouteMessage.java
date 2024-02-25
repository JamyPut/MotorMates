package com.MotorMates.MotorMates.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRouteMessage {
    private String message;

    public ResponseRouteMessage(String message) {
        this.message = message;
    }
}
