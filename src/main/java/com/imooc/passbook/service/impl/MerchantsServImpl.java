/**
 * 
 */
package com.imooc.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import com.imooc.passbook.service.IMerchantsServ;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.CreateMerchantsResponse;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liforever
 *
 * 2019年3月25日
 */

@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ{

	/**
	 * Merchants 数据库接口
	 */
	private final MerchantsDao merchantsDao;
	/**
	 * kafka 客户端
	 */
	private final KafkaTemplate<String,String> kafkaTemplate;
	@Autowired
	public MerchantsServImpl(MerchantsDao merchantsDao, KafkaTemplate <String, String> kafkaTemplate) {
		this.merchantsDao = merchantsDao;
		this.kafkaTemplate = kafkaTemplate;
	}
	/* (non-Javadoc)
	 * @see com.imooc.passbook.service.IMerchantsServ#createMerchants(com.imooc.passbook.vo.CreateMerchantsRequest)
	 */
	@Override
	@Transactional
	public Response createMerchants(CreateMerchantsRequest request) {
		Response response = new Response();
		CreateMerchantsResponse createMerchantsResponse = new CreateMerchantsResponse();
		ErrorCode errorCode = request.validate(merchantsDao);
		if(errorCode != ErrorCode.SUCCESS) {
			createMerchantsResponse.setId(-1);
			response.setErrorCode(errorCode.getCode());
			response.setErrorMsg(errorCode.getDesc());
		}else {
			createMerchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
		}
		response.setData(createMerchantsResponse);
		return response;
	}

	/* (non-Javadoc)
	 * @see com.imooc.passbook.service.IMerchantsServ#buildMerchantsInfoById(java.lang.Integer)
	 */
	@Override
	public Response buildMerchantsInfoById(Integer id) {
		// TODO Auto-generated method stub
		Response response = new Response();
		Merchants merchants = merchantsDao.findById(id);
		if(null == merchants){
			response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXISTS.getCode());
			response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXISTS.getDesc());
		}
		response.setData(merchants);
		return response;
	}

	/* (non-Javadoc)
	 * @see com.imooc.passbook.service.IMerchantsServ#dropPassTemplate(com.imooc.passbook.vo.PassTemplate)
	 */
	@Override
	public Response dropPassTemplate(PassTemplate template) {
		// TODO Auto-generated method stub
		Response response = new Response();
		ErrorCode errorCode = template.validate(merchantsDao);
		if(errorCode != ErrorCode.SUCCESS){
			response.setErrorCode(errorCode.getCode());
			response.setErrorMsg(errorCode.getDesc());
		}else {
			String passTemplate = JSON.toJSONString(template);
			kafkaTemplate.send(
					Constants.TEMPLATE_TOPIC,
					Constants.TEMPLATE_TOPIC,
					passTemplate
			);
			log.info("DropPassTemplate:{}",passTemplate);
		}
		return response;
	}

}
