package cr.ac.una.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONA_MOCION")
public class PersonaMocion implements Serializable {
    @Id
    private int ID_PERSONA_MOCION;
    @ManyToOne
    @JoinColumn(name = "PERSONA",nullable = false)//, columnDefinition = "INT"
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "MOCION",nullable = false)//, columnDefinition = "INT"
    private Mocion mocion;

    public PersonaMocion() {
    }

    public int getID_PERSONA_MOCION() {
        return ID_PERSONA_MOCION;
    }

    public void setID_PERSONA_MOCION(int ID_PERSONA_MOCION) {
        this.ID_PERSONA_MOCION = ID_PERSONA_MOCION;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Mocion getMocion() {
        return mocion;
    }

    public void setMocion(Mocion mocion) {
        this.mocion = mocion;
    }

    @Override
    public String toString() {
        return "PersonaMocion{" +
                "ID_PERSONA_MOCION=" + ID_PERSONA_MOCION +
                '}';
    }
}
