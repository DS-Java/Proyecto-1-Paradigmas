package cr.ac.una.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Mocion")
public class Mocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_MOCION;
    private int tipo;
    private String fecha;
    private String texto;
    @ManyToOne//Esta es la entidad Hijo de Tipo Mocion
    @JoinColumn(name = "TIPO_MOCION",nullable = false)//, columnDefinition = "INT"
    private TipoMocion tipoMocion;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
