package umc.UMC8thSpring.apiPayload.code;
// 구체화 하는 Status에서 두 개의 메소드를 반드시 Overrride할 것을 강제하는 역할

public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}
