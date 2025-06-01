package umc.UMC8thSpring.converter;

import org.springframework.data.domain.Page;
import umc.UMC8thSpring.domain.Mission;
import umc.UMC8thSpring.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.missionPreviewDto toMissionPreviewDTO(Mission mission) {
        return MissionResponseDTO.missionPreviewDto.builder()
                .score(mission.getReward())
                .body(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.missionPreviewListDto toMissionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.missionPreviewDto> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.missionPreviewListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .missionPreviewDtoList(missionPreviewDTOList)
                .build();
    }
}
