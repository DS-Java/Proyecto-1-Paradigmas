package cr.ac.una.services;

import cr.ac.una.entities.Auditoria;
import cr.ac.una.entities.Mocion;
import cr.ac.una.repositories.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public List<Auditoria> getAllAuditorias() {
        List<Auditoria> list = new ArrayList<Auditoria>();
        auditoriaRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void deleteAuditoria(Integer id){
        auditoriaRepository.deleteById(id);
    }

    public void createAuditoria(Auditoria auditoria){
        auditoriaRepository.save(auditoria);
    }
}
