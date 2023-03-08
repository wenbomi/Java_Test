package test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName JacksonTest
 * @Author Xiao Mi
 * @Date 2023/2/22 08:56
 * 简介：
 */
public class JacksonTest {
    // java对象转为Jason对象测试
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person person = new Person("xiaomi", 23, '男', new Date());
        //2 创建Jackson的核心对象 objectMapper（）
        ObjectMapper mapper = new ObjectMapper();
        //3 转换
        /*
            1. 转换方法：
						* writeValue(参数1，obj):
		                    参数1：
		                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
		                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
		                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中

		                * writeValueAsString(obj):将对象转为json字符串
         */
        String s = mapper.writeValueAsString(person);
        System.out.println(s);

        // writeValue方式 将数据写入到/Users/miwenbo/Documents/Codes/test
//        mapper.writeValue(new File("/Users/miwenbo/Documents/Codes/test/a.txt"),person);

        // Writer： 将数据关联到Writer中
        mapper.writeValue(new FileWriter("/Users/miwenbo/Documents/Codes/test/b.txt"), person);
    }

    @Test
    public void test2() throws Exception {
        //1.创建Person对象
        Person person = new Person("xiaomi", 23, '男', new Date());
        //2 创建Jackson的核心对象 objectMapper（）
        ObjectMapper mapper = new ObjectMapper();

        // java -> json
        String value = mapper.writeValueAsString(person);
        System.out.println(value);  //{"name":"xiaomi","age":23,"gender":"男","birthday":1677029240868}

        // 排除某个属性 在类里面对某个字段加注解 @JsonIgnore
        // {"name":"xiaomi","age":23,"gender":"男"}

        // 将生日改成我们想要的格式 比如 yyyy-MM-dd 还是在类的属性上加入注解 @JsonFormat
//        {"name":"xiaomi","age":23,"gender":"男","birthday":"2023-02-22"}
    }

    @Test
    public void test3() throws Exception {
        //1.创建Person对象
        Person person = new Person("xiaomi", 23, '男', new Date());
        Person person2 = new Person("jiangjiang", 23, '男', new Date());
        Person person3 = new Person("HAHA", 23, '男', new Date());

        // 创建一个List集合
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person2);
        list.add(person3);

        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
        // [{"name":"xiaomi","age":23,"gender":"男","birthday":"2023-02-22"},{"name":"jiangjiang","age":23,"gender":"男","birthday":"2023-02-22"},{"name":"HAHA","age":23,"gender":"男","birthday":"2023-02-22"}]
    }

    @Test
    public void test4() throws Exception {
        // 创建Map对象
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","xiaomi");
        map.put("age",23);
        map.put("gender",'男');
        map.put("birthday",new Date());
        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
        // {"birthday":1677031316316,"gender":"男","name":"xiaomi","age":23}
    }
    /*
        json-->java
     */
    @Test
    public  void test5() throws Exception {
        // 初始化json字符串
        String json = "{\"name\":\"xiaomi\",\"age\":23,\"gender\":\"男\",\"birthday\":\"2023-02-22\"}";

        // 创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();

        // 转换为Java对象 person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
        // Person{name='xiaomi', age=23, gender=男, birthday=Wed Feb 22 08:00:00 CST 2023}
    }
}
