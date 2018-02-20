/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Person;
import mx.edu.utez.encuesta.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author elpor
 */
@RestController

@RequestMapping("/api/person")
public class ControllerPerson {

    static Logger log = Logger.getLogger(EncuestaApplication.class.getName());

    @Autowired
	private PersonService personService;
@CrossOrigin
	@GetMapping("/getAll")
	public List<Person> getPerson(){
        log.info("Retrieving all persons");
		return personService.findAllPerson();
	}
@CrossOrigin
    @RequestMapping("/{id}")
    public Person findById(@PathVariable("id") Integer idPerson){
            log.info("Returning person with id: " + idPerson);
            return personService.findById(idPerson);
        }
@CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer idPerson){
        log.info("Deleting person with id: " + idPerson);
        personService.delete(idPerson);
    }
@CrossOrigin
    @RequestMapping(value = "/person/", method = RequestMethod.POST)
    public void createPerson(@RequestBody Person person) {
        log.info("Saving person: " + person.toString());
        personService.savePerson(person);
    }
@CrossOrigin
    @RequestMapping(value = "/sale/update", method = RequestMethod.PATCH)
    public void updatePerson(@RequestBody Person person) {
        log.info("Updating person: " + person.toString());
        personService.savePerson(person);
    }
}
