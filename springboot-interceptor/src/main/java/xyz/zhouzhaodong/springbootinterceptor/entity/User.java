package xyz.zhouzhaodong.springbootinterceptor.entity;

/**
 * @date: 2023/2/6 12:24
 * @author: zhouzhaodong
 * @description:
 */
public class User {

    private String name;

    private Integer age;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
