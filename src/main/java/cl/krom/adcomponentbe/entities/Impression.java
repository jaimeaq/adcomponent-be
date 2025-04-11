package cl.krom.adcomponentbe.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "impressions", schema = "ads")
public class Impression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "page_url")
    private String pageUrl;

    @Column(name = "referrer")
    private String referrer;

    @Column(name = "server_timestamp", nullable = false)
    private Instant serverTimestamp;

}
