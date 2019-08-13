package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.IMallOrderDao;
import com.abbot.schimneylife.dao.shopping.IMallProductAlibabaDao;
import com.abbot.schimneylife.dao.shopping.IMallProductBannerDao;
import com.abbot.schimneylife.dao.shopping.IMallProductDao;
import com.abbot.schimneylife.dao.shopping.IMallProductInfoDao;
import com.abbot.schimneylife.dao.shopping.IMallProductParameterDao;
import com.abbot.schimneylife.dao.shopping.IMallProductVODao;
import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.MallProductAlibaba;
import com.abbot.schimneylife.pojo.shopping.MallProductBanner;
import com.abbot.schimneylife.pojo.shopping.MallProductInfo;
import com.abbot.schimneylife.pojo.shopping.MallProductParameter;
import com.abbot.schimneylife.service.shopping.MallProductService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.vo.MallProductVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class MallProductServiceImpl implements MallProductService{
	private static final Logger logger = Logger.getLogger(MallProductServiceImpl.class);
	@Resource
	private IMallProductDao productDao;
	@Resource
	private IMallProductVODao proVODao;
	@Resource
	private IMallProductParameterDao paramDao;
	@Resource
	private IMallProductBannerDao bannerDao;
	@Resource
	private IMallProductInfoDao infoDao;
	@Resource
	private IMallProductAlibabaDao aliDao;
	@Resource
	private IMallOrderDao orderDao;
	@Override
	public List<MallProduct> findByPageAndType(String like,String order,String sort,String typeId, Integer firstResult, Integer pageSize) {
		List<MallProduct> productList = Collections.emptyList();
		try {
			productList = productDao.findByPageAndType(like,order,sort,typeId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询商品异常！",e);
		}
		return productList;
	}


	@Override
	public Integer countByType(String like, String typeId) {
		try {
			return productDao.countByType(like, typeId);
		} catch (Exception e) {
			logger.error("根据分类统计数量",e);
			return 0;
		}
	}


	@Transactional(rollbackFor=Exception.class)
	@Override
	public void addProduct(MallProduct product, List<MallProductParameter> paramList,
			List<MallProductBanner> bannerList, MallProductInfo proInfo) throws Exception {
		productDao.insert(product);
		for(MallProductParameter param:paramList) {
			param.setProductId(product.getId());
			paramDao.insert(param);
			if(product.getId()==null||param.getId()==null||param.getId().isEmpty()) {
				throw new Exception("error:productid= "+product.getId()+" parameterId is error parameterId="+param.getId());
			}
			aliDao.insert(product.getId(), param.getSpecId(), param.getId());
		}
		for(MallProductBanner banner:bannerList) {
			banner.setProId(product.getId());
			bannerDao.insert(banner);
		}
		proInfo.setProductId(product.getId());
		infoDao.insert(proInfo);
	}



	@Override
	public List<MallProduct> findByPage(Integer firstResult, Integer pageSize,String like,String order,Integer up,String provinces) {
		List<MallProduct> proList = Collections.emptyList();
		Map<String,Object> map = new HashMap<>();
		map.put("firstResult", firstResult);
		map.put("pageSize", pageSize);
		map.put("like", like);
		map.put("order", order);
		map.put("up", up);
		if(provinces!=null) {
			map.put("provinces", provinces.split(","));			
		}
		try {
			proList = productDao.findByPage(map);
		} catch (Exception e) {
			logger.error("分页查询商品异常！",e);
		}
		return proList;
	}

	@Override
	public Integer totalCount(String like,String provinces) {
		Integer total = 0;
		Map<String,Object> map = new HashMap<>();
		map.put("like", like);
		if(provinces!=null) {
			map.put("provinces", provinces.split(","));			
		}
		try {
			total = productDao.totalCount(map);
		} catch (Exception e) {
			logger.error("统计总数量异常！",e);
		}
		return total;
	}

	@Override
	public List<MallProduct> findBySale(Integer firstResult, Integer pageSize,String like, Integer order,String provinces) {
		List<MallProduct> proList = Collections.emptyList();
		Map<String,Object> map = new HashMap<>();
		map.put("firstResult", firstResult);
		map.put("pageSize", pageSize);
		map.put("like", like);
		map.put("order", order);
		if(provinces!=null) {
			map.put("provinces", provinces.split(","));			
		}
		try {
			proList = productDao.selectBySale(map);
		} catch (Exception e) {
			logger.error("根据销量分页查询异常！",e);
		}
		return proList;
	}

	@Override
	public List<MallProduct> findAllByCart(String shoppingCartId) {
		List<MallProduct> proList = Collections.emptyList();
		try {
			proList = productDao.selectAllByCartId(shoppingCartId);
		} catch (Exception e) {
			logger.error("查找指定购物车下所有商品异常！",e);
		}
		return proList;
	}

	@Override
	public MallProduct findById(String gid) {
		
		try {
			return productDao.fetchById(gid);
		} catch (Exception e) {
			logger.error("查找指定商品信息异常！",e);
			return new MallProduct();
		}
	}

	@Override
	public List<String> findProvince() {
		List<String> provinces = Collections.emptyList();
		try {
			provinces = productDao.findProvince();
		} catch (Exception e) {
			logger.error("筛选省份异常！",e);
		}
		return provinces;
	}

	@Override
	public List<MallProduct> findByProvince(Integer firstResult, Integer pageSize, String ids, String like) {
		List<MallProduct> proList = Collections.emptyList();
		Map<String,Object> map = new HashMap<>();
		map.put("firstResult", firstResult);
		map.put("pageSize", pageSize);
		map.put("ids", ids.split(","));
		map.put("like", like);
		try {
			proList = productDao.findByProvince(map);
		} catch (Exception e) {
			logger.error("根据省份模糊查询异常！",e);
		}
		return proList;
	}

	@Override
	public Integer countByProvince(String ids, String like) {
		Map<String,Object> map = new HashMap<>();
		map.put("ids", ids.split(","));
		map.put("like", like);
		try {
			return productDao.countByProvince(map);
		} catch (Exception e) {
			logger.error("根据省份查询统计数量",e);
			return 0;
		}
	}


	@Override
	public List<MallProductVO> findVOByPage(String typeId, String name, String sort, Integer order, Integer firstResult,
			Integer pageSize) {
		List<MallProductVO> voList = Collections.emptyList();
		switch(sort) {
		case "NUM":
			sort = "product_number";
			break;
		case "TIME":
			sort = "p.create_time";
			break;
		}
		String o = order==0?"asc":"desc";
		try {
			voList = proVODao.findProductVOByPage(typeId, name, sort, o, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据条件分页查询VO异常！",e);
		}
		return voList;
	}

	@Override
	public Integer countTotalVO(String typeId, String name) {
		try {
			return proVODao.countTotalVO(typeId, name);
		} catch (Exception e) {
			logger.error("统计VO数量异常！",e);
			return 0;
		}
	}

	@Override
	public List<MallProductVO> findAllVO(String typeId) {
		List<MallProductVO> voList = Collections.emptyList();
		try {
			voList = proVODao.findAllVO(typeId);
		} catch (Exception e) {
			logger.error("查询分类下的所有VO异常！",e);
		}
		return voList;
	}


	@Override
	public Integer fetchProStatusByParamId(String paramId) {
		try {
			return proVODao.fetchProStatusByParamId(paramId);
		} catch (Exception e) {
			logger.error("根据paramId查找对应商品的状态异常",e);
			return null;
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void disableByParamId(String paramId) throws Exception {
		paramDao.updateStatus(0, paramId);
		List<MallProductParameter> paramList = paramDao.findSameLevel(paramId);
		int status = 0;
		for(MallProductParameter param:paramList) {
			if(param.getStatus()==1) {
				status = 1;
				break;
			}
		}
		if(status==0) {
			productDao.updateStatusByParamId(status, paramId);
		}
		
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void enableByParamId(String paramId) throws Exception {
		paramDao.updateStatus(1, paramId);
		productDao.updateStatusByParamId(1, paramId);
	}


	@Transactional(rollbackFor=Exception.class)
	@Override
	public void deleteById(String id) throws Exception {
		productDao.deleteById(id);
		bannerDao.deleteByProId(id);
		infoDao.deleteByProId(id);
		List<MallProductParameter> paramList = paramDao.findByProductId(id);
		for(MallProductParameter param:paramList) {
			paramDao.deleteById(param.getId());
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void deleteByParamId(String paramId) throws Exception {
		MallProductParameter param = paramDao.fetchById(paramId);
		MallProduct product = productDao.fetchByParamId(paramId);
		if(param.getStatus()==1) {
			throw new Exception("不能删除启用状态的数据");
		}
		paramDao.deleteById(paramId);
		List<MallProductParameter> paramList = paramDao.findSameLevel(paramId);
		if(paramList.size()==0) {
			productDao.deleteById(product.getId());
			bannerDao.deleteByProId(product.getId());
			infoDao.deleteByProId(product.getId());
		}
	}


	@Override
	public MallProduct fetchByParamId(String paramId) {
		try {
			return productDao.fetchByParamId(paramId);
		} catch (Exception e) {
			logger.error("",e);
			return new MallProduct();
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void updateProduct(MallProduct product, List<MallProductParameter> paramList,
			List<MallProductBanner> bannerList,String oldBanner, MallProductInfo proInfo,String[] delParamIds,String productID) throws Exception {
		productDao.update(product);
		for(MallProductParameter param:paramList) {
			if("-1".equals(param.getId())) {//需要新增的规格属性
				paramDao.insert(param);
				if(CommonKey.ProductSource.SELFSUPPORT.getSource()!=product.getSource()) {//如果不是自营则添加关联数据
					if(productID==null||param.getId()==null||param.getId().isEmpty()) {
						throw new Exception("error: productID is null or parameterId is error parameterId="+param.getId());
					}
					aliDao.insert(productID, param.getSpecId(), param.getId());
				}
			}else {
				paramDao.update(param);
				if(CommonKey.ProductSource.SELFSUPPORT.getSource()!=product.getSource()) {//如果不是自营则添加关联数据
					if(productID==null||param.getId()==null||param.getId().isEmpty()) {
						throw new Exception("error: productID is null or parameterId is error parameterId="+param.getId());
					}
					MallProductAlibaba ali = aliDao.fetchByParamId(param.getId());
					if(ali==null) {
						aliDao.insert(productID, param.getSpecId(), param.getId());
					}else {						
						aliDao.update(param.getId(),productID , param.getSpecId());
					}
				}
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("images", oldBanner.split(";"));
		map.put("proId", product.getId());
		bannerDao.deleteNotInImages(map);
		for(MallProductBanner banner:bannerList) {
			banner.setProId(product.getId());
			bannerDao.insert(banner);
		}
		infoDao.update(proInfo);
		if(delParamIds!=null) {
			for(String delId:delParamIds) {
				paramDao.deleteById(delId);
			}			
		}
	}


	@Override
	public List<MallProduct> findByRecom(Integer firstResult, Integer pageSize) {
		List<MallProduct> productList = Collections.emptyList();
		try {
			productList = productDao.findByRecom(firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据推荐度分页查找",e);
		}
		return productList;
	}


	@Override
	public Integer totalCountByRecom() {
		try {
			return productDao.totalCountByRecom();
		} catch (Exception e) {
			logger.error("统计推荐商品数量",e);
			return 0;
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void enableByProId(String proId) throws Exception {
		MallProduct product = new MallProduct();
		product.setId(proId);
		product.setStatus(CommonKey.ENABLE_FLAG);
		productDao.update(product);
		List<MallProductParameter> paramList = paramDao.findByProductId(proId);
		for(MallProductParameter param:paramList) {
			paramDao.updateStatus(CommonKey.ENABLE_FLAG, param.getId());
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void disableByProId(String proId) throws Exception {
		MallProduct product = new MallProduct();
		product.setId(proId);
		product.setStatus(CommonKey.DISABLE_FLAG);
		productDao.update(product);
		List<MallProductParameter> paramList = paramDao.findByProductId(proId);
		for(MallProductParameter param:paramList) {
			paramDao.updateStatus(CommonKey.DISABLE_FLAG, param.getId());
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void test() throws Exception {
		List<MallProductParameter> paramList = paramDao.findAll();
		for(MallProductParameter param:paramList) {
			String jsons = param.getJson();
			if(jsons!=null) {
				JSONObject json = JSONObject.parseObject(jsons);
				JSONArray second = new JSONArray();
				Iterator<String> iterator = json.keySet().iterator();
				while(iterator.hasNext()) {
					String key = iterator.next();
					JSONObject o = new JSONObject();
					o.put(key, json.get(key));
					second.add(o);
				}
				MallProductParameter p = new MallProductParameter();
				p.setId(param.getId());
				p.setSecondParam(second.toJSONString());
				paramDao.update(p);
			}
		}
	}



	@Override
	public MallOrder selectMsg(String id) {
		try {
			return orderDao.selectMsg(id);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}



	@Override
	public MallProduct findByNumber(String number) {
		try {
			return productDao.findByNumber(number);
		} catch (Exception e) {
			logger.error("",e);
		}
		return null;
	}

	
}
