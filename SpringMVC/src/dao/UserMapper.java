package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import util.Page;

import entity.SmbmsUser;

public interface UserMapper {
	//����ID�����û�
	public SmbmsUser getUserById(Integer id);
	
	//��ѯ�����û�
	public List<SmbmsUser> getUserByAll();
	
	//�����û�
	public int addUser(SmbmsUser user);
	
	//�����û�
	public int updateUser(SmbmsUser user);
	
	//ɾ���û�
	public int delUser(Integer id);
	
	//����UserCode��ѯ�û�
	@Select("select * from smbms_user where userCode = #{userCode}")
	public SmbmsUser getUserByCode(String userCode);
	
	//����codeɾ���û�
	@Delete("delete from smbms_user where userCode = #{userCode}")
	public int delUserByCode(String userCode);
	
	//�����û���ɫid����ȷƥ�䣩���û����ƣ�ģ����ѯ����ѯ�û��б�
	public List<SmbmsUser> getUserbyRoleIdorUserName(@Param("roleId")Integer id,@Param("userName")String userName);
	//public List<SmbmsUser> getUsersByRoleIdOrUserName(Map map);
	
	//���ݸ����Ľ�ɫId��ѯ��ѯ�û��б�
	public List<SmbmsUser> getUsersByRoleIds(Integer[] roleIds);
	
	//�����û���ɫ�б���ȡ�ý�ɫ�б����û��б���Ϣ
	public List<SmbmsUser> getUserByRoleId(List<Integer> roleList);
	
	//���������Ľ�ɫID���Ա��ѯ�û��б�
	public List<SmbmsUser> getUsersByRoleMore(Map map);
	
	//�����û���ģ����ѯ���û���Ϣ
	public List<SmbmsUser> getUsersByUserName(Map map);
	
	//��ҳ��ѯ
	public List<SmbmsUser> getUsersByPage(Map map);
}
