package umc.UMC8thSpring.web.dto;

import lombok.Getter;
import umc.UMC8thSpring.domain.Region;

public class StoreRequestDTO {

    @Getter
    public static class storeAddDTO {
        String name;
        String address;
        Float score;
        Region region;
    }
}
