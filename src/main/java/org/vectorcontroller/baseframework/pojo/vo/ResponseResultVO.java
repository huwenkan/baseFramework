package org.vectorcontroller.baseframework.pojo.vo;

import lombok.Data;

@Data
public class ResponseResultVO {
    private String code;
    private String message;
    private Object data;
    public static ResponseResultVO success(Object data) {
        ResponseResultVO result = new ResponseResultVO();
        result.setCode("200");
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }
    public static ResponseResultVO error(String code, String message) {
        ResponseResultVO result = new ResponseResultVO();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
