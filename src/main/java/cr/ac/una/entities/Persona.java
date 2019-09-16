package cr.ac.una.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity

@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PERSONA;
    private String nombre;
    private String correo;
    private String telefono;
    private String CENTRO_TRABAJO;
    @OneToMany(mappedBy = "persona")//Objeto de conexion a PersonaMocion
    private Set<PersonaMocion> personaMocions;

    public Persona() {
    }

    public int getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(int ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCENTRO_TRABAJO() {
        return CENTRO_TRABAJO;
    }

    public void setCENTRO_TRABAJO(String CENTRO_TRABAJO) {
        this.CENTRO_TRABAJO = CENTRO_TRABAJO;
    }

    public Set<PersonaMocion> getPersonaMocions() { return personaMocions; }

    public void setPersonaMocions(Set<PersonaMocion> personaMocions) { this.personaMocions = personaMocions; }

    @Override
    public String toString() {
        return "Persona{" +
                "ID_PERSONA=" + ID_PERSONA +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", CENTRO_TRABAJO='" + CENTRO_TRABAJO + '\'' +
                '}';
    }
}
