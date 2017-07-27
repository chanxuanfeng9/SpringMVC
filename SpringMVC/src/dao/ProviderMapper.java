package dao;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsProvider;

public interface ProviderMapper {
	/*���ݹ�Ӧ�̱��루ģ����ѯ���͹�Ӧ�����ƣ�ģ����ѯ��
	 * ��ѯ����б���Ӧ��id����Ӧ�̱��롢��Ӧ�����ơ���ϵ�ˡ���ϵ�绰�����桢����ʱ��
	 * */
	//public List<SmbmsProvider> getProviderByProCodeOrProName(Map map);
	
	public List<SmbmsProvider> getProviderByProCodeOrProName(@Param("proCode")String proCode,@Param("proName")String proName);
	
	//���ݹ�Ӧ�����ƣ�ģ����ѯ����ѯ��Ӧ����Ϣ
	public List<SmbmsProvider> getProviderByProName(@Param("proName")String proName);
	
	//��ѯ���й�Ӧ����Ϣ
	public List<SmbmsProvider> getProviders();
	
	//��ӹ�Ӧ��
	public int addProvider(SmbmsProvider provider);
	
	//���Ĺ�Ӧ����Ϣ
	public int updateProvider(SmbmsProvider provider);
	//ͨ��id��ȡ��Ӧ����Ϣ
	public SmbmsProvider getProviderById(Integer id);
	//ɾ����Ӧ����Ϣ
	public int delProvider(Integer id);
}
