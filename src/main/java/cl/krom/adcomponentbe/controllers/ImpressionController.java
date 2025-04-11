package cl.krom.adcomponentbe.controllers;

import cl.krom.adcomponentbe.dto.ImpressionDTO;
import cl.krom.adcomponentbe.entities.Impression;
import cl.krom.adcomponentbe.repositories.ImpressionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@CrossOrigin("http://localhost:63342")
@AllArgsConstructor
public class ImpressionController {

    private final ImpressionRepository impressionRepository;

    @PostMapping("/api/analytics/impression")
    public ResponseEntity<?> trackImpression(@RequestBody ImpressionDTO impressionDTO) {
        try {
            Impression impression = new Impression();

            impression.setTimestamp(Instant.parse(impressionDTO.getTimestamp()));
            impression.setServerTimestamp(Instant.now());
            impression.setImageUrl(impressionDTO.getAdData().getUrl());
            impression.setWidth(impressionDTO.getAdData().getWidth());
            impression.setHeight(impressionDTO.getAdData().getHeight());
            impression.setLocation(impressionDTO.getAdData().getLocation());
            impression.setPageUrl(impressionDTO.getPageInfo().getUrl());
            impression.setReferrer(impressionDTO.getPageInfo().getReferrer());

            impressionRepository.save(impression);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error tracking impression: " + e.getMessage());
        }
    }
}
