package cn.windofxy.car4sshopmanagementsystembackend.service.UserService;

import cn.windofxy.car4sshopmanagementsystembackend.mapper.UserMapper;
import cn.windofxy.car4sshopmanagementsystembackend.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;
import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User RegisterUser(String userLoginName, String password, String userName) throws UncategorizedSQLException, UserLoginNameExistedException {
        try {
            int userID = userMapper.Insert(userLoginName, password, userName);
            return userMapper.FindByUserID(userID);
        }
        catch (UncategorizedSQLException e) {
            SQLiteException sqLiteException = (SQLiteException) e.getCause();
            if (sqLiteException.getResultCode() == SQLiteErrorCode.SQLITE_CONSTRAINT_UNIQUE) {
                throw new UserLoginNameExistedException();
            }
            throw e;
        }
    }

    public User LoginUser(String userLoginName, String password) throws UncategorizedSQLException, UserNotFoundOrPasswordIncorrectException {
        User user = userMapper.FindByUserLoginName(userLoginName);
        if(user == null || !user.getPassword().equals(password)) {
            throw new UserNotFoundOrPasswordIncorrectException();
        }
        return user;
    }
}
