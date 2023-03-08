package EL;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName EL.User
 * @Author Xiao Mi
 * @Date 2022/12/6 09:42
 * 简介：
 */
public class User {
    private String name;
    private int age;
    private Date birthday;

    public User() {
    }

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getBirth() {
        if (birthday != null) {
            // 1. 格式化日期对象
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 2.返回字符串
            return dateFormat.format(birthday);
        } else {
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
