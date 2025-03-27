package cl.krom.adcomponentbe.controllers;

import cl.krom.adcomponentbe.entities.Image;
import cl.krom.adcomponentbe.repositories.ImageRepository;
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
    public String getAd(@PathVariable("width") Integer width,
                        @PathVariable("height") Integer height) {
        List<Image> imageList = imageRepository.getByWidthAndHeight(width, height);

        if (imageList.isEmpty()) {
            return "No images found";
        }

        String url = imageList.getFirst().getFilename();

        return "Here is your ad of " + width + "x" + height + "px, with URL: " + url;
    }
}
