package com.example.LogisticAPP.helpers.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class merchandiseValidation {

    // Validar que volumen solo sea positivo

    public boolean volumeValidation(Double volume){
        return volume>0?true:false;
    }


    // Validar que peso solo sea positivo
    public boolean weightValidation(Double weight){
        return weight>0?true:false;
    }
    // La descripcion solo puede tener hasta 200 caracteres
    public boolean descriptionValidation(String description){
        return description.length()<200?true:false;
    }
    // Las fecha deben tener el formato (MM-DD-YYYY)
    public boolean formatterDateValidation(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateLocalDate = LocalDate.parse(date.toString(), formatter);
        return dateLocalDate.format(formatter).equals(date.toString());
    }

}
