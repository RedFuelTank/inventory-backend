package repository.user.add_use_case;

import dto.user.Authorities;
import dto.user.RegistrationDto;
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

        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEnabled(true);
        user.setAuthorities(
                registrationDto.getAuthorities().stream().map(Authorities::toString).toList()
        );
        manager.persist(user);
        return user;
    }
}
