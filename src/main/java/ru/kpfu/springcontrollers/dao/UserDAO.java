package ru.kpfu.springcontrollers.dao;

import ru.kpfu.springcontrollers.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserDAO {

    public void addUser(User user) throws SQLException;

    public void updateUser(Long user_id, User user) throws SQLException;

    public User getUserById(Long user_id) throws SQLException;

    public Collection getAllUsers() throws SQLException;

    public void deleteUser(User mainUser) throws SQLException;
}