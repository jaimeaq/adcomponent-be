package cl.krom.adcomponentbe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdController {

    @GetMapping("ads")
    public String getAd() {
        return "Here is your ad";
    }
}
