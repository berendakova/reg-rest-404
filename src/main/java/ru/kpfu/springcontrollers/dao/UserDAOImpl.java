package ru.kpfu.springcontrollers.dao;

import ru.kpfu.springcontrollers.model.User;

import java.sql.SQLException;
import java.util.Collection;

public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) throws SQLException {

    }

    @Override
    public void updateUser(Long user_id, User user) throws SQLException {

    }

    @Override
    public User getUserById(Long user_id) throws SQLException {
        return null;
    }

    @Override
    public Collection getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public void deleteUser(User mainUser) throws SQLException {

    }
}
