package cl.krom.adcomponentbe.controllers;

import cl.krom.adcomponentbe.dto.ImageDTO;
import cl.krom.adcomponentbe.entities.Image;
import cl.krom.adcomponentbe.repositories.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    private final ImageRepository imageRepository;

    public AdController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @GetMapping("ads/{width}/{height}")
    public ResponseEntity<?> getAd(@PathVariable("width") Integer width,
                                       @PathVariable("height") Integer height) {
        List<Image> imageList = imageRepository.getByWidthAndHeight(width, height);

        if (imageList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        String url = "http://localhost:8080/images/" + imageList.getFirst().getFilename();

        return ResponseEntity.ok(new ResponseEntity<>(new ImageDTO(url), HttpStatus.OK));
    }
}
