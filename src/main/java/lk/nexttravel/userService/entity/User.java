package lk.nexttravel.userService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String name;
    private String nicNo;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    private byte[] nicImg;
    private int age;
    private String gender;
    private String email;
    private String contactNo;
    private String address;
    private String password;
}
