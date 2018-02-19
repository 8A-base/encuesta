/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.Sale;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 *
 * @author dvd
 */
@Configuration
public interface SaleRepository extends JpaRepository<Sale, Serializable>{
    public Sale findById(Integer idSale);
}
