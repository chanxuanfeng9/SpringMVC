package service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BillMapper;

import entity.SmbmsBill;
import entity.SmbmsProvider;
@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillMapper billMapper;

	@Override
	public List<SmbmsBill> getBills(Map map) {
		return billMapper.getBills(map);
	}

	public List<SmbmsBill> getBillByThree(String productName, String proName,
			Integer isPayment) {
		return billMapper.getBillByThree(productName, proName, isPayment);
	}

	@Override
	public SmbmsBill getBillById(Integer id) {
		return billMapper.getBillById(id);
	}

	@Override
	public int updateBill(SmbmsBill bill) {
		int len=billMapper.updateBill(bill);
		return len;
	}

	@Override
	public int delBill(Integer id) {
		return billMapper.delBill(id);
	}

	@Override
	public int addBill(SmbmsBill bill) {
		return billMapper.addBill(bill);
	}
	
}
