package test;

import dao.impl.OdontologoDaoEnMemoria;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OdontologoServiceMemoriaTest {
    static Logger logger = Logger.getLogger(OdontologoServiceTest.class);

    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoEnMemoria());

    @Test
    @DisplayName("Testear que un odondologo se guarde en memoria")
    void caso1(){
        // dado
        Odontologo odontologo = new Odontologo("1234", "Valeria", "Serna");
        //cuando
        Odontologo odontologoDesdeDB = odontologoService.guardarOdontologo(odontologo);
        //enconces
        assertNotNull(odontologoDesdeDB.getId());
    }

    @Test
    @DisplayName("Testear que busque todos los odontologos en memoria")
    void  caso3(){
        Odontologo odontologo1 = new Odontologo(1,"123","juan", "quiroz");
        Odontologo odontologo2 = new Odontologo(1,"125","olga", "alvarez");
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.buscarTodos();
    }
}
