package com.example.sem4;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BandRepository extends CrudRepository<RockBand, Long> {
    List<RockBand> findByName(String name);
}
