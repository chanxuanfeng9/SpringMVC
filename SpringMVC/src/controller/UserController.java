package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Constants;

import entity.SmbmsUser;

import service.UserService;
import util.Page;
import util.ResultData;

@Controller
@RequestMapping("/user")
@SessionAttributes(value="suser")
public class UserController {
	@Autowired
	private UserService userService;
	//ģ����ѯ��ȡ�û���Ϣ����ҳ
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public String getUserByUserName(@RequestParam("userName")String userName,Map<String, Object> model){
		Page page=new Page();
		Map map=new HashMap();
		map.put("n", 0);
		map.put("size",3);
		map.put("userName", userName);
		model.put("page", page);
		List<SmbmsUser> users=userService.getUsersByUserName(map);		
		model.put("users", users);
		return "userList";
		
	}
	//�����û������浽���ݿ�
	@RequestMapping(value="/addUserSave",method=RequestMethod.POST)
	public String addUserSave(@Valid SmbmsUser user,BindingResult bindingResult,@RequestParam("multipartFile")MultipartFile multipartFile,HttpSession session) throws IllegalStateException, IOException{
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getCode()); //�����ĸ�������֤ûͨ��
				System.out.println(error.getDefaultMessage());
			}
			return "userAdd";			
		}
		//for(MultipartFile mf:multipartFile){
			//��ȡ�ϴ��ļ���
//			String fileName = multipartFile.getOriginalFilename();
//			//�ж��ļ��Ƿ���һ���Ϸ�ͼƬ
//			if(fileName.endsWith("jpg") || fileName.endsWith("png")){
//				//��ȡ�ϴ�Ŀ¼
//				String path = session.getServletContext().getRealPath("/uploadFile");
//				File file = new File(path,UUID.randomUUID().toString()+fileName);
//				//����
//				multipartFile.transferTo(file);
//				user.setIdPicPath(UUID.randomUUID().toString()+fileName);
//			}
		//}
		//��ȡ�ϴ��ļ���
		String fileName=multipartFile.getOriginalFilename();
		//�ж��ļ��Ƿ���һ���Ϸ���ͼƬ
		if(fileName.endsWith("jpg") || fileName.endsWith("png") || fileName.endsWith("jpeg")){
			//��ȡ�ϴ�Ŀ¼
			String path=session.getServletContext().getRealPath("/uploadFile");
			System.out.println(path);
			File file=new File(path,UUID.randomUUID().toString()+fileName);
			//����
			multipartFile.transferTo(file);
		}
		user.setCreationDate(new Date());
		user.setIdPicPath(UUID.randomUUID().toString()+fileName);
		int len=userService.addUser(user);		
		if(len>0){
			return "redirect:/user/userList";
		}
		return "userAdd";
	}
	
	//��������ӡ���ת������ҳ��
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user")SmbmsUser user){		
		return "userAdd";
	}
	//����id�����û���Ϣ
	@RequestMapping(value="/updateUser",method=RequestMethod.PUT)
	public String modifyUser(SmbmsUser smbmsUser,Map<String, Object> model){
		int len=userService.updateUser(smbmsUser);
		model.put("len", len);
		smbmsUser.setModifyDate(new Date());
		System.out.println(smbmsUser);
		return "redirect:/user/userList";
	}
	//����id��ת����ҳ��
	@RequestMapping(value="/findUser/{id}",method=RequestMethod.PUT)
	public String updateUserById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsUser user=userService.getUserById(id);
		Map sexes=new HashMap();
		sexes.put("1", "��");
		sexes.put("2", "Ů");
		Map userTypes=new HashMap();
		userTypes.put("1", "����Ա");
		userTypes.put("2", "����");
		userTypes.put("3", "��ͨԱ��");
		model.put("user", user);
		model.put("sexes", sexes);
		model.put("userTypes", userTypes);
		return "userUpdate";
	}
	//����id����û���Ϣ
	@RequestMapping(value="/findUser/{id}",method=RequestMethod.GET)
	public String getUserById(@PathVariable("id")Integer id,Map<String, Object> model){
		SmbmsUser user=userService.getUserById(id);
		model.put("user", user);
		return "userView";
	}
	//����idɾ���û�
	@RequestMapping(value="/findUser/{id}",method=RequestMethod.DELETE)
	public String delUserById(@PathVariable("id")Integer id,Map<String, Object> model,HttpServletRequest request){
		int len=userService.delUserById(id);
		model.put("len", len);
		//�ض��� ��д�� "redirect:../userList"
		return "redirect:/user/userList";
	}
	//��ȡȫ���û���Ϣ
	@RequestMapping("/userList")
	public String getUserByAll(Map<String, Object> model){
		List<SmbmsUser> users=userService.getUserByAll();
		model.put("users", users);
		return "userList";
	}
	//����cookie
	@RequestMapping("testCookie")
	public String testCookie(@CookieValue("userCode")String userCode){
		System.out.println(userCode);
		return "index";
	}
	//��½��֤
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String isLogin(String userCode,String password,Map<String,Object> model,HttpServletResponse response){
		ResultData rd=new ResultData();
		rd=userService.isLogin(userCode, password);
		if(rd.getFlag()!=0){
			model.put("rd", rd);
			return "login";
		}else{
			//Ĭ��user������request����,�����ע��@SessionAttributes���԰�user�浽session
			model.put("suser",rd.getData());
			//���û���ű��浽cookie
			Cookie cookie = new Cookie("userCode",((SmbmsUser)rd.getData()).getUserCode());
			response.addCookie(cookie);
			return "redirect:/frame.html";
		}		
	}	
	//��½��֤
	/*@RequestMapping(value="/login/{usercode}/{password}",method=RequestMethod.POST)
	@ResponseBody
	public String isLogin(@PathVariable("usercode")String usercode,@PathVariable("password")String password,HttpServletRequest request){
		ResultData rd=new ResultData();
		rd=userService.isLogin(usercode, password);
		request.getSession().setAttribute("user", rd.getData());
		rd.setData(null);		
		return JSON.toJSONString(rd);		
	}*/
	//��ͳweb����
	/*@RequestMapping("UserList")
	public void getUserByAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<SmbmsUser> users=userService.getUserByAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("UserList.jsp").forward(request, response);		
	}*/
	
	/*@RequestMapping("UserOne")
	public ModelAndView getUserById(Integer id){
		ModelAndView model=new ModelAndView();
		SmbmsUser user = userService.getUserById(id);
		List<SmbmsUser> users =new ArrayList<SmbmsUser>();
		users.add(user);
		model.addObject("users", users);
		model.setViewName("UserList");
		return model;
	}*/
	/*@RequestMapping("UserOne")
	public String getUserById(Integer id,Model model){
		SmbmsUser user=userService.getUserById(id);
		List<SmbmsUser> users=new ArrayList<SmbmsUser>();
		users.add(user);
		model.addAttribute("users", users);
		return "UserList";		
	}*/
	/*@RequestMapping("UserOne")
	public String getUserById(Integer id,Map<String, Object> map){
		SmbmsUser user=userService.getUserById(id);
		List<SmbmsUser> users=new ArrayList<SmbmsUser>();
		users.add(user);
		map.put("users", users);
		return "UserList";
	}*/
	
	//������������֮ǰ��������@ModelAttributeע��ķ���
	@ModelAttribute
	public void publicMethod(Integer id,Map<String, Object> model){
		if(id!=null){
			SmbmsUser user=userService.getUserById(id);
			model.put("smbmsUser", user);
		}	
	}
}
