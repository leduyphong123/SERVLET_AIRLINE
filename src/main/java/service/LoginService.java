package service;

import entity.Acount;

import java.sql.SQLException;

public interface LoginService {
    Acount login(String email, String password) throws SQLException, ClassNotFoundException;
}
