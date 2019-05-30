package com.hzy.config;

import com.hzy.localcache.YmlConfigCache;
import com.hzy.pojo.ymlVo.BaseYml;

public class YmlConfigStore {
	
	public BaseYml baseYml;
	
	public BaseYml getBaseYml() {
		return baseYml;
	}

	public void setBaseYml(BaseYml baseYml) {
		this.baseYml = baseYml;
	}
	
	public static BaseYml getBaseYmls() {
		return YmlConfigCache.get(null);
	}
	
	public static BaseYml getBaseYmls(String fileName) {
		return YmlConfigCache.get(fileName);
	}
}
