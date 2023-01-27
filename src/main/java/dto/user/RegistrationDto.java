package dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegistrationDto {
    private String username;
    private String password;
    private List<Authorities> authorities;
}
