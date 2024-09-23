package com.example.LogisticAPP.services;

import com.example.LogisticAPP.models.Customer;
import com.example.LogisticAPP.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCustomer {

    @Autowired
    ICustomerRepository customerRepository;

    // Método para registrar un cliente
    public Customer registerCustomer(Customer customerData) throws Exception {
        try {
            return this.customerRepository.save(customerData);
        } catch (Exception error) {
            throw new Exception("Error while registering the customer: " + error.getMessage());
        }
    }

    // Método para obtener todos los clientes
    public List<Customer> findAllCustomers() throws Exception {
        try {
            return this.customerRepository.findAll();
        } catch (Exception error) {
            throw new Exception("Error while fetching customers: " + error.getMessage());
        }
    }

    // Método para obtener un cliente por ID
    public Customer findCustomerById(Integer id) throws Exception {
        try {
            return this.customerRepository.findById(id)
                    .orElseThrow(() -> new Exception("Customer not found"));
        } catch (Exception error) {
            throw new Exception("Error while fetching the customer: " + error.getMessage());
        }
    }

    // Método para actualizar un cliente
    public Customer updateCustomer(Integer id, Customer updatedData) throws Exception {
        try {
            Customer existingCustomer = this.findCustomerById(id);

            existingCustomer.setNames(updatedData.getNames());
            existingCustomer.setDepartament(updatedData.getDepartament());
            existingCustomer.setTown(updatedData.getTown());
            existingCustomer.setAddress(updatedData.getAddress());
            existingCustomer.setPostalCode(updatedData.getPostalCode());
            existingCustomer.setRol(updatedData.getRol());
            existingCustomer.setEmail(updatedData.getEmail());
            existingCustomer.setPhone(updatedData.getPhone());

            return this.customerRepository.save(existingCustomer);
        } catch (Exception error) {
            throw new Exception("Error while updating the customer: " + error.getMessage());
        }
    }

    // Método para eliminar un cliente por ID
    public void deleteCustomerById(Integer id) throws Exception {
        try {
            Customer customer = this.findCustomerById(id);
            this.customerRepository.delete(customer);
        } catch (Exception error) {
            throw new Exception("Error while deleting the customer: " + error.getMessage());
        }
    }
}
