package service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsBill;
import entity.SmbmsProvider;

public interface BillService {
	//根据商品名称（模糊查询），供应商名称是否付款查询订单
	public List<SmbmsBill> getBillByThree(String productName,String proName,Integer isPayment);
	
	//获取全部订单信息
	public List<SmbmsBill> getBills(Map map);
	
	//根据商品名称查询订单信息
	public SmbmsBill getBillById(Integer id);
	
	//根据id更新订单信息
	public int updateBill(SmbmsBill bill);
	
	//根据id删除订单
	public int delBill(Integer id);
	
	//增加订单
	public int addBill(SmbmsBill bill);
}
