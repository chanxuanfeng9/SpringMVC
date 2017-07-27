package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import util.Page;

import entity.SmbmsUser;

public interface UserMapper {
	//根据ID查找用户
	public SmbmsUser getUserById(Integer id);
	
	//查询所有用户
	public List<SmbmsUser> getUserByAll();
	
	//增加用户
	public int addUser(SmbmsUser user);
	
	//更新用户
	public int updateUser(SmbmsUser user);
	
	//删除用户
	public int delUser(Integer id);
	
	//根据UserCode查询用户
	@Select("select * from smbms_user where userCode = #{userCode}")
	public SmbmsUser getUserByCode(String userCode);
	
	//根据code删除用户
	@Delete("delete from smbms_user where userCode = #{userCode}")
	public int delUserByCode(String userCode);
	
	//根据用户角色id（精确匹配）和用户名称（模糊查询）查询用户列表
	public List<SmbmsUser> getUserbyRoleIdorUserName(@Param("roleId")Integer id,@Param("userName")String userName);
	//public List<SmbmsUser> getUsersByRoleIdOrUserName(Map map);
	
	//根据给定的角色Id查询查询用户列表
	public List<SmbmsUser> getUsersByRoleIds(Integer[] roleIds);
	
	//根据用户角色列表，获取该角色列表下用户列表信息
	public List<SmbmsUser> getUserByRoleId(List<Integer> roleList);
	
	//根换给定的角色ID和性别查询用户列表
	public List<SmbmsUser> getUsersByRoleMore(Map map);
	
	//根据用户名模糊查询出用户信息
	public List<SmbmsUser> getUsersByUserName(Map map);
	
	//分页查询
	public List<SmbmsUser> getUsersByPage(Map map);
}
