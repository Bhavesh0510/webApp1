package com.example.webApp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByAtech(String tech);

    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where atech=?1 order by aname")
    List<Alien> findByAtechSorted(String tech);

}
