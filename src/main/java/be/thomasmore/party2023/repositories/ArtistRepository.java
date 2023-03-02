package be.thomasmore.party2023.repositories;

import be.thomasmore.party2023.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist,Integer> {
    Optional<Artist> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Artist> findFirstByIdGreaterThanOrderById(int id);
    Optional<Artist> findFirstByOrderByIdDesc();
    Optional<Artist> findFirstByOrderByIdAsc();
    List<Artist> findAll();

    List<Artist> findByArtistNameContainingIgnoreCase(String keyword);
}
