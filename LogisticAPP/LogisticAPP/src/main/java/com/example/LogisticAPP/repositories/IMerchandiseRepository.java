package com.example.LogisticAPP.repositories;

import com.example.LogisticAPP.models.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMerchandiseRepository  extends JpaRepository<Merchandise,Integer> {
    List<Merchandise> findByNames(String names);
}
