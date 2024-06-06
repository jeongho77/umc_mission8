package umc.demo.apiPayload.exception.handler;

import umc.demo.apiPayload.code.BaseErrorCode;
import umc.demo.apiPayload.exception.GeneralException;

public class LikeFoodHandler extends GeneralException{

    public LikeFoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
