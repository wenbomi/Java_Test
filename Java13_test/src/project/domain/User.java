package project.domain;

/**
 * @ClassName User
 * @Author Xiao Mi
 * @Date 2022/11/23 14:00
 * 第一步
 * 简介：User类 用户的实体类
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String gender;

    public void setHehe(String gender) {
        this.gender = gender;
    }
    public  String getHehe(){
        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
