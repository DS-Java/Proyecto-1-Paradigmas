package cr.ac.una.aop;

import cr.ac.una.entities.Auditoria;
import cr.ac.una.services.AuditoriaService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class PersonaMocionAOP {
@Autowired
AuditoriaService auditoriaService;

    //ASPECTO DESPUES DE CREAR
    @After("execution(* cr.ac.una.services.PersonaMocionService.createPersonaMocion(..))")
    public void auditoriaDespuesAgregarPersonasMocion(JoinPoint joinPoint){//Funcion para loguear antes de algo
        //Aca creo el objeto Auditoria y lo lleno
        Auditoria a = new Auditoria();
        a.setTransaccion("Agregado");
        a.setTabla("PERSONA MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE AGREGAR");
    }

    //ASPECTO DESPUES DE LISTAR
    @After("execution(* cr.ac.una.services.PersonaMocionService.getAllPersonaMocions(..))")
    public void auditoriaDespuesListarPersonaMocion(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Listado");
        a.setTabla("PERSONA MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE LISTAR");
    }

    //ASPECTO DESPUES DE ELIMINAR
    @After("execution(* cr.ac.una.services.PersonaMocionService.deletePersonaMocion(..))")
    public void auditoriaDespuesEliminarPersonaMocion(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Eliminado");
        a.setTabla("PERSONA MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE ELIMINAR");
    }

    //ASPECTO DESPUES DE ACTUALIZAR
    @After("execution(* cr.ac.una.services.PersonaMocionService.updatePersonaMocion(..))")
    public void auditoriaDespuesActualizarPersonaMocion(JoinPoint joinPoint){
        Auditoria a = new Auditoria();
        a.setTransaccion("Actualizado");
        a.setTabla("MOCION");

        auditoriaService.createAuditoria(a);
        System.out.println("SE HA REGISTRADO LA TRANSACCION DE ACTUALIZAR");
    }




















}
