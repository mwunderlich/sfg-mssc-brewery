
package guru.springframework.sfgmsscbrewery.services;

import guru.springframework.sfgmsscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service impl
 *
 * @author Martin Wunderlich
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("My beer")
                .beerStyle("Helles")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //TODO Impl
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("deleteing beer with id " + beerId);
    }
}
