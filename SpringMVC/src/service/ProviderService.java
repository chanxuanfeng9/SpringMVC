package service;

import java.util.List;


import entity.SmbmsProvider;

public interface ProviderService {
	//根据供应商名称（模糊查询）查询供应商信息
	public List<SmbmsProvider> getProviderByProName(String proName);
	//查询所有供应商信息
	public List<SmbmsProvider> getProviders();
	//添加供应商
	public int addProvider(SmbmsProvider provider);
	//通过id获取供应商信息
	public SmbmsProvider getProviderById(Integer id);
	//更新供应商信息
	public int updateProvider(SmbmsProvider provider);
	//删除供应商信息
	public int delProvider(Integer id);
}
