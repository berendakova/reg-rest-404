package ru.kpfu.springcontrollers.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.springcontrollers.model.User;
import ru.kpfu.springcontrollers.repo.UserRepo;

import java.io.IOException;

@RestController
@RequestMapping("/api/users-management")
public class UsersRestController {

    private UserRepo userRepo;
    private ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/users")
    public void addUser(@RequestBody String json) throws IOException {
        userRepo.save(mapper.readValue(json, User.class));
    }

    @GetMapping("/users/{user-id}")
    public String getUser(@PathVariable("user-id")int userId) throws JsonProcessingException {
        return mapper.writeValueAsString(userRepo.findById(userId));
    }

    @GetMapping("/users")
    public String getUsers() throws JsonProcessingException {
        return mapper.writeValueAsString(userRepo.findAll());
    }

    @PutMapping("/users/{user-id}")
    public void updateUser(@PathVariable("user-id")int userId, @RequestBody String json) throws IOException {
        userRepo.save(mapper.readValue(json, User.class));
    }

    @DeleteMapping("/users/{user-id}")
    public void deleteUser(@PathVariable("user-id")int userId){
        userRepo.deleteById(userId);
    }

}
