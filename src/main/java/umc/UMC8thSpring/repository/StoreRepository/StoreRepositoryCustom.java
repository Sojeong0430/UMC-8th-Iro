package umc.UMC8thSpring.repository.StoreRepository;

import umc.UMC8thSpring.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
