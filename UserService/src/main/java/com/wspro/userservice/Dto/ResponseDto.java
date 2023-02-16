package com.wspro.userservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDto implements Serializable {
    private String status;
    private String message;
    private Object data;

    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
