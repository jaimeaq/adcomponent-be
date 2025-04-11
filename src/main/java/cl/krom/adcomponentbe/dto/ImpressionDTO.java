package cl.krom.adcomponentbe.dto;

import lombok.Data;

@Data
public class ImpressionDTO {
    private String eventType;
    private String timestamp;
    private AdDataDTO adData;
    private PageInfoDTO pageInfo;

    @Data
    public static class AdDataDTO {
        private String url;
        private Integer width;
        private Integer height;
        private String location;
    }

    @Data
    public static class PageInfoDTO {
        private String url;
        private String referrer;
    }
}
