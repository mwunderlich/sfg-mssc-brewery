/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.sfgmsscbrewery.services;

import guru.springframework.sfgmsscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service impl
 *
 * @author Martin Wunderlich
 */
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("My beer")
                .beerStyle("Helles")
                .build();
    }
}
