package org.xsalefter.springhibernate.utils;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
public class ApplicationLogDTO {
    
    private Long id;
    private String code;
    private String message;

    public ApplicationLogDTO() {
    }

    public ApplicationLogDTO(Long id, String code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
