package cr.ac.una.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="transaccion")
    private String transaccion;
    @Column(name="tabla")
    private String tabla;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Auditoria() {
    }

    @Override
    public String toString() {
        return "Auditoria{" +
                "id=" + id +
                ", transaccion='" + transaccion + '\'' +
                ", tabla='" + tabla + '\'' +
                '}';
    }
}
