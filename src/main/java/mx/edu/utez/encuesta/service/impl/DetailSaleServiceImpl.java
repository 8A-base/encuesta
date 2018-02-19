/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.DetailSale;
import mx.edu.utez.encuesta.repository.DetailSaleRepository;
import mx.edu.utez.encuesta.service.DetailSaleService;
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
public class DetailSaleServiceImpl implements DetailSaleService {

    @Autowired
    private DetailSaleRepository detailSaleRepository;

    @Override
    public List<DetailSale> findAllDetailSale() {
        return detailSaleRepository.findAll();
    }

    @Override
    public DetailSale findById(Integer idDetailSale) {
        return detailSaleRepository.findById(idDetailSale);
    }

    @Override
    public DetailSale saveDetailSale(DetailSale detailSale) {
        return detailSaleRepository.save(detailSale);
    }

    @Override
    public Integer delete(Integer idDetailSale) {
        detailSaleRepository.delete(idDetailSale);
        return idDetailSale;
    }
}
