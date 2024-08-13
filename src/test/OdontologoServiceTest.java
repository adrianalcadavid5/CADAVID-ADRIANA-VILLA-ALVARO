package test;

import dao.impl.OdontologoH2Dao;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    static Logger logger = Logger.getLogger(OdontologoServiceTest.class);
    OdontologoService odontologoService = new OdontologoService(new OdontologoH2Dao());

    @BeforeAll
    static void cargarTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./clinica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que un odondologo se guarde en la base de datos")
    void caso1(){
        // dado
        Odontologo odontologo = new Odontologo("1234", "Valeria", "Serna");
        //cuando
        Odontologo odontologoDesdeDB = odontologoService.guardarOdontologo(odontologo);
        //enconces
        assertNotNull(odontologoDesdeDB.getId());
    }
    @Test
    @DisplayName("Testear que busque todos los odontologos")
    void  caso3(){
        Odontologo odontologo1 = new Odontologo("122","pepe","perez");
        Odontologo odontologo2 = new Odontologo("552","ana","fernandez");
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.buscarTodos();
    }


}