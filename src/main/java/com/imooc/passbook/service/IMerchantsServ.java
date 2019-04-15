/**
 * 
 */
package com.imooc.passbook.service;

import org.springframework.stereotype.Service;

import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;

/**
 * @author liforever
 *
 * 2019年3月25日
 */

public interface IMerchantsServ {

	/**
	 * 创建商户服务
	 * @param request {@link CreateMerchantsRequest} 创建商户请求对象
	 * @return {@link Response} 
	 */
	Response createMerchants(CreateMerchantsRequest request);
	/**
	 * 根据id构造商户信息
	 * @param id 商户id
	 * @return {@link Response}
	 */
	Response buildMerchantsInfoById(Integer id);
	/**
	 * 投放优惠券
	 * @param passTemplate {@link PassTemplate} 优惠券对象
	 * @return {@link Response}
	 */
	Response dropPassTemplate(PassTemplate passTemplate);
}
