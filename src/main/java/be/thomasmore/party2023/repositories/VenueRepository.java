package be.thomasmore.party2023.repositories;

import be.thomasmore.party2023.model.Artist;
import be.thomasmore.party2023.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VenueRepository extends CrudRepository<Venue,Integer> {
//    Iterable<Venue> findByOutdoor(boolean isOutdoor);
//    Iterable<Venue> findByIndoor(boolean isIndoor);
//    Iterable<Venue> findByCapacity(int capacity);
//    Iterable<Venue> findByCapacityLessThanEqual(int capacity);
//    Iterable<Venue> findByCapacityIsBetween(int min, int max);
//    Iterable<Venue> findByCapacityIsGreaterThan(int capacity);
//
//    Optional<Venue> findFirstByIdLessThanOrderByIdDesc(int id);
//    Optional<Venue> findFirstByIdGreaterThanOrderById(int id);
//    Optional<Venue> findFirstByOrderByIdDesc();
//    Optional<Venue> findFirstByOrderByIdAsc();

    List<Venue> findAll();
    List<Venue> findByCapacityIsGreaterThanEqual(int capacity);
    List<Venue> findByCapacityIsLessThan(int capacity);
    List<Venue> findByCapacityIsBetween(int min, int max);
    Optional<Venue> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Venue> findFirstByIdGreaterThanOrderById(int id);
    Optional<Venue> findFirstByOrderByIdDesc();
    Optional<Venue> findFirstByOrderByIdAsc();
    Iterable<Venue> findByCapacityIsGreaterThan(Integer minimumCapacity);

    Optional<Venue> findByOrderByIdAsc();

    @Query("SELECT v FROM Venue v")
    List<Venue> findAllVenues();

    @Query("SELECT v FROM Venue v WHERE v.capacity <= 300")
    List<Venue> findBySmallCapacity();

    @Query("SELECT v FROM Venue v WHERE v.capacity <= :max")
    List<Venue> findBySmallCapacity(@Param("max") int max);

    @Query("SELECT v FROM Venue v WHERE v.capacity BETWEEN ?1 AND ?2")
    List<Venue> findByCapacityBetweenQuery(int min, int max);



    @Query("SELECT a FROM Artist a " +
            "WHERE ( LOWER (a.artistName) LIKE LOWER(CONCAT('%',:keyword,'%')))" +
            "OR(LOWER(a.portfolio) LIKE LOWER(CONCAT('%',:keyword,'%'))) " +
            "OR(LOWER(a.bio) LIKE LOWER(CONCAT('%',:keyword,'%')))")
    List<Artist> findArtistsContainingKeyword(@Param("keyword")String keyword);


   @Query("SELECT v FROM Venue v " +
           "WHERE (?1 IS NULL OR v.capacity >= ?1) " +
           "AND (?2 IS NULL OR v.capacity <= ?2)" +
           "AND (?3 IS NULL OR v.indoor = ?3)")

    List<Venue> findComplicatedQuery(Integer min,
                                     Integer max,
                                     Boolean indoor);







}
