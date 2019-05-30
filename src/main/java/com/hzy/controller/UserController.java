package com.hzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzy.controller.base.BaseController;
import com.hzy.pojo.User;
import com.hzy.pojo.page.Page;
import com.hzy.pojo.page.PageInfo;
import com.hzy.pojo.result.BaseVO;
import com.hzy.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(description = "用户管理")
@EnableSwagger2
@RestController
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "获取用户，分页")
//	@ApiResponses({
//		@ApiResponse(code = 200, message = "Successful — 请求已完成"),
//        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
//        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
//        @ApiResponse(code = 404, message = "服务器找不到给定的资源"),
//        @ApiResponse(code = 500, message = "服务器不能完成请求")
//	}) 
	@GetMapping("/user")
	public ResponseEntity<PageInfo<User>> userListPage(String search, Page page){
		String a = "a";
		log.info("----------i18N test start-------------");
		log.info(getMessage("i18n"));
		log.info("--------------i18N test end------------------------");
		if(a.equals("a")){
			return ResponseEntity.ok(userService.getSearchUserListPage(search, page));
		}else{
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@ApiOperation(value = "添加用户")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successful — 请求已完成"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源"),
        @ApiResponse(code = 500, message = "服务器不能完成请求")
	}) 
	@PostMapping("/user")
	public ResponseEntity<BaseVO>  addUser(User user){
		BaseVO baseVo = new BaseVO();
		try {
			baseVo = userService.addUser(user); 
			return ResponseEntity.ok(baseVo);
		} catch (Exception e) {
			baseVo.setSuccess(false);
	        baseVo.setMessage("failed");
	        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseVo);
		}
	}
	
	@ApiOperation(value = "删除用户")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successful — 请求已完成"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源"),
        @ApiResponse(code = 500, message = "服务器不能完成请求")
	}) 
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="path", name = "id", value = "用户ID", required = true, dataType = "String")
	})
	@DeleteMapping("user")
	public ResponseEntity<BaseVO> deleteUser(@PathVariable String id){
		BaseVO baseVo = new BaseVO();
		try {
			baseVo = userService.deleteUser(id);
			if(!baseVo.isSuccess()){
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseVo);
			}
			return ResponseEntity.ok(baseVo);
		} catch (Exception e) {
			baseVo.setSuccess(false);
	        baseVo.setMessage("删除用户信息失败");
	        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseVo);
		}
	}
	
	@ApiOperation(value = "用户修改")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successful — 请求已完成"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源"),
        @ApiResponse(code = 500, message = "服务器不能完成请求")
	}) 
	@PutMapping("/user")
	public ResponseEntity<BaseVO> updateUser(@RequestBody User user){
		BaseVO baseVo = new BaseVO();
		try {
			baseVo = userService.updateUser(user);
			if(!baseVo.isSuccess()){
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseVo);
	        }
	        return  ResponseEntity.ok(baseVo);
		} catch (Exception e) {
			baseVo.setSuccess(false);
	        baseVo.setMessage("更新用户信息失败");
	        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseVo);
		}
	}

}
