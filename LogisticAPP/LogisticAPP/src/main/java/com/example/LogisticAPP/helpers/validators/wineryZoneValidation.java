package com.example.LogisticAPP.helpers.validators;

import org.springframework.stereotype.Component;

@Component
public class wineryZoneValidation {

    //Nombre de 50 caracteres

    //Que el volumen maximo sea positivo

    //Que el peso maximo sea positivo

    //Que el volumen ocupado sea positivo

    //Que el peso ocupado sea positivo

    // Validar que el nombre no supere 50 caracteres y no esté en blanco
    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 50;
    }

    // Validar que el volumen máximo sea positivo
    public boolean isPositiveVolume(double maxVolume) {
        return maxVolume > 0;
    }

    // Validar que el peso máximo sea positivo
    public boolean isPositiveWeight(double maxWeight) {
        return maxWeight > 0;
    }

    // Validar que el volumen ocupado sea positivo
    public boolean isPositiveOccupiedVolume(double occupiedVolume) {
        return occupiedVolume > 0;
    }

    // Validar que el peso ocupado sea positivo
    public boolean isPositiveOccupiedWeight(double occupiedWeight) {
        return occupiedWeight > 0;
    }
}
