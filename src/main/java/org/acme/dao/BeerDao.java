package org.acme.dao;

import org.acme.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerDao extends JpaRepository<Beer, Long> {
    @Query
    void deleteByTastedTrue();
}
