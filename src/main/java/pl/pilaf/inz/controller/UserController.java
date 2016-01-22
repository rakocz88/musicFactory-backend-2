package pl.pilaf.inz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.pilaf.enums.UserType;
import pl.pilaf.inz.model.Band;
import pl.pilaf.inz.model.User;
import pl.pilaf.inz.repository.BandRepository;
import pl.pilaf.inz.repository.UserRepository;
import pl.pilaf.inz.wrapper.UserWrapper;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BandRepository bandRepository;
    
    public boolean loginExists(@RequestParam String login){
	List<User> userList = userRepository.findByLogin(login);
	return !userList.isEmpty();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody UserWrapper user) {
	if (loginExists(user.getLogin())){
	    new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	};
	List<Band> userBands = new ArrayList<>();
	Consumer<Long> bandLambda = (Long bandId) -> userBands.add(bandRepository.findOne(bandId));
	user.getBands().stream().parallel().forEach(bandLambda);
	User userEntity = new User(user);
	userEntity.setBands(userBands);
	userEntity.setUserType(UserType.USER);
        userRepository.save(userEntity);
        for (Band band:userEntity.getBands()){
            band.getMembers().add(userEntity);
            bandRepository.save(band);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAll() {
        final List<User> resultList = new ArrayList<>();
        final Iterable<User> all = userRepository.findAll();
        Consumer<User> consLambda = (User user) -> resultList.add(user);
        all.forEach(consLambda);
        return resultList;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllByName(@RequestParam String name){
	return userRepository.findByFirstName(name);
    }

}
