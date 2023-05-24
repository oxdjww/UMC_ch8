package tete.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tete.carrot.entity.User;
import tete.carrot.repository.UserJpaRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    private final UserJpaRepository userJpaRepository;

    public User findById(Long id) {
        return userJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }

    @Transactional
    public Long save(User user) {
        return userJpaRepository.save(user).getId();
    }

    @Transactional
    public Long update(Long id, User user) {
        User currentUser = findById(id);
        currentUser.update(user.getName(), user.getNickname(), user.getPhone(), user.getEmail(),user.getPassword());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        User user = findById(id);
        userJpaRepository.delete(user);
    }

}
