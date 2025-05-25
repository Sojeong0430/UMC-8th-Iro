package umc.UMC8thSpring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8thSpring.apiPayload.code.status.ErrorStatus;
import umc.UMC8thSpring.apiPayload.exception.handler.TempHandler;
import umc.UMC8thSpring.domain.Region;
import umc.UMC8thSpring.domain.Store;
import umc.UMC8thSpring.repository.RegionRepository;
import umc.UMC8thSpring.repository.StoreRepository.StoreRepository;
import umc.UMC8thSpring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    public void createStore(StoreRequestDTO.storeAddDTO request,Long regionId){
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new TempHandler(ErrorStatus._BAD_REQUEST));

        Store result = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();

        storeRepository.save(result);
    }

}
