package cr.ac.una.aop;

import cr.ac.una.entities.Auditoria;
import cr.ac.una.services.AuditoriaService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class TipoMocionAOP {
    @Autowired
    AuditoriaService auditoriaService;

    //ASPECTO DESPUES DE CREAR
    @After("execution(* cr.ac.una.services.TipoMocionService.createTipoMocion(..))")
    public  void auditoriaDespuesAgregarTipoMocion(JoinPoint joinPoint){
        //Lleno el objeto auditoria
        Auditoria a = new Auditoria();
        a.setTransaccion("Agregado");
        a.setTabla("TIPO MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE AGREGAR");
    }
    //ASPECTO DESPUES DE LISTAR
    @After("execution(* cr.ac.una.services.TipoMocionService.getAllTipoMocion(..))")
    public void auditoriaDespuesListarPersonas(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Listado");
        a.setTabla("TIPO MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE LISTAR");
    }



    //ASPECTO DESPUES DE ELIMINAR
    @After("execution(* cr.ac.una.services.TipoMocionService.deleteTipoMocion(..))")
    public void auditoriaDespuesEliminarTipoMocion(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Eliminado");
        a.setTabla("TIPO MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE ELIMINAR");
    }

    //ASPECTO DESPUES DE ACTUALIZAR
    @After("execution(* cr.ac.una.services.TipoMocionService.updateTipoMocion(..))")
    public void auditoriaDespuesActualizarPersona(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Actualizado");
        a.setTabla("TIPO MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE ACTUALIZAR");
    }



}
