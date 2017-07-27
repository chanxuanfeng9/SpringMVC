package service;

import java.util.List;


import entity.SmbmsProvider;

public interface ProviderService {
	//���ݹ�Ӧ�����ƣ�ģ����ѯ����ѯ��Ӧ����Ϣ
	public List<SmbmsProvider> getProviderByProName(String proName);
	//��ѯ���й�Ӧ����Ϣ
	public List<SmbmsProvider> getProviders();
	//��ӹ�Ӧ��
	public int addProvider(SmbmsProvider provider);
	//ͨ��id��ȡ��Ӧ����Ϣ
	public SmbmsProvider getProviderById(Integer id);
	//���¹�Ӧ����Ϣ
	public int updateProvider(SmbmsProvider provider);
	//ɾ����Ӧ����Ϣ
	public int delProvider(Integer id);
}
