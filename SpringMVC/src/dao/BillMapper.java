package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsBill;
import entity.SmbmsProvider;

public interface BillMapper {
	//������Ʒ���ƣ�ģ����ѯ������Ӧ������,�Ƿ񸶿��ѯ����
	public List<SmbmsBill> getBillByThree(@Param("productName")String productName,@Param("proName")String proName,@Param("isPayment")Integer isPayment);
	//public List<SmbmsBill> getBillByThree(Map map);
	
	//��ȡȫ��������Ϣ
	public List<SmbmsBill> getBills(Map map);
	
	//����id��ѯ��Ʒ��Ϣ
	public SmbmsBill getBillById(@Param("id")Integer id);
	
	//�޸Ķ�����Ϣ
	public int updateBill(SmbmsBill bill);
	
	//����idɾ������
	public int delBill(Integer id);
	
	//���Ӷ���
	public int addBill(SmbmsBill bill);
}
