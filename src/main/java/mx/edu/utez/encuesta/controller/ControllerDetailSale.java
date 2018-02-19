/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.MoncasApplication;
import mx.edu.utez.encuesta.entity.DetailSale;
import mx.edu.utez.encuesta.service.DetailSaleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author elpor
 */
@RestController

@RequestMapping("/api/detailSale")
public class ControllerDetailSale {

    static Logger log = Logger.getLogger(MoncasApplication.class.getName());

    @Autowired
	private DetailSaleService detailSaleService;
@CrossOrigin
	@GetMapping("/getAll")
	public List<DetailSale> getDetailSale(){
        log.info("Retrieving all detailSales");
		return detailSaleService.findAllDetailSale();
	}
@CrossOrigin
    @RequestMapping("/{id}")
    public DetailSale findById(@PathVariable("id") Integer idDetailSale){
            log.info("Returning detailSale with id: " + idDetailSale);
            return detailSaleService.findById(idDetailSale);
        }
@CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer idDetailSale){
        log.info("Deleting detailSale with id: " + idDetailSale);
        detailSaleService.delete(idDetailSale);
    }
@CrossOrigin
    @RequestMapping(value = "/detailSale/", method = RequestMethod.POST)
    public void createDetailSale(@RequestBody DetailSale detailSale) {
        log.info("Saving detailSale: " + detailSale.toString());
        detailSaleService.saveDetailSale(detailSale);
    }
@CrossOrigin
    @RequestMapping(value = "/detailSale/update", method = RequestMethod.PATCH)
    public void updateDetailSale(@RequestBody DetailSale detailSale) {
        log.info("Updating detailSale: " + detailSale.toString());
        detailSaleService.saveDetailSale(detailSale);
    }
}
