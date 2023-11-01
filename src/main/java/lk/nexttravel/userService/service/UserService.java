package lk.nexttravel.userService.service;

import lk.nexttravel.userService.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto dto);
    void updateUser(UserDto dto);
    void deleteUser(String id);
    List<UserDto> getAllUsers();
    UserDto searchUser(String id);

    UserDto findByUserNamePassword(String userName,String password);
}
