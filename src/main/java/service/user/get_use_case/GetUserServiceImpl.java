package service.user.get_use_case;

import controller.user.get_use_case.GetUserService;
import dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import model.user.User;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class GetUserServiceImpl implements GetUserService {
    private final GetUserRepository repository;
    private final Mapper<UserDto, User> mapper;

    @Override
    public UserDto getUserByUsername(String username) {
        return mapper.toDto(
                repository.getUserByUsername(username)
        );
    }
}
