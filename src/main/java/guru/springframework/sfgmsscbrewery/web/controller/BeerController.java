/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.sfgmsscbrewery.web.controller;

import guru.springframework.sfgmsscbrewery.services.BeerService;
import guru.springframework.sfgmsscbrewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for Spring MVC
 *
 * @author Martin Wunderlich
 */
@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        BeerDto beer = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }
}
