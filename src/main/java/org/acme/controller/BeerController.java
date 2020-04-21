package org.acme.controller;

import org.acme.dao.BeerDao;
import org.acme.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/beers",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class BeerController {

    private BeerDao beerDao;

    @Autowired
    public BeerController(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    @GetMapping
    public ResponseEntity<List<Beer>> all() {
        return new ResponseEntity<List<Beer>>(beerDao.findAll(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Beer> add(@RequestBody Beer beer) {
        return new ResponseEntity<Beer>(beerDao.save(beer), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Beer> update(@PathVariable Long id, @RequestBody Beer beer) {
        return new ResponseEntity<Beer>(beerDao.save(beer), HttpStatus.OK);
    }

    @Transactional
    @PatchMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Beer> patch(@PathVariable Long id, @RequestBody Beer beer) {
        return new ResponseEntity<Beer>(beerDao.save(beer), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Beer beer = beerDao.findById(id).get();
        beerDao.delete(beer);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<Void> deleteTasted() {
        beerDao.deleteByTastedTrue();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
