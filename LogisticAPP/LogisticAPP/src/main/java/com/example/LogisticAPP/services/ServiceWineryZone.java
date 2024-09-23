package com.example.LogisticAPP.services;


import com.example.LogisticAPP.helpers.messages.errorMessages;
import com.example.LogisticAPP.helpers.validators.wineryZoneValidation;
import com.example.LogisticAPP.models.Merchandise;
import com.example.LogisticAPP.models.wineryZone;
import com.example.LogisticAPP.repositories.IWineryzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWineryZone {

    @Autowired
    IWineryzoneRepository dataBaseConsult;

    @Autowired
    wineryZoneValidation validation;

    public wineryZone Register (wineryZone wineryZoneData) throws Exception {

        try {
            if (!this.validation.isValidName(wineryZoneData.getZoneName())) {
                throw new Exception(errorMessages.INVALID_NAME.getMessage());
            }
            if (!this.validation.isPositiveVolume(wineryZoneData.getMaxVolume())) {
                throw new Exception(errorMessages.INVALID_POSITIVEVOLUME.getMessage());
            }
            if (!this.validation.isPositiveWeight(wineryZoneData.getMaxWeight())) {
                throw new Exception(errorMessages.INVALID_POSITIVEWEIGHT.getMessage());
            }
            if (!this.validation.isPositiveOccupiedVolume(wineryZoneData.getOccupiedVolume())) {
                throw new Exception(errorMessages.INVALID_OCCUPEDVOLUME.getMessage());
            }
            if (!this.validation.isPositiveOccupiedWeight(wineryZoneData.getOccupiedWeight())) {
                throw new Exception(errorMessages.INVALID_OCCUPEDWEIGHT.getMessage());
            }
            return this.dataBaseConsult.save(wineryZoneData);

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }

    public List<wineryZone> searchingWineryZone() throws Exception{
        try {
            return this.dataBaseConsult.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Método para buscar una zona por ID
    public wineryZone findById(Integer zoneId) throws Exception {
        try {
            return this.dataBaseConsult.findById(zoneId).orElseThrow(() -> new Exception("Zone not found"));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para actualizar una zona
    public wineryZone updateWineryZone(Integer zoneId, wineryZone updatedData) throws Exception {
        try {
            wineryZone existingZone = this.findById(zoneId);

            if (!this.validation.isValidName(updatedData.getZoneName())) {
                throw new Exception(errorMessages.INVALID_NAME.getMessage());
            }
            if (!this.validation.isPositiveVolume(updatedData.getMaxVolume())) {
                throw new Exception(errorMessages.INVALID_POSITIVEVOLUME.getMessage());
            }
            if (!this.validation.isPositiveWeight(updatedData.getMaxWeight())) {
                throw new Exception(errorMessages.INVALID_POSITIVEWEIGHT.getMessage());
            }
            if (!this.validation.isPositiveOccupiedVolume(updatedData.getOccupiedVolume())) {
                throw new Exception(errorMessages.INVALID_OCCUPEDVOLUME.getMessage());
            }
            if (!this.validation.isPositiveOccupiedWeight(updatedData.getOccupiedWeight())) {
                throw new Exception(errorMessages.INVALID_OCCUPEDWEIGHT.getMessage());
            }

            existingZone.setZoneName(updatedData.getZoneName());
            existingZone.setMaxVolume(updatedData.getMaxVolume());
            existingZone.setMaxWeight(updatedData.getMaxWeight());
            existingZone.setOccupiedVolume(updatedData.getOccupiedVolume());
            existingZone.setOccupiedWeight(updatedData.getOccupiedWeight());

            return this.dataBaseConsult.save(existingZone);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar una zona por ID
    public void deleteById(Integer zoneId) throws Exception {
        try {
            wineryZone zone = this.findById(zoneId); // Verifica si existe la zona
            this.dataBaseConsult.delete(zone);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
