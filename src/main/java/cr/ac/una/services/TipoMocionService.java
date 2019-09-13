package cr.ac.una.services;

import cr.ac.una.entities.TipoMocion;
import cr.ac.una.repositories.TipoMocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoMocionService {

    @Autowired
    private TipoMocionRepository tipoMocionRepository;
    public List<TipoMocion> getAllTipoMocion() {
        List<TipoMocion> list = new ArrayList<TipoMocion>();
        tipoMocionRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void createTipoMocion(TipoMocion tipoMocion){
        tipoMocionRepository.save(tipoMocion);
    }

    public void deleteTipoMocion(Integer id){
        tipoMocionRepository.deleteById(id);
    }

    public TipoMocion findTipoMocion(Integer id){
        return tipoMocionRepository.findById(id).get();
    }

    public void updateTipoMocion(TipoMocion tipoMocion){
        tipoMocionRepository.save(tipoMocion);
    }
}
