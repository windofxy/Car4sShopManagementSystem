package cn.windofxy.car4sshopmanagementsystembackend.model.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "数据库字段")
public class User {
    @Schema(name = "用户ID", required = true, example = "1")
    private int userID;
    @Schema(name = "登录用户名", required = true, example = "userLoginName")
    private String userLoginName;
    @Schema(name = "登录密码", required = true, example = "password")
    private String password;
    @Schema(name = "用户昵称", required = true, example = "This is a nickname")
    private String userName;
    @Schema(name = "用户权限范围", required = true, example = "0")
    private int accessScope;
}