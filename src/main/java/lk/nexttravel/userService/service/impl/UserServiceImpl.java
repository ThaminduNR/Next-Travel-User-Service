package lk.nexttravel.userService.service.impl;

import lk.nexttravel.userService.dto.UserDto;
import lk.nexttravel.userService.entity.User;
import lk.nexttravel.userService.exception.InvalidException;
import lk.nexttravel.userService.exception.NotFoundException;
import lk.nexttravel.userService.repo.UserRepository;
import lk.nexttravel.userService.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public void saveUser(UserDto dto) {
        if (userRepository.existsById(dto.getUserId())) throw new InvalidException("User Already Exist");
            userRepository.save(mapper.map(dto,User.class));

    }

    @Override
    public void updateUser(UserDto dto) {
        if (userRepository.existsById(dto.getUserId())){
           userRepository.save(mapper.map(dto,User.class));
        }else {
            throw new NotFoundException("User not Found");
        }
    }

    @Override
    public void deleteUser(String id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else {
            throw new NotFoundException("User not Found");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return mapper.map(userRepository.findAll(), new TypeToken<List<UserDto>>() {
        }.getType());
    }

    @Override
    public UserDto searchUser(String id) {
        if (userRepository.existsById(id)){
            User user = userRepository.findById(id).get();
            return mapper.map(user,UserDto.class);
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public UserDto findByUserNamePassword(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);

        if (!(user ==null)){
            return mapper.map(user,UserDto.class);
        }

        throw new NotFoundException("Incorrect of Not found user");

    }


}
