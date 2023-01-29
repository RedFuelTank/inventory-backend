package controller.user.edit_use_case;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EditUserController {
    private final EditUserService service;

    @PutMapping("{username}/set-available-item-number/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void setAvailableItemNumber(@PathVariable String username,
                                       @PathVariable int amount) {
        service.setAvailableItemNumber(username, amount);
    }
}
