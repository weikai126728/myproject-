package com.abbot.schimneylife.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.weixin.WanghongTixian;

@Repository
public interface IUserDao {
	/**
	 * 新建用户
	 * 
	 * @param user
	 *            用户实例
	 * @throws Exception
	 */
	Integer insert(User user) throws Exception;

	List<User> findByPageAndType(@Param("order") String order, @Param("sort") String sort,
			@Param("firstResult") Integer firstResult, @Param("pageSize") Integer pageSize) throws Exception;

	List<User> findRedByType(@Param("order") String order, @Param("sort") String sort,
			@Param("firstResult") Integer firstResult, @Param("pageSize") Integer pageSize
			,@Param("like")String like) throws Exception;

	List<User> findRedDetailByType(@Param("order") String order, @Param("sort") String sort,
			@Param("firstResult") Integer firstResult, @Param("pageSize") Integer pageSize,
			@Param("phone") String phone) throws Exception;

	/**
	 * 根据登录名查找用户
	 * 
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	User selectByLoginName(@Param("loginName")String loginName) throws Exception;

	/**
	 * 根据ID查找用户
	 * 
	 * @param id
	 * @return
	 */
	User findById(@Param("id") Integer id) throws Exception;

	/**
	 * 根据手机号查找用户
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	User selectByPhone(String phone) throws Exception;

	/**
	 * 重置密码
	 * 
	 * @param user
	 * @return
	 */
	void forgetPassword(User user);

	/**
	 * 修改密码
	 * 
	 * @param user
	 * @return
	 */
	void updatePassword(User user) throws Exception;

	/**
	 * 修改手机号
	 * 
	 * @param user
	 * @return
	 */
	void updatePhone(User user) throws Exception;

	/**
	 * 修改个人信息
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUser(User user) throws Exception;

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Integer updateMessage(User user) throws Exception;

	/**
	 * 统计指定昵称的用户数量
	 * 
	 * @param nickName
	 * @return
	 * @throws Exception
	 */
	Integer countNickName(String nickName) throws Exception;

	/**
	 * 统计指定手机号的用户数量
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	Integer countPhone(@Param("phone")String phone,@Param("level")Integer level) throws Exception;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 * @throws Exception
	 */
	List<User> selectAllUser() throws Exception;

	/**
	 * 查询用户总数
	 * 
	 * @return
	 */
	Integer selectCount() throws Exception;

	Integer totalCount(@Param("like")String like) throws Exception;

	Integer redCount(@Param("phone") String phone) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	void deleteUser(@Param("id") Integer id) throws Exception;

	/**
	 * 禁用
	 * 
	 * @param id
	 */
	void disable(@Param("id") Integer id) throws Exception;

	/**
	 * 启用
	 * 
	 * @param id
	 */
	void enable(@Param("id") Integer id) throws Exception;

	/**
	 * 搜索查询
	 * 
	 * @param name
	 * @param time
	 * @return
	 * @throws Exception
	 */
	List<User> selectUserByName(@Param("nickName") String name) throws Exception;
	List<User> selectRedUserByName(@Param("nickName") String name) throws Exception;

	/**
	 * 根据角色等级分页查询用户数据
	 * 
	 * @param level
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<User> findByLevel(@Param("level") Integer level, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize, @Param("like") String like, @Param("order") String order)
			throws Exception;

	Integer countByLevel(@Param("level") Integer level, @Param("like") String like) throws Exception;

	User fetchByOpenId(@Param("openId") String openId) throws Exception;
	
	/**
	 * 网红查询
	 * @return
	 * @throws Exception
	 */
	Integer queryWanghongCount() throws Exception;
	List<User> queryWanghongList(@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;
	void addRednetnow(WanghongTixian wanghongtixian)throws Exception;
	/**
	 * 根据商超id和角色等级查询关系人
	 * @param allianceId
	 * @param level
	 * @return
	 * @throws Exception
	 */
	User fetchUserByAllianceIdAndLevel(@Param("allianceId")Integer allianceId,@Param("level")Integer level)throws Exception;
}
