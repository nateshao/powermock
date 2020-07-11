package com.nateshao.spy;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/10 10:14
 */
public class UserServiceTest {

    @Test
    public void testfFool() throws Exception{
//        UserServiceSpy userServiceSpy = PowerMockito.mock(UserServiceSpy.class);
//        userServiceSpy.fool();

//        UserServiceSpy spy = PowerMockito.spy(new UserServiceSpy());
//        spy.fool();  //spy:会真实去执行


        UserServiceSpy userServiceSpy = PowerMockito.spy(new UserServiceSpy());
        PowerMockito.doNothing().when(userServiceSpy).fool();
        userServiceSpy.fool();
    }
}