package service.user.add_use_case;

import controller.user.add_use_case.AddUserService;
import dto.user.RegistrationDto;
import dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import model.user.User;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class AddUserServiceImpl implements AddUserService {
    private final AddUserRepository repository;
    private final Mapper<UserDto, User> userMapper;
    @Override
    public UserDto register(RegistrationDto registrationDto) {
        return userMapper.toDto(repository.register(registrationDto));
    }
}
