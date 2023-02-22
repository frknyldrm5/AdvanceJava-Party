package be.thomasmore.party2023.repositories;

import be.thomasmore.party2023.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist,Integer> {
}
