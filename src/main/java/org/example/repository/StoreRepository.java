package org.example.repository;

import org.example.database.ConfigurationDB;
import org.example.model.Element;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreRepository implements  Repository <Element>{
    private Connection getConnection() throws Exception {
        return ConfigurationDB.getInstance();
    }
    @Override
    public List<Element> findAllModel(int i) throws Exception {
        List<Element> list = new ArrayList<>();
        try (PreparedStatement myStat= getConnection().prepareStatement("SELECT * FROM store WHERE category_id = ?")) {
            myStat.setInt(1, i);
            try (ResultSet resultSet = myStat.executeQuery()) {
                while (resultSet.next()) {
                    Element object = instanceElement(resultSet);
                    list.add(object);
                }
            }
        }
        return list;
    }
    @Override
    public Element getModel(Integer id) throws Exception {
        return null;
    }
    @Override
    public <T> boolean saveModel(T[] id) throws Exception{return false;}
    @Override
    public void deleteModel(Integer id) throws Exception {}

    @Override
    public Element instanceElement(ResultSet resultSet) throws SQLException {
        Element object = new Element();
        object.setId(resultSet.getInt("id"));
        object.setName(resultSet.getString("name_item"));
        object.setType(resultSet.getString("category"));
        object.setDescription(resultSet.getString("description_item"));
        object.setScore(resultSet.getInt("score"));
        object.setGold(resultSet.getInt("gold"));
        object.setGraphicsElement(resultSet.getString("graphics"));
        object.setCategory(resultSet.getInt("category_id"));
        return object;
    }

    @Override
    public boolean doesItemExist(char Type) throws Exception {
        return false;
    }
}
