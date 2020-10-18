package com.cj.tools.autocoderserver.base.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有返回值状态枚举
 */
public enum ResponseCode {

	/**
	 * 基础状态码
	 */
	ERROR(-2,"系统异常"),
	FAIL(-1,"业务失败"),
	DEFAULT(1,"未执行"),
	SUCCESS(0,"成功"),
	WAIT(2,"等待"),

	PARAM_NULL(-10,"参数为空"),
	PARAM_ERROR(-11,"参数异常"),
	RESULT_NUL(-20,"返回值为空"),
	RESULT_ERROR(-21,"返回值异常"),
	TIMEOUT(-100,"请求超时");

	private Integer code;
	private String msg;

	ResponseCode(Integer code, String msg){
		this.code=code;
		this.msg=msg;
	}

	private static Map<Integer, String> codeMap = new HashMap<Integer, String>();
	static{
		for(ResponseCode one: ResponseCode.values()){
			codeMap.put(one.code,one.msg);
		}
	}

	/**根据code返回状态描述 */
	public static String getMsg(Integer code){
		if(codeMap.containsKey(code)){
			return codeMap.get(code);
		}
		return "未知异常";
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
