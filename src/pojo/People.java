package pojo;

/**
 * @author MaZhuli
 * @description 人
 * @date 2019/6/18
 */
public class People {
    private String name;
    private Integer age;
    private int gender;

    public People() {
    }

    public People(String name, Integer age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void print(String name, int gender) {
        System.out.println(name + gender);
    }

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
