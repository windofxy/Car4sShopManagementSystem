package cn.windofxy.car4sshopmanagementsystembackend.controller.UserController;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Schema(name = "API响应格式")
public class RegisterUserResponse {
    @Schema(name = "错误码", required = true, example = "0")
    private int errorCode;
    @Schema(name = "响应信息", required = true)
    private String message;
}
