package repository.impl;

import application.Data_Base_Conection;
import models.Toy_Store;

import application.Data_Base_Conection;
import models.Toy_Store;
import repository.repository;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
public class T_S_Impl {
    implements repository<Toy_Store>{

        private Connection getConnection() throws SQLException {
            return Data_Base_Conection.getInstance();
        }
        private Toy_Store createToy_Store(ResultSet resultSet) throws SQLException {
            Toy_Store Toy = new Toy_Store();
            Toy.setEmpresa(resultSet.getString("empresa"));
            Toy.setId_factura(resultSet.getInt("id_factura"));
            Toy.setFecha_compra(resultSet.getDate("fecha_compra"));
            Toy.setId_cliente(resultSet.getInt("id_cliente"));
            Toy.setId_empleado(resultSet.getInt("id_empleado"));
            Toy.setToy_id(resultSet.getInt("toy_id"));

            return Toy;
        }

        @Override
        public List<Toy_Store> list() {
            List<Toy_Store> Toy_StoreList = new ArrayList<>();
            try (Statement statement = getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM practicas")) {
                while (resultSet.next()) {
                    Toy_Store Toy = createToy_Store(resultSet);
                    Toy_StoreList.add(Toy_Store);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Toy_StoreList;
        }

        @Override
        public Toy_Store byId(Integer id_factura) {
            Toy_Store Toy_Store = null;
            try (PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("SELECT * FROM practicas WHERE id_practicas = ?")) {
                preparedStatement.setLong(1, id_factura);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Toy_Store = createToy_Store(resultSet);
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Toy_Store;
        }

        @Override
        public void save(Toy_Store Toy_Store) {

        }

        @Override
        public void delete(Long id) {

        }

}
