package tete.carrot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.naming.StringRefAddr;

@Entity(name="User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private String phone;
    private String password;
    public void update(String name, String nickname, String email, String phone, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

}
