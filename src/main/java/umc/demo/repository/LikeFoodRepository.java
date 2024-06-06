package umc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.demo.domain.Food;
import umc.demo.domain.User;

public interface LikeFoodRepository extends JpaRepository<Food, Long> {

}
