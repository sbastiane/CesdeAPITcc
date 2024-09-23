package com.example.LogisticAPP.helpers.messages;

public enum errorMessages {


    INVALID_VOLUME("El volumen ingresado es invalido"),
    INVALID_WEIGHT("El peso ingresado es invalido"),
    INVALID_DESCRIPTION("La descripcion no es valida"),
    INVALID_NAME("El nombre no es valido"),
    INVALID_POSITIVEVOLUME("El volumen no es el correcto"),
    INVALID_POSITIVEWEIGHT("El peso no es el correcto"),
    INVALID_OCCUPEDVOLUME("El volumen ocupado no es el correcto"),
    INVALID_OCCUPEDWEIGHT("El Peso ocupado no es el correcto")
    ;

    private String message;

    errorMessages() {
    }

    errorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
