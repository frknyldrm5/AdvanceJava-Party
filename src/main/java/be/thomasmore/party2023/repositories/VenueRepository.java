package be.thomasmore.party2023.repositories;

import be.thomasmore.party2023.model.Venue;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VenueRepository extends CrudRepository<Venue,Integer> {
    Iterable<Venue> findByOutdoor(boolean isOutdoor);
    Iterable<Venue> findByIndoor(boolean isIndoor);
    Iterable<Venue> findByCapacity(int capacity);
    Iterable<Venue> findByCapacityLessThanEqual(int capacity);
    Iterable<Venue> findByCapacityIsBetween(int min, int max);
    Iterable<Venue> findByCapacityIsGreaterThan(int capacity);

    Optional<Venue> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Venue> findFirstByIdGreaterThanOrderById(int id);
    Optional<Venue> findFirstByOrderByIdDesc();
    Optional<Venue> findFirstByOrderByIdAsc();





}
