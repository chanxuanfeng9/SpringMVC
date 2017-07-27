package controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.SmbmsProvider;

import service.ProviderService;
@Controller
@RequestMapping("/provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	//��ѯ���й�Ӧ����Ϣ
	@RequestMapping("providerList")
	public String getProviderS(Map<String, Object> model){
		List<SmbmsProvider> providers=providerService.getProviders();
		model.put("providers", providers);
		return "providerList";	
	}		
	//���ݹ�Ӧ�����ƣ�ģ����ѯ����ѯ��Ӧ����Ϣ
	@RequestMapping(value="/getProvider",method=RequestMethod.GET)
	public String getProviderByProName(String proName,Map<String, Object> model){
		List<SmbmsProvider> providers=providerService.getProviderByProName(proName);
		model.put("providers", providers);
		return "providerList";		
	}
	//��ת����ӹ�Ӧ��ҳ��
	@RequestMapping(value="/turnPage",method=RequestMethod.GET)
	public String turnPage(SmbmsProvider provider){
		return "providerAdd";		
	}
	//��ӹ�Ӧ��
	@RequestMapping(value="/addProvider",method=RequestMethod.POST)
	public String addProvider(SmbmsProvider provider,Map<String, Object> model){
		int len=providerService.addProvider(provider);
		model.put("len", len);
		if(len<0){
			return "providerAdd";
		}
		return "redirect:/provider/providerList";		
	}
	//����id��ѯ��Ӧ����Ϣ
	@RequestMapping(value="/findProvider/{id}",method=RequestMethod.GET)
	public String getProviderById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsProvider provider=providerService.getProviderById(id);
		model.put("provider", provider);
		return "providerView";		
	}
	//����id��ת�����¹�Ӧ��ҳ��
	@RequestMapping(value="/findProvider/{id}",method=RequestMethod.PUT)
	public String turnUpdatePage(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsProvider provider=providerService.getProviderById(id);
		model.put("provider", provider);
		return "providerUpdate";		
	}
	//���¹�Ӧ����Ϣ
	@RequestMapping(value="/updateProvider",method=RequestMethod.PUT)
	public String updateProvider(SmbmsProvider provider,Map<String, Object> model){
		int len=providerService.updateProvider(provider);
		model.put("len", len);
		if(len<0){
			return "providerUpdate";
		}
		return "redirect:/provider/providerList";
	}
	//ɾ����Ӧ��
	@RequestMapping(value="/findProvider/{id}",method=RequestMethod.DELETE)
	public String delProvider(@PathVariable("id")Integer id,Map<String, Object> model){
		int len=providerService.delProvider(id);
		model.put("len", len);
		return "redirect:/provider/providerList";
	}
}
