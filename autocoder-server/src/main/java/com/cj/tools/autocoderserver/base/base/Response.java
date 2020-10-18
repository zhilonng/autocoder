package com.cj.tools.autocoderserver.base.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * 全局统一的controller响应数据结构
 * @param <T>
 */
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T extends Object> implements Serializable {

	private Integer code;

	private Object msg;

	private T data;

	private Map<String, String> other;

	/**
	 * 默认业务失败
	 */
	public Response() {
		this.code = ResponseCode.DEFAULT.getCode();
		this.msg = ResponseCode.getMsg(code);
	}

	public Response(Integer code, String message){
		this.code = code;
		this.msg = message;
	}

	public Response(Integer code) {
		this.code = code;
		this.msg = ResponseCode.getMsg(code);
	}

	public Response(Integer code, T data) {
		this.code = code;
		this.msg = ResponseCode.getMsg(code);
		this.data = data;
	}

	public Response(T data) {
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.SUCCESS.getMsg();
		this.data = data;
	}

	// region 成功
	public static Response success() {
		Response resultData = new Response();
		resultData.setCodeSuccess();
		return resultData;
	}
	public static Response success(String msg) {
		Response resultData = new Response();
		resultData.setCodeSuccess();
		resultData.setMsg(msg);
		return resultData;
	}
	public static Response success(Integer code, String msg) {
		Response resultData = new Response();
		resultData.setCode(code);
		resultData.setMsg(msg);
		return resultData;
	}
	public static Response success(Integer code, String msg, Object data) {
		Response resultData = new Response();
		resultData.setCode(code);
		resultData.setMsg(msg);
		resultData.setData(data);
		return resultData;
	}
	public static Response success(Object data) {
		Response resultData = new Response();
		resultData.setCodeSuccess();
		resultData.setData(data);
		return resultData;
	}
	// endregion

	// region 错误
	public static Response error() {
		Response resultData = new Response();
		resultData.setCodeError();
		return resultData;
	}
	public static Response error(Object msg) {
		Response resultData = new Response();
		resultData.setCodeError();
		resultData.setMsg(msg);
		return resultData;
	}
	public static Response error(Integer code, String msg) {
		Response resultData = new Response();
		resultData.setCode(code);
		resultData.setMsg(msg);
		return resultData;
	}
	// endregion

	public void setCodeSuccess() {
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.getMsg(code);
	}

	public void setCodeFail() {
		this.code = ResponseCode.FAIL.getCode();
		this.msg = ResponseCode.getMsg(code);
	}
	public void setCodeFail(Object msg) {
		this.code = ResponseCode.FAIL.getCode();
		this.msg = msg;
	}

	public void setCodeError() {
		this.code = ResponseCode.ERROR.getCode();
		this.msg = ResponseCode.getMsg(code);
	}
	public void setCodeError(Object msg) {
		this.code = ResponseCode.ERROR.getCode();
		this.msg = msg;
	}

	public void setCodeWait() {
		this.code = ResponseCode.WAIT.getCode();
		this.msg = ResponseCode.getMsg(code);
	}

	public void setCodeWait(Object msg) {
		this.code = ResponseCode.WAIT.getCode();
		this.msg = msg;
	}

	public void setCode(Integer code) {
		this.code = code;
		this.msg = ResponseCode.getMsg(code);
	}

	public void setData(T data) {
		this.data = data;
	}


}
