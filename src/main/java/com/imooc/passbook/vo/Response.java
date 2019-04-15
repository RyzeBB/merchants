/**
 * 
 */
package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liforever
 * 通用的响应对象
 * 2019年3月24日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	/**
	 *  错误码,正确返回 0
	 */
	private Integer errorCode = 0;
	/**
	 * 错误信息,正确返回字符串
	 */
	private String errorMsg = "";
	/**
	 * 返回值对象
	 */
	private Object data;
	/*public Response(Object data) {
		this.data = data;
	}*/
	
	
}
