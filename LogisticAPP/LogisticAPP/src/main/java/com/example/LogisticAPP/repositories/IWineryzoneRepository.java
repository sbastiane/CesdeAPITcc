package com.example.LogisticAPP.repositories;
import com.example.LogisticAPP.models.wineryZone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWineryzoneRepository extends JpaRepository<wineryZone,Integer>{
}
