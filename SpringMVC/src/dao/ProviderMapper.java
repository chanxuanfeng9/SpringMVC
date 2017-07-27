package dao;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsProvider;

public interface ProviderMapper {
	/*根据供应商编码（模糊查询）和供应商名称（模糊查询）
	 * 查询结果列表：供应商id、供应商编码、供应商名称、联系人、联系电话、传真、创建时间
	 * */
	//public List<SmbmsProvider> getProviderByProCodeOrProName(Map map);
	
	public List<SmbmsProvider> getProviderByProCodeOrProName(@Param("proCode")String proCode,@Param("proName")String proName);
	
	//根据供应商名称（模糊查询）查询供应商信息
	public List<SmbmsProvider> getProviderByProName(@Param("proName")String proName);
	
	//查询所有供应商信息
	public List<SmbmsProvider> getProviders();
	
	//添加供应商
	public int addProvider(SmbmsProvider provider);
	
	//更改供应商信息
	public int updateProvider(SmbmsProvider provider);
	//通过id获取供应商信息
	public SmbmsProvider getProviderById(Integer id);
	//删除供应商信息
	public int delProvider(Integer id);
}
