package com.ting.learn.reflect.dto;

/**
 * 学生类
 *
 * @author ting
 * @version 1.0
 * @date 2020/11/25
 */
public class StudentDto {
    /**
     * 类型
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private int sex;

    public StudentDto() {
    }

    public StudentDto(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentDto setAge(int age) {
        this.age = age;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public StudentDto setSex(int sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
