package cn.windofxy.car4sshopmanagementsystembackend.controller.UserController;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Schema(name = "API响应格式")
public class LoginUserResponse {
    @Schema(name = "错误码", required = true, example = "0")
    private int errorCode;
    @Schema(name = "响应信息", required = true)
    private String message;
    @Schema(name = "用户信息", required = true, example = "114514")
    private UserInfo userInfo;

    @lombok.Data
    @AllArgsConstructor
    @Schema(name = "API响应格式")
    public static class UserInfo {
        @Schema(name = "用户ID", required = true, example = "114514")
        private int userID;
        @Schema(name = "用户权限范围", required = true, example = "0")
        private int accessScope;
        @Schema(name = "用户昵称", required = true, example = "This is a nickname")
        private String userName;
    }
}
