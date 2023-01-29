package repository.user.add_use_case;

import dto.user.Authorities;
import dto.user.RegistrationDto;
import exception.DataAlreadyExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import service.user.add_use_case.AddUserRepository;

@Repository
@RequiredArgsConstructor
public class AddUserRepositoryImpl implements AddUserRepository {
    @PersistenceContext
    private EntityManager manager;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public User register(RegistrationDto registrationDto) {
        User user = new User();

        if (isExistingUser(user)) {
            throw new DataAlreadyExistsException(
                    String.format("User with username (%s) already exists", registrationDto.getUsername())
            );
        }

        User newUser = new User();

        newUser.setUsername(registrationDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        newUser.setEnabled(true);
        user.setAuthorities(
                registrationDto.getAuthorities().stream().map(Authorities::toString).toList()
        );
        manager.persist(newUser);
        return newUser;
    }

    private static boolean isExistingUser(User user) {
        return user != null;
    }
}
