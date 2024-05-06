package com.bmg.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseProblemDetails {

    private String title;
    private String detail;
    private String status;

}
