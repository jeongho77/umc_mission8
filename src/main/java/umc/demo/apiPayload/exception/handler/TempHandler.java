package umc.demo.apiPayload.exception.handler;

import umc.demo.apiPayload.code.BaseErrorCode;
import umc.demo.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}