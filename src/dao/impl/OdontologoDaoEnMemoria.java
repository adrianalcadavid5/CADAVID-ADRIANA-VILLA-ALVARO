package dao.impl;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    public static final Logger logger = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(odontologos.size()+1);
        odontologos.add(odontologo);
        logger.info("odontologo guardado " + odontologo);

        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info(odontologos);
        return odontologos;
    }
}
