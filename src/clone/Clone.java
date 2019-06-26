package clone;

import pojo.People;

import java.io.*;

/**
 * @author MaZhuli
 * @description 克隆
 * @date 2019/6/26
 */
//1,实现Cloneable接口,该接口没有方法,只是标识
public class Clone implements Cloneable {
    private String name;
    private People people;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    //2,重写clone方法,必须为public,方法中调用super.clone(),即Object.clone()
    // 浅复制
    /*public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        return clone;
    }*/
    // 深复制
    public Object clone() throws CloneNotSupportedException {
        Clone clone = (Clone) super.clone();        //调用Object.clone()
        clone.setPeople((People) clone.getPeople().clone());
        return clone;

        /** //流复制实现深复制,当前对象和引用对象属性都需要需要实现序列化接口
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(bos);
         oos.writeObject(this);
         ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
         ObjectInputStream ois = new ObjectInputStream(bis);
         return ois.readObject();
         */
    }

    public static void main(String[] args) throws Exception {
        People people = new People();
        System.out.println(people);
        people.setAge(2);
        people.setName("ml");
        Clone origin = new Clone();
        origin.setName("ml");
        origin.setPeople(people);
        Clone copy = (Clone) origin.clone();
        System.out.println(copy.people);
        //浅复制,只是当前对象不同,对象的引用型属性仍是同一个
        //深复制,当前对象和引用对象的属性都不是同一个
    }
}
