package co.com.usbcali.seguridad.jwt.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.usbcali.seguridad.jwt.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
