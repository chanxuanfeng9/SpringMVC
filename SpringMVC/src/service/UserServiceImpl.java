package service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import util.Page;
import util.ResultData;

import dao.UserMapper;
import entity.SmbmsUser;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	public SmbmsUser getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	public List<SmbmsUser> getUserByAll() {
		return userMapper.getUserByAll();
	}

	@Override
	@Transactional(readOnly=false)
	public int addUser(SmbmsUser user) {		
		return userMapper.addUser(user);
	}

	@Override
	public ResultData isLogin(String usercode, String password) {
		ResultData rd=new ResultData();
		SmbmsUser user=userMapper.getUserByCode(usercode);
		if(user==null){
			rd.setFlag(1);
			rd.setMsg("用户名不存在！");
		}else{
			if(!password.equals(user.getUserPassword())){
				rd.setFlag(2);
				rd.setMsg("密码不正确！");
			}else{
				rd.setFlag(0);
				rd.setMsg("登录成功！");
				rd.setData(user);
			}
		}
		return rd;
	}

	@Override
	public int delUserById(Integer id) {
		int len=userMapper.delUser(id);
		return len;
	}

	@Override
	public int updateUser(SmbmsUser user) {
		int len=userMapper.updateUser(user);
		return len;
	}

	@Override
	public List<SmbmsUser> getUsersByUserName(Map map) {
		return userMapper.getUsersByUserName(map);
		
	}


}
