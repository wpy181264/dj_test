package com.dj.ssm.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.ssm.domain.User;
import com.dj.ssm.domain.UserQuery;
import com.dj.ssm.domain.UserVO;

import java.util.List;

public interface UserService extends IService<User> {

    boolean saveUser(User user);

    List<UserVO> page2(UserQuery query);


}
