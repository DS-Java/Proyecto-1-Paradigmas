package cr.ac.una.services;

import cr.ac.una.entities.PersonaMocion;
import cr.ac.una.repositories.PersonaMocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaMocionService {

    @Autowired
    private PersonaMocionRepository personaMocionRepository;
    public List<PersonaMocion> getAllPersonaMocions() {
        List<PersonaMocion> list = new ArrayList<PersonaMocion>();
        personaMocionRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void createPersonaMocion(PersonaMocion personaMocion){
        personaMocionRepository.save(personaMocion);
    }

    public void deletePersonaMocion(Integer id){
        personaMocionRepository.deleteById(id);
    }

    public PersonaMocion findPersonaMocion(Integer id){
        return personaMocionRepository.findById(id).get();
    }

    public void updatePersonaMocion(PersonaMocion personaMocion){
        personaMocionRepository.save(personaMocion);
    }

}
