package cr.ac.una.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Mocion")
public class Mocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_MOCION;
    private int tipo;
    private Date fecha;
    private String texto;
    @ManyToOne
    @JoinColumn(name = "TIPO_MOCION",nullable = false)
    private TipoMocion tipoMocion;
    @OneToMany(mappedBy = "mocion")//Objeto de conexion para mapeo a PersonaMocion
    private Set<PersonaMocion> personaMocions;

    public int getID_MOCION() {
        return ID_MOCION;
    }

    public void setID_MOCION(int ID_MOCION) {
        this.ID_MOCION = ID_MOCION;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoMocion getTipoMocion() { return tipoMocion; }

    public void setTipoMocion(TipoMocion tipoMocion) { this.tipoMocion = tipoMocion; }

    public Set<PersonaMocion> getPersonaMocions() { return personaMocions; }

    public void setPersonaMocions(Set<PersonaMocion> personaMocions) { this.personaMocions = personaMocions; }

    public Mocion() {
    }

    @Override
    public String toString() {
        return "Mocion{" +
                "ID_MOCION=" + ID_MOCION +
                ", tipo=" + tipo +
                ", fecha='" + fecha + '\'' +
                ", texto='" + texto + '\'' + '}';
    }
}
