package cr.ac.una.aop;

import cr.ac.una.entities.Auditoria;
import cr.ac.una.services.AuditoriaService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class PersonaAOP {
    @Autowired
    AuditoriaService auditoriaService;

    //ASPECTO DESPUES DE CREAR
    @After("execution(* cr.ac.una.services.PersonaService.createPersona(..))")
    public void auditoriaDespuesAgregarPersonas(JoinPoint joinPoint){//Funcion para loguear antes de algo
      //Aca creo el objeto Auditoria y lo lleno
        Auditoria a = new Auditoria();
        a.setTransaccion("Agregado");
        a.setTabla("PERSONA");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE AGREGAR");
    }

    /*//ASPECTO DESPUES DE LISTAR
    @After("execution(* cr.ac.una.services.PersonaService.getAllPersonas(..))")
    public void auditoriaDespuesListarPersonas(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Listado");
        a.setTabla("PERSONA");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE LISTAR");
    }*/

    //ASPECTO DESPUES DE ELIMINAR
    @After("execution(* cr.ac.una.services.PersonaService.deletePersona(..))")
    public void auditoriaDespuesEliminarPersona(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Eliminado");
        a.setTabla("PERSONA");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE ELIMINAR");
    }


    //ASPECTO DESPUES DE ACTUALIZAR
    @After("execution(* cr.ac.una.services.PersonaService.updatePersona(..))")
    public void auditoriaDespuesActualizarPersona(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Actualizado");
        a.setTabla("PERSONA");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE ACTUALIZAR");
    }

}

