package guru.springframework.sfgmsscbrewery.web.mappers;

import guru.springframework.sfgmsscbrewery.domain.Beer;
import guru.springframework.sfgmsscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerdtoToBeer(BeerDto beerDto);
}
