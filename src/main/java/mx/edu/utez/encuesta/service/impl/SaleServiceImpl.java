/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.Sale;
import mx.edu.utez.encuesta.repository.SaleRepository;
import mx.edu.utez.encuesta.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author dvd
 */
@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> findAllSale() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findById(Integer idSale) {
        return saleRepository.findById(idSale);
    }

    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Integer delete(Integer idSale) {
        saleRepository.delete(idSale);
        return idSale;
    }
}
