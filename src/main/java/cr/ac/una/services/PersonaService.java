package cr.ac.una.services;

import cr.ac.una.entities.Persona;
import cr.ac.una.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    public List<Persona> getAllPersonas() {
        List<Persona> list = new ArrayList<Persona>();
        personaRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void createPersona(Persona persona){
        personaRepository.save(persona);
    }

    public void deletePersona(Integer id){
        personaRepository.deleteById(id);
    }

    public Persona findPersona(Integer id){
        return personaRepository.findById(id).get();
    }

    public void updatePersona(Persona persona){
        personaRepository.save(persona);
    }
}
