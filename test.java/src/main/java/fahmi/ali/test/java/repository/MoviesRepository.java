package fahmi.ali.test.java.repository;

import fahmi.ali.test.java.model.MoviesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<MoviesModel, Long> {
}
