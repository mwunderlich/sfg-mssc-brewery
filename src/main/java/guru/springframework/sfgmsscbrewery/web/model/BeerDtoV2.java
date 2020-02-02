
package guru.springframework.sfgmsscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Plain beer POJO
 *
 * @author Martin Wunderlich
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;

    private OffsetDateTime dateTimeCreated;
    private OffsetDateTime dateTimeLastModified;
}

