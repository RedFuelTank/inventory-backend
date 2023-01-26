package dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String username;
    private Double credit;
    private List<Authorities> authorities;
}
