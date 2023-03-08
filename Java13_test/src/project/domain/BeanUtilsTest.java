package project.domain;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName BeanUtilsTest
 * @Author Xiao Mi
 * @Date 2022/11/25 09:37
 * 简介：
 */

public class BeanUtilsTest {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user,"hehe","male");
        System.out.println(user);

        String gender = BeanUtils.getProperty(user, "hehe");
        System.out.println(gender);
    }
}
