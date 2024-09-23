package com.example.LogisticAPP.controllers;


import com.example.LogisticAPP.models.Customer;
import com.example.LogisticAPP.services.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/logisticAPP/v1/customers")
public class CustomerController {

    @Autowired
    ServiceCustomer serviceCustomer;

    // Método para registrar un cliente
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customerData) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.serviceCustomer.registerCustomer(customerData));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para obtener todos los clientes
    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceCustomer.findAllCustomers());
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceCustomer.findCustomerById(id));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para actualizar un cliente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerData) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.serviceCustomer.updateCustomer(id, customerData));
        } catch (Exception error) {
            HashMap<String, Object> errorReply = new HashMap<>();
            errorReply.put("message", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorReply);
        }
    }

    // Método para eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        try {
            this.serviceCustomer.deleteCustomerById(id);
            HashMap<String, Object> successReply = new HashMap<>();
            successReply.put("message", "Customer deleted successfully");
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
