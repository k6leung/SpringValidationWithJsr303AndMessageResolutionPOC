package com.example.validationtest.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataForm {

    @NotEmpty(message = "strVal.not.empty")
    private String strVal;

    private Integer intVal;
}
