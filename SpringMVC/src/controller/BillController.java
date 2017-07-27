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
	
	//获取全部订单信息
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
	//根据商品名称（模糊查询），供应商名称是否付款查询订单	
	@RequestMapping(value="/getBill",method=RequestMethod.GET)
	public String getBillByThree(@RequestParam("productName")String productName,@RequestParam("proName")String proName,@RequestParam("payed")Integer isPayment,Map<String, Object> model){
		List<SmbmsBill> bills=billService.getBillByThree(productName, proName, isPayment);
		model.put("bills", bills);
		return "billList";
	}
	//根据id查询商品信息
	@RequestMapping(value="/findBill/{id}",method=RequestMethod.GET)
	public String getBillById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsBill bill=billService.getBillById(id);
		model.put("bill", bill);
		return "billView";	
	}
	//根据订单id跳转到更新订单页面
	@RequestMapping(value="/findBill/{id}",method=RequestMethod.PUT)
	public String updateBillById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsBill bill=billService.getBillById(id);
		List<SmbmsProvider> providers=providerService.getProviders();
		model.put("bill", bill);
		model.put("providers", providers);
		return "billUpdate";		
	}
	//根据订单id更新订单信息
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
	
	//根据id删除订单
	@RequestMapping(value="/findBill/{id}",method=RequestMethod.DELETE)
	public String delBill(@PathVariable("id")Integer id,Map<String, Object> model,HttpServletRequest request){
		int len=billService.delBill(id);
		model.put("len", len);
		return "redirect:/bill/billList";		
	}
	//跳转到增加订单页面
	@RequestMapping(value="/addBillBy",method=RequestMethod.GET)
	public String addBillBy(SmbmsBill bill){		
		return "billAdd";
	}
	//增加订单
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
