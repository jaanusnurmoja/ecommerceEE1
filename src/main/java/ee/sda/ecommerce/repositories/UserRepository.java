package ee.sda.ecommerce.repositories;

import ee.sda.ecommerce.entities.UserEE1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEE1, Long> {

    public UserEE1 findByUsername(String username);
}
