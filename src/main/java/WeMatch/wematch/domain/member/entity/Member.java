package WeMatch.wematch.domain.member.entity;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;

    public void passwordEncoder(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

}
