package service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsBill;
import entity.SmbmsProvider;

public interface BillService {
	//������Ʒ���ƣ�ģ����ѯ������Ӧ�������Ƿ񸶿��ѯ����
	public List<SmbmsBill> getBillByThree(String productName,String proName,Integer isPayment);
	
	//��ȡȫ��������Ϣ
	public List<SmbmsBill> getBills(Map map);
	
	//������Ʒ���Ʋ�ѯ������Ϣ
	public SmbmsBill getBillById(Integer id);
	
	//����id���¶�����Ϣ
	public int updateBill(SmbmsBill bill);
	
	//����idɾ������
	public int delBill(Integer id);
	
	//���Ӷ���
	public int addBill(SmbmsBill bill);
}
