package com.example.LogisticAPP.services;

import com.example.LogisticAPP.helpers.messages.errorMessages;
import com.example.LogisticAPP.helpers.validators.merchandiseValidation;
import com.example.LogisticAPP.models.Merchandise;
import com.example.LogisticAPP.repositories.IMerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceMerchandise {

    @Autowired
    IMerchandiseRepository dataBaseConsult;

    @Autowired
    merchandiseValidation validation;

    //Registrar en BD una mercancia
    public Merchandise register(Merchandise merchandiseData) throws Exception{
        //Verificar si las validaciones son correctas
        //Si validacion pasa podria necesitar hacer operacion con los datos
        //Si validacion pasa yo guardo la mercancia
        //Si no pasa validacion responder al cliente con un mensaje de error

        try{

            if (!this.validation.descriptionValidation(merchandiseData.getDescription())){
                throw new Exception(errorMessages.INVALID_DESCRIPTION.getMessage());
            }

            if (!this.validation.volumeValidation(merchandiseData.getOccupiedVolume())){
                throw new Exception(errorMessages.INVALID_VOLUME.getMessage());
            }

            if (!this.validation.weightValidation(merchandiseData.getOccupiedWeight())){
                throw new Exception(errorMessages.INVALID_WEIGHT.getMessage());
            }

            return this.dataBaseConsult.save(merchandiseData);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }
    //Consultar informacion de todas las mercancias

    public List<Merchandise>searchingMerchandise() throws Exception{
        try {
            return this.dataBaseConsult.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Consultar informacion de una mercancia por ID
    public Merchandise findById(Integer iup) throws Exception {
        try {
            return this.dataBaseConsult.findById(iup).orElseThrow(() -> new Exception("Merchandise not found"));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para actualizar una mercancía
    public Merchandise updateMerchandise(Integer iup, Merchandise updatedData) throws Exception {
        try {
            Merchandise existingMerchandise = this.findById(iup);

            if (!this.validation.descriptionValidation(updatedData.getDescription())) {
                throw new Exception(errorMessages.INVALID_DESCRIPTION.getMessage());
            }
            if (!this.validation.volumeValidation(updatedData.getOccupiedVolume())) {
                throw new Exception(errorMessages.INVALID_VOLUME.getMessage());
            }
            if (!this.validation.weightValidation(updatedData.getOccupiedWeight())) {
                throw new Exception(errorMessages.INVALID_WEIGHT.getMessage());
            }

            existingMerchandise.setNames(updatedData.getNames());
            existingMerchandise.setDescription(updatedData.getDescription());
            existingMerchandise.setOccupiedVolume(updatedData.getOccupiedVolume());
            existingMerchandise.setOccupiedWeight(updatedData.getOccupiedWeight());
            existingMerchandise.setEntryDate(updatedData.getEntryDate());
            existingMerchandise.setDepartureDate(updatedData.getDepartureDate());

            return this.dataBaseConsult.save(existingMerchandise);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar una mercancía por ID
    public void deleteById(Integer iup) throws Exception {
        try {
            Merchandise merchandise = this.findById(iup); // Verificar si la mercancía existe
            this.dataBaseConsult.delete(merchandise);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para buscar mercancías por nombre
    public List<Merchandise> findByNames(String names) throws Exception {
        try {
            List<Merchandise> merchandises = this.dataBaseConsult.findByNames(names);
            if (merchandises.isEmpty()) {
                throw new Exception("No merchandise found with the given name");
            }
            return merchandises;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
