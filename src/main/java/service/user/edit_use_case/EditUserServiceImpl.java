package service.user.edit_use_case;

import controller.user.edit_use_case.EditUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditUserServiceImpl implements EditUserService {
    private final EditUserRepository repository;
    @Override
    public void setAvailableItemNumber(String username, int amount) {
        repository.setAvailableItemNumber(username, amount);
    }


}
