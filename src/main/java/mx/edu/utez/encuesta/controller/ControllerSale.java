/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.MoncasApplication;
import mx.edu.utez.encuesta.entity.Sale;
import mx.edu.utez.encuesta.service.SaleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author elpor
 */
@RestController

@RequestMapping("/api/sale")
public class ControllerSale {

    static Logger log = Logger.getLogger(MoncasApplication.class.getName());

    @Autowired
	private SaleService saleService;
	@GetMapping("/getAll")
	public List<Sale> getSale(){
        log.info("Retrieving all sales");
        return saleService.findAllSale();
	}
    @CrossOrigin
    @RequestMapping("/{id}")
    public Sale findById(@PathVariable("id") Integer idSale){
        log.info("Returning sale with id: " + idSale);
        return saleService.findById(idSale);
    }
    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer idSale){
        log.info("Deleting sale with id: " + idSale);
        saleService.delete(idSale);
    }
    @CrossOrigin
    @RequestMapping(value = "/sale/", method = RequestMethod.POST)
    public void createSale(@RequestBody Sale sale) {
        log.info("Saving sale: " + sale.toString());
        saleService.saveSale(sale);
    }
    @CrossOrigin
    @RequestMapping(value = "/update/", method = RequestMethod.PATCH)
    public void updateSale(@RequestBody Sale sale) {
        System.out.println("ENTROOOOOOOOOOOOOOOOOOOOOOO");
        log.info("Updating sale: " + sale.toString());
        saleService.saveSale(sale);
    }
}
