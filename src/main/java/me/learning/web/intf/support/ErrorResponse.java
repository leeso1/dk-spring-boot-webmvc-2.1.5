package me.learning.web.intf.support;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class ErrorResponse {

    /**
     * HttpStatus
     */
    private final int status;

    /**
     * Application predefined Error Code
     */
    private final String code;

    /**
     * Application Error Messages correspond to error code
     */
    private final String message;

}
