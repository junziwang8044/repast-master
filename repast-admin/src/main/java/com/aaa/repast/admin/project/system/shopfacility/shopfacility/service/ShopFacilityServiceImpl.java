package com.aaa.repast.admin.project.system.shopfacility.shopfacility.service;

import com.aaa.repast.admin.project.system.shopfacility.domain.ShopFacility;
import com.aaa.repast.admin.project.system.shopfacility.mapper.ShopFacilityMapper;
import com.aaa.repast.admin.project.system.shopfacility.service.IShopFacilityService;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopFacilityServiceImpl implements IShopFacilityService

{
	@Autowired
	private ShopFacilityMapper shopFacilityMapper;

	/**
     * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * 
     * @param id 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等ID
     * @return 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     */
    @Override
	public ShopFacility selectShopFacilityById(Long id)
	{
	    return shopFacilityMapper.selectShopFacilityById(id);
	}
	
	/**
     * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等列表
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等集合
     */
	@Override
	public List<ShopFacility> selectShopFacilityList(ShopFacility shopFacility)
	{
	    return shopFacilityMapper.selectShopFacilityList(shopFacility);
	}
	
    /**
     * 新增店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 结果
     */
	@Override
	public int insertShopFacility(ShopFacility shopFacility)
	{
	    return shopFacilityMapper.insertShopFacility(shopFacility);
	}
	
	/**
     * 修改店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 结果
     */
	@Override
	public int updateShopFacility(ShopFacility shopFacility)
	{
	    return shopFacilityMapper.updateShopFacility(shopFacility);
	}

	/**
     * 删除店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopFacilityByIds(String ids)
	{
		return shopFacilityMapper.deleteShopFacilityByIds(Convert.toStrArray(ids));
	}
}
