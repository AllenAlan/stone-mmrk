package com.allen.stone.api.controller;

import com.allen.stone.common.result.Result;
import com.allen.stone.common.result.ResultUtil;
import com.allen.stone.domain.User;
import com.allen.stone.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/8 21:02
 **/

@RestController
@RequestMapping("/users")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
//    private UserMapper mapper;
    private UserService userService;


//    @GetMapping
//    @ApiOperation(value = "条件查询（DONE）")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
//            @ApiImplicitParam(name = "password", value = "密码", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
//    })
//    public UserDto query(String username, String password) {
//        log.info("多个参数用  @ApiImplicitParams");
//        return new UserDto(1L, username, password);
//    }
//
//    @GetMapping("/{id}")
//    @ApiOperation(value = "主键查询（DONE）")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH),
//    })
//    public User get(@PathVariable Long id) {
//        log.info("单个参数用  @ApiImplicitParam");
//        return new User(id, "u1", "p1");
//    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户（DONE）")
    public Result insert(@RequestBody User user) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        int result = userService.insert(user);
        return ResultUtil.sendBoolean(result);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（DONE）")
    public void put(@PathVariable Long id, @RequestBody User user) {
        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
    }

    @GetMapping("/format")
    public User format() {
        User user = new User();
        user.setCreateDate(LocalDateTime.now());
        return user;
    }

}
