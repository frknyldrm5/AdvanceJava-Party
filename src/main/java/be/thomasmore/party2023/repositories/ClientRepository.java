package be.thomasmore.party2023.repositories;

import be.thomasmore.party2023.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {

}
