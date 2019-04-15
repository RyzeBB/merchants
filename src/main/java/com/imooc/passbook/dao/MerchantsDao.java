/**
 * 
 */
package com.imooc.passbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.passbook.entity.Merchants;

/**
 * @author liforever
 *
 * 2019年3月24日
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer>{

	/**
	 * 根据id获取商户对象
	 * @param id 商户id
	 * @return {@link Merchants}
	 */
	Merchants findById(Integer id);
	/**
	 * 根据商户名称获取商户对象
	 * @param name 商户名称
	 * @return {@link Merchants}}
	 */
	Merchants findByName(String name);
}
