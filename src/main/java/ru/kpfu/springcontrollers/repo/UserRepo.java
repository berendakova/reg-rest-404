package ru.kpfu.springcontrollers.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.springcontrollers.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}