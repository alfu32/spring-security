package a.b.c.tut.security.umata.security.user;

import a.b.c.tut.security.umata.entity.User;
import a.b.c.tut.security.umata.repository.UserRepository;
import a.b.c.tut.security.umata.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository
                .findByUsername(username == null ? "guest" : username);

        if(user == null) {
            throw new RuntimeException(String.format("The user {{%s}} does not exist", username));
        }
        // throw new RuntimeException(authUser.toString());
        return user;
    }
}
