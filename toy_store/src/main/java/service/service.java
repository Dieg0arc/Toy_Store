package service;

import models.Toy_Store;

import java.sql.ResultSet;
import java.sql.SQLException;

public class service {

    private Toy_Store createProduct(ResultSet resultSet) throws SQLException {
        Toy_Store toy = new Toy_Store();
        toy.setEmpresa(resultSet.getString("empresa"));
        toy.setId_cliente(resultSet.getInt("id_cliente"));
        toy.setFecha_compra(resultSet.getDate("fecha_compra"));
        toy.setToy_id(resultSet.getInt("toy_id"));
        toy.setId_factura(resultSet.getInt("id_factura"));

        return toy;
    }

}
