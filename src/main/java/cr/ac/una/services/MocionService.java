package cr.ac.una.services;

import cr.ac.una.entities.Mocion;
import cr.ac.una.repositories.MocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MocionService {

    @Autowired
    private MocionRepository mocionRepository;
    public List<Mocion> getAllMociones() {
        List<Mocion> list = new ArrayList<Mocion>();
        mocionRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void createMocion(Mocion mocion){
        mocionRepository.save(mocion);
    }

    public void deleteMocion(Integer id){
        mocionRepository.deleteById(id);
    }

    public Mocion findMocion(Integer id){
        return mocionRepository.findById(id).get();
    }

    public void updateMocion(Mocion mocion){
        mocionRepository.save(mocion);
    }
}
