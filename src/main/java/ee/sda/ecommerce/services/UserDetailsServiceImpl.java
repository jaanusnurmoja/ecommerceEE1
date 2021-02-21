package ee.sda.ecommerce.services;

import ee.sda.ecommerce.entities.UserEE1;
import ee.sda.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEE1 user = repository.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public void createUser(UserEE1 user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
