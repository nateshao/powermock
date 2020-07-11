package com.nateshao.verify;

import com.nateshao.common.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 13:00
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void saveOrUpdate() throws Exception {
        User user = PowerMockito.mock(User.class);
        UserDao UseDao = PowerMockito.mock(UserDao.class);

        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(null);
        PowerMockito.when(UseDao.getCount(user)).thenReturn(0);
        UserService userService = new UserService();
        userService.saveOrUpdate(user);
    }
}