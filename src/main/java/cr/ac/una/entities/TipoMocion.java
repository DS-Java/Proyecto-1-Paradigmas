package cr.ac.una.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Tipo_Mocion")
public class TipoMocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_TIPO_MOCION;
    private String descripcion;

    @OneToMany(mappedBy = "tipoMocion")
    private Set<Mocion> mociones;

    public int getID_TIPO_MOCION() {
        return ID_TIPO_MOCION;
    }

    public void setID_TIPO_MOCION(int ID_TIPO_MOCION) {
        this.ID_TIPO_MOCION = ID_TIPO_MOCION;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Mocion> getMociones() { return mociones; }

    public void setMociones(Set<Mocion> mociones) { this.mociones = mociones; }

    public TipoMocion() {
    }

    @Override
    public String toString() {
        return
                ""+ ID_TIPO_MOCION;
    }
}
