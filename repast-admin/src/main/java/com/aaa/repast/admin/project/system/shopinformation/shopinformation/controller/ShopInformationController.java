package com.aaa.repast.admin.project.system.shopinformation.shopinformation.controller;


import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.shopinformation.domain.ShopInformation;
import com.aaa.repast.admin.project.system.shopinformation.service.IShopInformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 店铺的基本 信息操作处理
 *
 * @author Seven Lee
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/system/shopInformation")
public class ShopInformationController extends BaseController
{
	private String prefix = "system/shopInformation";

	@Autowired
	private IShopInformationService shopInformationService;

	@RequiresPermissions("system:shopInformation:view")
	@GetMapping()
	public String shopInformation()
	{
		return prefix + "/shopInformation";
	}

	/**
	 * 查询店铺的基本列表
	 */
	@RequiresPermissions("system:shopInformation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopInformation shopInformation)
	{
		startPage();
		List<ShopInformation> list = shopInformationService.selectShopInformationList(shopInformation);

		return getDataTable(list);
	}


	/**
	 * 导出店铺的基本列表
	 */
	@RequiresPermissions("system:shopInformation:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(ShopInformation shopInformation)
	{
		List<ShopInformation> list = shopInformationService.selectShopInformationList(shopInformation);
		ExcelUtil<ShopInformation> util = new ExcelUtil<ShopInformation>(ShopInformation.class);
		return util.exportExcel(list, "shopInformation");
	}

	/**
	 * 新增店铺的基本
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存店铺的基本
	 */
	@RequiresPermissions("system:shopInformation:add")
	@Log(title = "店铺的基本", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopInformation shopInformation)
	{
		return toAjax(shopInformationService.insertShopInformation(shopInformation));
	}

	/**
	 * 店铺的营业执照
	 */
	@GetMapping("/editPic/{id}")
	public String exitPic(@PathVariable("id") Long id, ModelMap mmap)
	{
		ShopInformation shopInformation = shopInformationService.selectShopInformationById(id);
		mmap.put("shopInformation", shopInformation);
		return prefix + "/editPic";
	}

	/**
	 * 编辑店铺的营业执照并保存
	 */
	@RequiresPermissions("system:shopInformation:editPic")
	@Log(title = "店铺营业执照", businessType = BusinessType.UPDATE)
	@PostMapping("/editPic")
	@ResponseBody
	public AjaxResult exitPicSave(ShopInformation shopInformation)
	{
		System.out.println(shopInformation);
		return toAjax(shopInformationService.updateShopInfomationPic(shopInformation));
	}

	/**
	 * 修改店铺的基本
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ShopInformation shopInformation = shopInformationService.selectShopInformationById(id);
		mmap.put("shopInformation", shopInformation);
		return prefix + "/edit";
	}

	/**
	 * 修改保存店铺的基本
	 */
	@RequiresPermissions("system:shopInformation:edit")
	@Log(title = "店铺的基本", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopInformation shopInformation)
	{
		return toAjax(shopInformationService.updateShopInformation(shopInformation));
	}

	/**
	 * 删除店铺的基本
	 */
	@RequiresPermissions("system:shopInformation:remove")
	@Log(title = "店铺的基本", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(shopInformationService.deleteShopInformationByIds(ids));
	}


	@RequiresPermissions("system:shopInformation:editPic")
	@Log(title = "店铺营业执照", businessType = BusinessType.UPDATE)
	@PostMapping("/editPic")
	@ResponseBody
	public Map<String, Object> editPicSave(MultipartFile file,ShopInformation shopInformation) {
		System.out.println(shopInformation);
		System.out.println(file);
		int i = shopInformationService.updateShopInfomationPic(shopInformation);
		System.out.println(i);
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	/**
	 * 修改店铺的基本
	 */
	@GetMapping("/editPic/{id}")
	public String editPic(@PathVariable("id") Long id, ModelMap mmap)
	{
		ShopInformation shopInformation = shopInformationService.selectShopInformationById(id);
		mmap.put("shopInformation", shopInformation);
		return prefix + "/editPic";
	}

}
