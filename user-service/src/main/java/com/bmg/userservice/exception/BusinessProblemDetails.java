package com.bmg.userservice.exception;

import lombok.Data;

import java.util.Map;

@Data
public class BusinessProblemDetails extends BaseProblemDetails{

    public BusinessProblemDetails(){

        setTitle("Business Rule ");
        setStatus("500");
    }
}
