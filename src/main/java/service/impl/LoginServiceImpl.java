package service.impl;

import entity.Acount;
import repository.LoginRepository;
import service.LoginService;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    private LoginRepository repository = new LoginRepository();
    @Override
    public Acount login(String email, String password) throws SQLException, ClassNotFoundException {
        return repository.login(email,password);
    }
}
