package com.hzy.localcache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hzy.config.YmlConfigStore;
import com.hzy.pojo.ymlVo.BaseYml;
import com.hzy.util.YmlUtil;

public class YmlConfigCache {
	
	private static Logger logger = LoggerFactory.getLogger(YmlConfigCache.class); 
	
	public static final Map<String, YmlConfigStore> ymlConfigLocalCache = new ConcurrentHashMap<String, YmlConfigStore>();

	
	public static void set(String key,YmlConfigStore ymlConfigStore){
		ymlConfigLocalCache.put("ymlConfigStore", ymlConfigStore);
	}
	
	public static BaseYml get(String fileName){
		YmlConfigStore ymlConfigStore = ymlConfigLocalCache.get("ymlConfigStore");
		BaseYml baseYml = new BaseYml();
		if(ymlConfigStore==null){
			try {
				if(fileName == null){
					fileName = "commonConfig.yml";
				}
				YmlConfigStore yml = new YmlConfigStore();
				baseYml = YmlUtil.getObjValue(fileName, BaseYml.class);
				yml.setBaseYml(baseYml);
				ymlConfigLocalCache.put("ymlConfigStore", yml);
			} catch (Exception e) {
				logger.info("YmlConfigCache getObjValue  failed.",e);
			}
		}else{
			baseYml = ymlConfigStore.getBaseYml();
		}
		return baseYml;
	}
	
	public static void main(String[] args) {
		Map<String, List<String>> map =  get(null).getInterceptor();
		for(Map.Entry<String, List<String>> entry:map.entrySet()) {
			System.out.println(entry.getKey()+"-------"+entry.getValue());
		}
		
		
	}
	
	
}
