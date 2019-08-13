package com.abbot.schimneylife.serviceImpl.user;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.user.IUserCustomerDao;
import com.abbot.schimneylife.dao.user.IUserDao;
import com.abbot.schimneylife.dao.user.IUserToRoleDao;
import com.abbot.schimneylife.dao.weixin.IAllianceDao;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.user.UserCustomer;
import com.abbot.schimneylife.pojo.weixin.WanghongTixian;
import com.abbot.schimneylife.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Resource
	private IUserDao userDao;
	@Resource
	private IUserCustomerDao cusDao;
	@Resource
	private IUserToRoleDao toDao;
	@Resource
	private IAllianceDao allianceDao;

	@Override
	public User findByLoginName(String loginName) {
		try {
			return userDao.selectByLoginName(loginName);
		} catch (Exception e) {
			logger.error("根据登录名查找用户异常", e);
			return null;
		}
	}

	@Override
	public List<User> findByPageAndType(String order, String sort, Integer firstResult, Integer pageSize) {
		List<User> userList = Collections.emptyList();
		try {
			userList = userDao.findByPageAndType(order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return userList;
	}
	@Override
	public List<User> findRedByType(String order, String sort, Integer firstResult, Integer pageSize,String like) {
		List<User> userList = Collections.emptyList();
		try {
			userList = userDao.findRedByType(order, sort, firstResult, pageSize,like);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return userList;
	}
	@Override
	public List<User> findRedDetailByType(String order, String sort, Integer firstResult, Integer pageSize,String phone) {
		List<User> userList = Collections.emptyList();
		try {
			userList = userDao.findRedDetailByType(order, sort, firstResult, pageSize,phone);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return userList;
	}

	@Override
	public User findByPhone(String phone) {
		User user;
		try {
			user = userDao.selectByPhone(phone);
		} catch (Exception e) {
			user = new User();
			logger.error("根据手机号查找异常", e);
		}
		return user;
	}

	@Transactional
	@Override
	public Integer addUser(User user) {
		try {
			return userDao.insert(user);
		} catch (Exception e) {
			logger.error("新增用户异常", e);
			return 0;
		}
	}

	@Override
	public boolean forgetPassword(User user) {
		try {
			userDao.forgetPassword(user);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	@Override
	public boolean nickUsed(String nickName) {
		int count = 1;
		try {
			count = userDao.countNickName(nickName);
		} catch (Exception e) {
			count = 1;
			logger.error("查询昵称异常", e);
		}
		return count == 0 ? true : false;
	}

	@Override
	public boolean phoneUsed(String phone,Integer level) {
		int count = 1;
		try {
			count = userDao.countPhone(phone,level);
		} catch (Exception e) {
			count = 1;
			logger.error("查询手机号异常", e);
		}
		return count == 0 ? true : false;
	}

	@Override
	public boolean updatePhone(User user) {

		try {
			userDao.updatePhone(user);
			return true;
		} catch (Exception e) {
			logger.error("修改手机号异常", e);
			return false;
		}
	}

	@Override
	public Integer updateUser(User user) {

		try {
			return userDao.updateUser(user);
		} catch (Exception e) {
			logger.error("修改用户信息异常", e);
			return 0;
		}

	}

	@Override
	public boolean updatePassword(User user) {
		try {
			userDao.updatePassword(user);
			return true;
		} catch (Exception e) {
			logger.error("修改密码异常", e);
			return false;
		}
	}

	@Override
	public List<User> selectAllUser() {
		List<User> list = Collections.emptyList();
		try {
			return userDao.selectAllUser();
		} catch (Exception e) {
			logger.error("查询用户列表异常", e);
			return list;
		}
	}

	@Override
	public Integer selectCount() {
		try {
			return userDao.selectCount();
		} catch (Exception e) {
			logger.error("查询总数异常", e);
			return 0;
		}
	}
	@Override
	public Integer redCount(String phone) {
		try {
			return userDao.redCount(phone);
		} catch (Exception e) {
			logger.error("查询总数异常", e);
			return 0;
		}
	}
	@Override
	public Integer totalCount(String like) {
		try {
			return userDao.totalCount(like);
		} catch (Exception e) {
			logger.error("查询总数异常", e);
			return 0;
		}
	}

//	@Override
//	public boolean deleteUser(String ids) {
//		try {
//			String[] id = ids.split(",");
//			for (int i = 0; i < id.length; i++) {
//				userDao.deleteUser(Integer.parseInt(id[i]));
//			}
//			return true;
//		} catch (Exception e) {
//			logger.error("删除用户异常", e);
//			return false;
//		}
//	}

	@Override
	public boolean disable(Integer id) {
		try {
			userDao.disable(id);
			return true;
		} catch (Exception e) {
			logger.error("禁用异常", e);
			return false;
		}
	}

	@Override
	public boolean enable(Integer id) {
		try {
			userDao.enable(id);
			return true;
		} catch (Exception e) {
			logger.error("启用异常", e);
			return false;
		}
	}

	@Override
	public User findById(Integer id) {
		try {
			return userDao.findById(id);
		} catch (Exception e) {
			logger.error("根据ID查找异常", e);
			return null;
		}
	}

//	@Override
//	public boolean deleteOneUser(Integer id) {
//		try {
//			userDao.deleteUser(id);
//			return true;
//		} catch (Exception e) {
//			logger.error("根据ID删除异常", e);
//			return false;
//		}
//	}

	@Override
	public List<User> selectUserByName(String name) {
		try {
			return userDao.selectUserByName(name);
		} catch (Exception e) {
			logger.error("查询删除异常", e);
			return null;
		}
	}
	@Override
	public List<User> selectRedUserByName(String name) {
		try {
			return userDao.selectRedUserByName(name);
		} catch (Exception e) {
			logger.error("查询删除异常", e);
			return null;
		}
	}

	@Override
	public List<User> findByLevel(Integer level, Integer firstResult, Integer pageSize, String like, String order) {
		List<User> userList = Collections.emptyList();
		try {
			userList = userDao.findByLevel(level, firstResult, pageSize, like, order);
		} catch (Exception e) {
			logger.error("根据角色等级分页查询", e);
		}
		return userList;
	}

	@Override
	public Integer countByLevel(Integer level, String like) {
		try {
			return userDao.countByLevel(level, like);
		} catch (Exception e) {
			logger.error("根据角色等级统计", e);
			return 0;
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUser(User user, Integer roleId) throws Exception {
		userDao.insert(user);
		toDao.addRelation(user.getId(), roleId);
		UserCustomer uc = new UserCustomer();
		uc.setNickName(user.getNickName());
		uc.setUserID(user.getId());
		cusDao.insert(uc);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deletUserAndRelation(Integer userId) throws Exception {
		userDao.deleteUser(userId);
		toDao.delete(userId);
		cusDao.deleteByUserId(userId);
		allianceDao.deleteRelByUserId(userId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateUser(User user, Integer roleId) throws Exception {
		userDao.updateUser(user);
		toDao.update(user.getId(), roleId);
	}

	@Override
	public List<User> queryWanghongList(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		List<User> userList = Collections.emptyList();
		try {
			userList=userDao.queryWanghongList(like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("查询网红时异常", e);
		}
		return userList;
	}

	@Override
	public boolean addRednetnow(WanghongTixian wanghongtixian) {
		try {
			userDao.addRednetnow(wanghongtixian);
			return true;
		} catch (Exception e) {
			logger.error("存储网红提现信息时异常", e);
			return false;
		}
	}

	@Override
	public Integer queryWanghongCount() {
		try {
			return userDao.queryWanghongCount();
		} catch (Exception e) {
			logger.error("查询网红数量时异常", e);
			return 0;
		}
	}

	@Override
	public User fetchUserByAllianceIdAndLevel(Integer allianceId, Integer level) {
		try {
			return userDao.fetchUserByAllianceIdAndLevel(allianceId, level);
		} catch (Exception e) {
			logger.error("根据商超id和角色等级查询关系人异常",e);
			return null;
		}
	}

}
