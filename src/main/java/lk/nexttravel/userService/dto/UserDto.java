package lk.nexttravel.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String userId;
    private String userName;
    private String name;
    private String nicNo;
    private byte[] nicImg;
    private int age;
    private String gender;
    private String email;
    private String contactNo;
    private String address;
    private String password;



}
