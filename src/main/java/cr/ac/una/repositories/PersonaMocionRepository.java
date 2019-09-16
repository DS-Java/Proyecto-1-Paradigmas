package cr.ac.una.repositories;

import cr.ac.una.entities.PersonaMocion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaMocionRepository extends CrudRepository<PersonaMocion, Integer> {
}
