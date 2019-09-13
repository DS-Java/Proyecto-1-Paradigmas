package cr.ac.una.repositories;

import cr.ac.una.entities.TipoMocion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMocionRepository extends CrudRepository<TipoMocion, Integer> {
}
