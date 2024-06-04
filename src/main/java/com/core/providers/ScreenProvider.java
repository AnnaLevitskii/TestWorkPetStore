package com.core.providers;

import com.core.exceptions.WrongScreenSizeException;
import com.core.models.enums.ScreenSize;

public class ScreenProvider {
    public static ScreenSize getScreenSize(String str) throws WrongScreenSizeException {
        switch (str) {
            case "DESKTOP_L":
            case "des_l" :
            case "d_l":
            case "D_L":
            case "":
                return ScreenSize.DESKTOP_L;
            case "DESKTOP_M":
            case "des_m" :
            case "d_m":
            case "D_M":
                return ScreenSize.DESKTOP_M;
            case "DESKTOP_S":
            case "des_s" :
            case "d_s":
            case "D_S":
                return ScreenSize.DESKTOP_S;
            default:
                throw new WrongScreenSizeException();
        }
    }
}
