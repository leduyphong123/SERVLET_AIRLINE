package service;

import entity.Chair;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ChairService {
    Chair getById(int id) throws SQLException, ClassNotFoundException;

    List<Chair> getAll() throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws SQLException, ClassNotFoundException;

    boolean edit(int id, String name) throws SQLException, ClassNotFoundException;

    boolean create(String name) throws SQLException, ClassNotFoundException;

    boolean active(int id,boolean state) throws SQLException, ClassNotFoundException;


    List<Chair> getPageAll(int page) throws SQLException, ClassNotFoundException;

    int getIndexPage() throws SQLException, ClassNotFoundException;

    List<Chair> getStateAll() throws SQLException, ClassNotFoundException;
}
