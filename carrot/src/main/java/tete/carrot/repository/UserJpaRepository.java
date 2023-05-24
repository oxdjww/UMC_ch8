package tete.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tete.carrot.entity.User;

public interface UserJpaRepository extends JpaRepository<User,Long> {
}
