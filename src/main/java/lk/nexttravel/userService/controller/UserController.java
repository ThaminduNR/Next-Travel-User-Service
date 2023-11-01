package lk.nexttravel.userService.controller;

import lk.nexttravel.userService.dto.UserDto;
import lk.nexttravel.userService.service.UserService;
import lk.nexttravel.userService.util.IdGenerator;
import lk.nexttravel.userService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nexttravel/user/service")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@RequestPart String userName,@RequestPart String name, @RequestPart String nicNo,
                                 @RequestPart byte[] nicImg, @RequestPart String userAge, @RequestPart String gender,
                                 @RequestPart String email, @RequestPart String contactNo, @RequestPart String address,
                                 @RequestPart String password){
        System.out.println(userAge);

        int age = Integer.parseInt(userAge);
        IdGenerator idGenerator = new IdGenerator();
        String userId = idGenerator.generateID();

        UserDto userDto = new UserDto(userId,userName,name, nicNo, nicImg, age, gender,
                email, contactNo, address,password);

        userService.saveUser(userDto);

        return new ResponseUtil(200,"Saved Success",null);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestPart String userId,@RequestPart String userName,@RequestPart String name, @RequestPart String nicNo,
                                   @RequestPart byte[] nicImg, @RequestPart String userAge, @RequestPart String gender,
                                   @RequestPart String email, @RequestPart String contactNo, @RequestPart String address,
                                   @RequestPart String password){

        int age = Integer.parseInt(userAge);
        UserDto userDto = new UserDto(userId,userName,name, nicNo, nicImg, age, gender,
                email, contactNo, address,password);
        userService.updateUser(userDto);

        return new ResponseUtil(200,"Update Success",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseUtil(200,"Get All",allUsers);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String id){
        userService.deleteUser(id);
        return new ResponseUtil(200,"Delete Success",null);
    }


    @GetMapping(path = "/{id}")
    public ResponseUtil searchUser(@PathVariable String id){
        UserDto userDto = userService.searchUser(id);
        return new ResponseUtil(200,"Search Success",userDto);
    }

    @GetMapping(params = {"userName","password"})
    public ResponseUtil findByUsernamePassword(String userName, String password){
        System.out.println("user id "+ userName);
        System.out.println("user name "+password);
        UserDto userdto = userService.findByUserNamePassword(userName, password);
        return new ResponseUtil(200,"Ok",userdto);
    }
}
