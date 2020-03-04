package travel.service;

import travel.domain.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 登录方法
     * @param loginUser
     * @return
     */
    User login(User loginUser);
}
