package cn.windofxy.car4sshopmanagementsystembackend.controller.UserController;

import cn.windofxy.car4sshopmanagementsystembackend.model.User.User;
import cn.windofxy.car4sshopmanagementsystembackend.service.UserService.UserLoginNameExistedException;
import cn.windofxy.car4sshopmanagementsystembackend.service.UserService.UserNotFoundOrPasswordIncorrectException;
import cn.windofxy.car4sshopmanagementsystembackend.service.UserService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Tag(name = "API接口")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "注册新用户")
    @PostMapping("/api/RegisterUser")
    public ResponseEntity<RegisterUserResponse> RegisterUser(@Valid @RequestBody RegisterUserRequest requestBody, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                RegisterUserResponse response = new RegisterUserResponse(-1, "参数错误: " + Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            userService.RegisterUser(requestBody.getUserLoginName(), requestBody.getPassword(), requestBody.getUserName());
            return new ResponseEntity<>(new RegisterUserResponse(0, "注册成功"), HttpStatus.OK);
        }
        catch (UserLoginNameExistedException e) {
            return new ResponseEntity<>(new RegisterUserResponse(-2, "用户登录名已存在"), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new RegisterUserResponse(-3, "服务器内部错误: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "用户登录")
    @PostMapping("/api/LoginUser")
    public ResponseEntity<LoginUserResponse> LoginUser(@Valid @RequestBody LoginUserRequest requestBody, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                LoginUserResponse response = new LoginUserResponse(-1, "参数错误: " + Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(), null);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            User loginUser = userService.LoginUser(requestBody.getUserLoginName(), requestBody.getPassword());
            LoginUserResponse.UserInfo userInfo = new LoginUserResponse.UserInfo(loginUser.getUserID(), loginUser.getAccessScope(), loginUser.getUserName());
            return new ResponseEntity<>(new LoginUserResponse(0, "登入成功", userInfo), HttpStatus.OK);
        }
        catch (UserNotFoundOrPasswordIncorrectException e) {
            return new ResponseEntity<>(new LoginUserResponse(-2, "用户名或密码错误", null), HttpStatus.FORBIDDEN);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new LoginUserResponse(-3, "服务器内部错误: ", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
