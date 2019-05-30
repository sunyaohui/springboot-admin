package com.hzy.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String TITLE = "api文档";
	private static final String VERSION = "1.0";
	//监控所有的url
	private static final String INTERCEPT_URL = "/.*";
	//参数:token
	private static final String HEADER_NAME = "token";
	//参数备注信息
	private static final String HEADER_DESCRIPTION = "请求头信息";
	//请求参数类型，header
	private static final String HEADER_PAR_TYPE = "header";
	//是否必填:非必填
	private static final Boolean HEADER_PAR_REQUIRED = false;
	//参数数据类型，String
	private static final String DATA_TYPE = "string";
	
	@SuppressWarnings("unchecked")
	@Bean
	public Docket api() {
		ApiSelectorBuilder asb = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo(TITLE))
				.pathMapping("/")
				.select();
		List<String> list = YmlConfigStore.getBaseYmls().getSwagger().getSwaggerFilterUrl();
		for (int i = 0; i < list.size(); i++) {
			asb.paths(Predicates.not(PathSelectors.regex(list.get(i))));
		}
		
		return asb.paths(PathSelectors.regex(INTERCEPT_URL))
			.build()
			.globalOperationParameters(parameterBuilder());
    }
	
	private List<Parameter> parameterBuilder() {
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name(HEADER_NAME)
    			.description(HEADER_DESCRIPTION)
    			.modelRef(new ModelRef(DATA_TYPE))
    			.parameterType(HEADER_PAR_TYPE)
    			.required(HEADER_PAR_REQUIRED)
    			.build();
    	 pars.add(tokenPar.build());
    	 return pars;
	}

	private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                .title(desc)
                .version(VERSION)
                .build();
    }
}