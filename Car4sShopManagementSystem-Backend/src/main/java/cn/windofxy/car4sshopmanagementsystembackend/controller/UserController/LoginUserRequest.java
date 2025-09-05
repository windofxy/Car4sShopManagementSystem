package cn.windofxy.car4sshopmanagementsystembackend.controller.UserController;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Schema(name = "API请求格式")
public class LoginUserRequest {
    @NotBlank(message = "用户登录名不能为空")
    @Schema(name = "用户登录名", required = true, example = "userLoginName")
    private String userLoginName;

    @NotBlank(message = "密码不能为空")
    @Schema(name = "密码", required = true, example = "password")
    private String password;
}
