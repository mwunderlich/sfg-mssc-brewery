package guru.springframework.sfgmsscbrewery.services;

import guru.springframework.sfgmsscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeerById(UUID beerId);
}
