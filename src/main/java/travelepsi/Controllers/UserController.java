package travelepsi.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import travelepsi.Entities.UserEntity;
import travelepsi.Services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    public UserService userService = new UserService();

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userService.getAll();
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        UserEntity user = userService.get(id);

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody UserEntity user) {
        try {
            user = userService.save(user);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
        UserEntity u = userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword());

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserEntity>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        UserEntity base = userService.get(id);

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        try {
            user = userService.update(base.merge(user));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        UserEntity user = userService.get(id);

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        try {
            userService.delete(user);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }

}