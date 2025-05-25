package umc.UMC8thSpring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class postReivewDto{
        String title;
        Float score;
        String body;
    }
}
