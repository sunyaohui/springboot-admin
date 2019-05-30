package com.hzy.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class YmlUtil {
	
	private final static Log log = LogFactory.getLog(YmlUtil.class);
	
	public static final String COMMONYML = "commonConfig.yml";
	
    @SuppressWarnings("rawtypes")
	private static Map<String, LinkedHashMap> ymls = new HashMap<>();

    /**
     * string:当前线程需要查询的文件名
     */
    private static ThreadLocal<String> nowFileName = new ThreadLocal<>();

    /**
     * 加载配置文件
     * @param fileName
     */
    public static void loadYml(String fileName) {
    	
        nowFileName.set(fileName);
        if (!ymls.containsKey(fileName)) {
            ymls.put(fileName, new Yaml().loadAs(YmlUtil.class.getResourceAsStream("/"+ fileName), LinkedHashMap.class));
        }
    }
    
	
	/**
	 * 将指定文件里的配置转换为对象(整个文件里的所有的配置都是对象的属性)
	 * @param fileName yml文件名称
	 * @param clazz 类型
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getObjValue(String fileName,Class<T> clazz){
		try {
			Object obj = clazz.getClass();
			Map map = new Yaml().loadAs(YmlUtil.class.getResourceAsStream("/"+ fileName), LinkedHashMap.class);
			String str = JSON.toJSONString(map);
			JSONObject js = JSONObject.parseObject(str);
			obj = js.toJavaObject(clazz);
			return (T) obj;
		} catch (Exception e) {
			log.error("getObject failed",e);
			return null;
		}
	} 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getObjValue(InputStream resourceAsStream,Class<T> clazz){
		try {
			Object obj = clazz.getClass();
			Map map = new Yaml().loadAs(resourceAsStream, LinkedHashMap.class);
			String str = JSON.toJSONString(map);
			JSONObject js = JSONObject.parseObject(str);
			obj = js.toJavaObject(clazz);
			return (T) obj;
		} catch (Exception e) {
			log.error("getObject failed",e);
			return null;
		}
	} 
	
	/**
	 * 
	 * @param type 返回类型（String类型时没有默认值）
	 * @param key key值
	 * @param clazz 类型
	 * @return
//	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(String key,Class<?> clazz){
		try {
			loadYml(COMMONYML);
			return (T)getValues(key,clazz,null);
		} catch (Exception e) {
			return getReturn(clazz, null);
		}
	}
	
	/**
	 * 获取指定配置文件下的配置信息（String类型时没有默认值）
	 * @param fileName 指定文件名
	 * @param key key名
	 * @param clazz 类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(String fileName,String key,Class<?> clazz){
		try {
			loadYml(fileName);
			return (T)getValues(key,clazz,null);
		} catch (Exception e) {
			return getReturn(clazz, null);
		}
	}
	
	/**
	 * 获取公共yml文件下的配置信息（String类型时有默认值）
	 * @param key key名  必填
	 * @param clazz 类型 必填
	 * @param defaultValue 默认值 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(String key,Class<?> clazz,String defaultValue){
		try {
			loadYml(COMMONYML);
			return (T)getValues(key,clazz,defaultValue);
		} catch (Exception e) {
			return getReturn(clazz, defaultValue);
		}
	}
	
	/**
	 * 获取指定配置文件下的配置信息（String 类型时有默认值）
	 * @param fileName 文件名
	 * @param key key名
	 * @param clazz 类型
	 * @param defaultValue 默认值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(String fileName,String key,Class<?> clazz,String defaultValue){
		try {
			loadYml(fileName);
			return (T)getValues(key,clazz,defaultValue);
		} catch (Exception e) {
			return getReturn(clazz, defaultValue);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	private static <T> T getValues(String key,Class<?> clazz,String defaultValue){
		 String[] keys = key.split("[.]");
		 Map ymlInfo = (Map) ymls.get(nowFileName.get()).clone();
	     for (int i = 0; i < keys.length; i++) {
	        Object value = ymlInfo.get(keys[i]);
	        if (i < keys.length - 1) {
	            ymlInfo = (Map) value;
	        }else if(value != null) {
	            return getReturn(clazz,value);
	        }
	     }
	     return getNullReturn(clazz, defaultValue);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static <T> T getNullReturn(Class<?> clazz,String defaultValue){
		if(List.class.equals(clazz)){
			return (T) new ArrayList<>();
		}else if(Map.class.equals(clazz)){
			return (T)new HashMap<>();
		}else{
			return (T) (defaultValue==null?"":defaultValue);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T getReturn(Class<?> clazz, Object value) {
		if(String.class.equals(clazz)){
			return (T) value.toString();
		}else{
			return (T) value;
		}
	}
	
}
