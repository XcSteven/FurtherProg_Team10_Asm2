package assignment2.repository;
import java.util.List;
import assignment2.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByPublished(boolean published);
    List<Car> findByTitleContaining(String title);
}