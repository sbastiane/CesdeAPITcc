package com.example.LogisticAPP.controllers;

import com.example.LogisticAPP.models.wineryZone;
import com.example.LogisticAPP.services.ServiceWineryZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/logisticAPP/v1/winery_zones")
public class wineryZoneController {

    @Autowired
    ServiceWineryZone serviceWineryZone;

    @PostMapping
    public ResponseEntity<?> callingServicesToSave(@RequestBody wineryZone wineryZoneData){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.serviceWineryZone.Register(wineryZoneData));
        }catch(Exception error){
            HashMap<String, Object>errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    @GetMapping
    public ResponseEntity<?>callingServiceToSearch(){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceWineryZone.searchingWineryZone());
        }catch (Exception error){
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getWineryZoneById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceWineryZone.findById(id));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para actualizar una zona
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWineryZone(@PathVariable Integer id, @RequestBody wineryZone wineryZoneData) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceWineryZone.updateWineryZone(id, wineryZoneData));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para eliminar una zona
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWineryZone(@PathVariable Integer id) {
        try {
            this.serviceWineryZone.deleteById(id);
            HashMap<String, Object> successReply = new HashMap<>();
            successReply.put("message", "Zone deleted successfully");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(successReply);
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }


}
