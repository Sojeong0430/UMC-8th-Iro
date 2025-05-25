package umc.UMC8thSpring.apiPayload.exception.handler;

import umc.UMC8thSpring.apiPayload.code.BaseErrorCode;
import umc.UMC8thSpring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler (BaseErrorCode errorCode) {
        super(errorCode);
    }

}
