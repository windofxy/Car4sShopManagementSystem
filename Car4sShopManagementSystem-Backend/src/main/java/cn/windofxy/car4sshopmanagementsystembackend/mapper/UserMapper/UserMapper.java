package cn.windofxy.car4sshopmanagementsystembackend.mapper.UserMapper;

import cn.windofxy.car4sshopmanagementsystembackend.model.User.User;
import org.apache.ibatis.annotations.*;
import org.springframework.jdbc.UncategorizedSQLException;

import javax.xml.crypto.Data;

@Mapper
public interface UserMapper {
    @Insert("insert into User (UserLoginName, Password, UserName) values (#{userLoginName}, #{password}, #{userName})")
    @Options(useGeneratedKeys = true, keyColumn = "UserID")
    int Insert (@Param("userLoginName") String userLoginName,
               @Param("password") String password,
               @Param("userName") String userName) throws UncategorizedSQLException;

    @Update("update User set UserLoginName=#{userLoginName}, Password=#{password}, UserName=#{userName}, AccessScope=#{accessScope} where UserID=#{userID}")
    void Update(Data data);

    @Results({
            @Result(property = "userID", column = "UserID"),
            @Result(property = "userLoginName", column = "UserLoginName"),
            @Result(property = "password", column = "Password"),
            @Result(property = "userName", column = "UserName"),
            @Result(property = "accessScope", column = "AccessScope")
    })
    @Select("select * from User where UserID = #{userID}")
    User FindByUserID(@Param("userID") int userID);

    @Results({
            @Result(property = "userID", column = "UserID"),
            @Result(property = "userLoginName", column = "UserLoginName"),
            @Result(property = "password", column = "Password"),
            @Result(property = "userName", column = "UserName"),
            @Result(property = "accessScope", column = "AccessScope")
    })
    @Select("select * from User where UserLoginName = #{userLoginName}")
    User FindByUserLoginName(@Param("userLoginName") String userLoginName);
}
