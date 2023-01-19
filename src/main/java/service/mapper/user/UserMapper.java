package service.mapper.user;

import dto.user.UserDto;
import model.user.User;
import org.springframework.stereotype.Component;
import service.mapper.Mapper;

@Component
public class UserMapper implements Mapper<UserDto, User> {
    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setCredit(user.getCredit());
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        return null;
    }
}