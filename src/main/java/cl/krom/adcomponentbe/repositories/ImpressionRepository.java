package cl.krom.adcomponentbe.repositories;

import cl.krom.adcomponentbe.entities.Impression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpressionRepository extends JpaRepository<Impression, Long> {
}
