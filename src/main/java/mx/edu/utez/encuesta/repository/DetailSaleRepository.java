/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.DetailSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import org.springframework.context.annotation.Configuration;

/**
 * @author dvd
 */
@Configuration
public interface DetailSaleRepository extends JpaRepository<DetailSale, Serializable>{
    public DetailSale findById(Integer idDetailSale);
}
