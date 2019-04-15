/**
 * 
 */
package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liforever
 * 商户创建返回对象,不返回具体错误信息
 * 2019年3月24日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

	/**
	 * 商户id,创建失败则为-1
	 */
	private Integer id;
}
