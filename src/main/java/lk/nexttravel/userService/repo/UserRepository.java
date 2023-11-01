package lk.nexttravel.userService.repo;

import lk.nexttravel.userService.dto.UserDto;
import lk.nexttravel.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByUserNameAndPassword(String userName,String password);
}
