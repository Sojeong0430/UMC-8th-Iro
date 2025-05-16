package umc.UMC8thSpring.apiPayload.exception.handler;

import umc.UMC8thSpring.apiPayload.code.BaseErrorCode;
import umc.UMC8thSpring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode); // GeneralException을 만든다
    }
}
