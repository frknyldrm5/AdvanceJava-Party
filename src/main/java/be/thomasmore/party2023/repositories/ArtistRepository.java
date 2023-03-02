package be.thomasmore.party2023.repositories;

import be.thomasmore.party2023.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist,Integer> {
    Optional<Artist> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Artist> findFirstByIdGreaterThanOrderById(int id);
    Optional<Artist> findFirstByOrderByIdDesc();
    Optional<Artist> findFirstByOrderByIdAsc();
    List<Artist> findAll();
    List<Artist> findByArtistNameContainingIgnoreCase(String keyword);

    @Query("SELECT a FROM Artist a " +
            "WHERE (LOWER(a.artistName) LIKE LOWER(CONCAT('%',:keyword,'%'))) " +
            "OR (LOWER(a.portfolio) LIKE LOWER(CONCAT('%',:keyword,'%'))) " +
            "OR (LOWER(a.bio) LIKE LOWER(CONCAT('%',:keyword,'%')))")
    List<Artist> findArtistsContainingKeyword(@Param("keyword") String keyword);


    @Query("SELECT a FROM Artist a WHERE :word IS NULL OR LOWER(a.artistName) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(a.bio) LIKE LOWER(CONCAT('%',:word,'%')) " +
            "OR LOWER(a.portfolio) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(a.genre) LIKE LOWER(CONCAT('%',:word,'%'))")
    List<Artist> findByKeyword(@Param("word") String word);
}
