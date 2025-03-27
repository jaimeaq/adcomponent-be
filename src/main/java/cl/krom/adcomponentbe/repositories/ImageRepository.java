package cl.krom.adcomponentbe.repositories;

import cl.krom.adcomponentbe.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> getByWidthAndHeight(Integer width, Integer height);
}
