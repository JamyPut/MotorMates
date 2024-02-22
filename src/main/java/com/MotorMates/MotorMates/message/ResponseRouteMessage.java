package com.MotorMates.MotorMates.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRouteMessage {
    public ResponseRouteMessage(String message) {
        this.message = message;
    }

    private String message;
}
