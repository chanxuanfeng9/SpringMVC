package service;

import java.util.List;
import java.util.Map;

import util.Page;
import util.ResultData;

import entity.SmbmsUser;

public interface UserService {
	//根据ID查找用户
	public SmbmsUser getUserById(Integer id);
	
	//查询所有用户
	public List<SmbmsUser> getUserByAll();
	
	//增加用户
	public int addUser(SmbmsUser user);
	
	//验证登录
	public ResultData isLogin(String usercode,String password);
	
	//根据id删除用户
	public int delUserById(Integer id);
	
	//根据id更新用户
	public int updateUser(SmbmsUser user);
	
	//模糊查询获取用户信息
	public List<SmbmsUser> getUsersByUserName(Map map);
}
