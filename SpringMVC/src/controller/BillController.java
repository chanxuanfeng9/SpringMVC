package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.SmbmsBill;
import entity.SmbmsProvider;
import entity.SmbmsUser;

import service.BillService;
import service.ProviderService;
import service.UserService;
import util.Page;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired
	private ProviderService providerService;
	
	//��ȡȫ��������Ϣ
	@RequestMapping("/billList")
	public String getBills(Map<String, Object> model){
		Page page=new Page();
		Map map=new HashMap();
		map.put("n", 0);
		map.put("size",5);
		model.put("page", page);
		List<SmbmsBill> bills=billService.getBills(map);
		model.put("bills", bills);
		return "billList";
	}
	//������Ʒ���ƣ�ģ����ѯ������Ӧ�������Ƿ񸶿��ѯ����	
	@RequestMapping(value="/getBill",method=RequestMethod.GET)
	public String getBillByThree(@RequestParam("productName")String productName,@RequestParam("proName")String proName,@RequestParam("payed")Integer isPayment,Map<String, Object> model){
		List<SmbmsBill> bills=billService.getBillByThree(productName, proName, isPayment);
		model.put("bills", bills);
		return "billList";
	}
	//����id��ѯ��Ʒ��Ϣ
	@RequestMapping(value="/findBill/{id}",method=RequestMethod.GET)
	public String getBillById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsBill bill=billService.getBillById(id);
		model.put("bill", bill);
		return "billView";	
	}
	//���ݶ���id��ת�����¶���ҳ��
	@RequestMapping(value="/findBill/{id}",method=RequestMethod.PUT)
	public String updateBillById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsBill bill=billService.getBillById(id);
		List<SmbmsProvider> providers=providerService.getProviders();
		model.put("bill", bill);
		model.put("providers", providers);
		return "billUpdate";		
	}
	//���ݶ���id���¶�����Ϣ
	@RequestMapping(value="/updateBill",method=RequestMethod.PUT)
	public String modifyBillById(SmbmsBill bill,Map<String, Object> model,HttpServletRequest request){
		int len=billService.updateBill(bill);
		model.put("len", len);
		bill.setModifyDate(new Date());
		if(len>0){
			return "redirect:/bill/billList";
		}
		return "billUpdate";		
	}
	
	//����idɾ������
	@RequestMapping(value="/findBill/{id}",method=RequestMethod.DELETE)
	public String delBill(@PathVariable("id")Integer id,Map<String, Object> model,HttpServletRequest request){
		int len=billService.delBill(id);
		model.put("len", len);
		return "redirect:/bill/billList";		
	}
	//��ת�����Ӷ���ҳ��
	@RequestMapping(value="/addBillBy",method=RequestMethod.GET)
	public String addBillBy(SmbmsBill bill){		
		return "billAdd";
	}
	//���Ӷ���
	@RequestMapping(value="/addBill",method=RequestMethod.POST)
	public String addBill(SmbmsBill bill,Map<String, Object> model){
		int len=billService.addBill(bill);
		List<SmbmsProvider> providers=providerService.getProviders();
		model.put("providers", providers);
		model.put("len", len);
		if(len>0){
			return "redirect:/bill/billList";
		}
		return "billAdd";
	}
}
