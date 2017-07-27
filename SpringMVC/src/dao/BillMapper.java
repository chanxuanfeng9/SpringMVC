package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsBill;
import entity.SmbmsProvider;

public interface BillMapper {
	//根据商品名称（模糊查询），供应商名称,是否付款查询订单
	public List<SmbmsBill> getBillByThree(@Param("productName")String productName,@Param("proName")String proName,@Param("isPayment")Integer isPayment);
	//public List<SmbmsBill> getBillByThree(Map map);
	
	//获取全部订单信息
	public List<SmbmsBill> getBills(Map map);
	
	//根据id查询商品信息
	public SmbmsBill getBillById(@Param("id")Integer id);
	
	//修改订单信息
	public int updateBill(SmbmsBill bill);
	
	//根据id删除订单
	public int delBill(Integer id);
	
	//增加订单
	public int addBill(SmbmsBill bill);
}
