package service;

import java.util.List;
import java.util.Map;

import util.Page;
import util.ResultData;

import entity.SmbmsUser;

public interface UserService {
	//����ID�����û�
	public SmbmsUser getUserById(Integer id);
	
	//��ѯ�����û�
	public List<SmbmsUser> getUserByAll();
	
	//�����û�
	public int addUser(SmbmsUser user);
	
	//��֤��¼
	public ResultData isLogin(String usercode,String password);
	
	//����idɾ���û�
	public int delUserById(Integer id);
	
	//����id�����û�
	public int updateUser(SmbmsUser user);
	
	//ģ����ѯ��ȡ�û���Ϣ
	public List<SmbmsUser> getUsersByUserName(Map map);
}
