package com.abbot.schimneylife.service.user;

import java.util.List;

import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.weixin.WanghongTixian;

public interface UserService {
	/**
	 * 根据登录名查找用户
	 * 
	 * @param loginName
	 *            登录名
	 * @return
	 */
	User findByLoginName(String loginName);

	/**
	 * 根据Id查找用户
	 * 
	 * @param id
	 * @return
	 */
	User findById(Integer id);

	/**
	 * 根据分类分页查询商品
	 * 
	 * @param typeId
	 *            商品分类id
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<User> findByPageAndType(String order, String sort, Integer firstResult, Integer pageSize);
	List<User> findRedByType(String order, String sort, Integer firstResult, Integer pageSize,String like);
	List<User> findRedDetailByType(String order, String sort, Integer firstResult, Integer pageSize,String phone);

	/**
	 * �根据手机号查找用户
	 * 
	 * @param phone
	 * @return
	 */
	User findByPhone(String phone);

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	Integer addUser(User user);

	void addUser(User user, Integer roleId) throws Exception;

	/**
	 * 修改密码
	 * 
	 * @param user
	 */
	boolean updatePassword(User user);

	/**
	 * 重置密码
	 * 
	 * @param user
	 * @return
	 */
	boolean forgetPassword(User user);

	/**
	 * 修改手机号
	 * 
	 * @param user
	 * @return
	 */
	boolean updatePhone(User user);

	/**
	 * 修改个人信息
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);

	void updateUser(User user, Integer roleId) throws Exception;

	/**
	 * 昵称是否已被试用
	 * 
	 * @param nickName
	 * @return
	 */
	boolean nickUsed(String nickName);

	/**
	 * 手机号是否已被试用
	 * 
	 * @param phone
	 * @return
	 */
	boolean phoneUsed(String phone,Integer level);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<User> selectAllUser();

	/**
	 * 查询总条数
	 * 
	 * @return
	 */
	Integer selectCount();
	Integer totalCount(String like);
	Integer redCount(String phone);

	/**
	 * 删除指定用户
	 * 
	 * @param id
	 */
//	boolean deleteOneUser(Integer id);

	/**
	 * 批量删除
	 * 
	 * @param id
	 * @return
	 */
//	boolean deleteUser(String id);

	/**
	 * 禁用用户
	 * 
	 * @param id
	 */
	boolean disable(Integer id);

	/**
	 * 启用用户
	 * 
	 * @param id
	 */
	boolean enable(Integer id);

	/**
	 * 搜索查询
	 * 
	 * @return
	 */
	List<User> selectUserByName(String name);
	List<User> selectRedUserByName(String name);

	/**
	 * 根据角色等级分页查询
	 * 
	 * @param level
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @return
	 */
	List<User> findByLevel(Integer level, Integer firstResult, Integer pageSize, String like, String order);

	/**
	 * 根据角色等级统计
	 * 
	 * @param level
	 * @param like
	 * @return
	 */
	Integer countByLevel(Integer level, String like);

	void deletUserAndRelation(Integer userId) throws Exception;
	
	/**
	 * 网红查询
	 * @return
	 */
	Integer queryWanghongCount();
	List<User> queryWanghongList(String like, String order, String sort, String typeId, Integer firstResult,
			Integer pageSize);
	boolean addRednetnow(WanghongTixian wanghongtixian);
	/**
	 * 根据商超id和角色等级查询关系人
	 * @param allianceId
	 * @param level
	 * @return
	 */
	User fetchUserByAllianceIdAndLevel(Integer allianceId,Integer level);
}
