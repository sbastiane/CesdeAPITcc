package com.example.LogisticAPP.controllers;


import com.example.LogisticAPP.models.Merchandise;
import com.example.LogisticAPP.services.ServiceMerchandise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/logisticAPP/v1/merchandises")
public class merchandiseController {

    //INYECTAR DEPENDENCIA AL SERVICIO

    @Autowired
    ServiceMerchandise serviceMerchandise;

    // SE CREA UN METODO PARA LLAMAR A CADA UNO DE LOS SERVICIOS DISPONIBLES
    @PostMapping
    public ResponseEntity<?> callingServicesToSave(@RequestBody Merchandise merchandiseData){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.serviceMerchandise.register(merchandiseData));

        }catch(Exception error){
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    @GetMapping
    public ResponseEntity<?>callingServiceToSearch(){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceMerchandise.searchingMerchandise());
        }catch (Exception error){
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para consultar una mercancía por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getMerchandiseById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceMerchandise.findById(id));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para actualizar una mercancía
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMerchandise(@PathVariable Integer id, @RequestBody Merchandise merchandiseData) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceMerchandise.updateMerchandise(id, merchandiseData));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para eliminar una mercancía
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMerchandise(@PathVariable Integer id) {
        try {
            this.serviceMerchandise.deleteById(id);
            HashMap<String, Object> successReply = new HashMap<>();
            successReply.put("message", "Merchandise deleted successfully");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(successReply);
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para buscar mercancías por nombre
    @GetMapping("/searchByName")
    public ResponseEntity<?> getMerchandiseByName(@RequestParam String names) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceMerchandise.findByNames(names));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

}
