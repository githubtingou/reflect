package com.ting.learn.reflect.create;

import com.alibaba.fastjson.JSON;
import com.ting.learn.reflect.dto.StudentDto;

import java.lang.reflect.*;
import java.util.Map;

/**
 * 获取calss
 *
 * @author tinf
 * @version 1.0
 * @date 2020/11/25
 */
public class GetClass {
    public static void main(String[] args) {
        //第一种方式
        StudentDto studentDto = new StudentDto();
        Class<? extends StudentDto> aClass = studentDto.getClass();
        System.out.println(aClass.getName());

        // 第二种方式
        Class bClass = StudentDto.class;
        System.out.println(bClass);

        // 第三种
        Class<?> cClass = null;
        try {
            cClass = Class.forName("com.ting.learn.reflect.dto.StudentDto");
            System.out.println(cClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (studentDto instanceof StudentDto) {
            System.out.println("类型一致");
        }

        if (StudentDto.class.isInstance(studentDto)) {
            System.out.println("类型一致");
        }

        try {
            Class<?>[] interfaces = StudentDto.class.getInterfaces();
            Class<StudentDto> studentDtoClass = StudentDto.class;
            Field age = studentDtoClass.getDeclaredField("age");

            // 获取注解
            Anno anno = age.getAnnotation(Anno.class);
            System.out.println("修改前的注解值：{}" + anno.value());
            InvocationHandler handler = Proxy.getInvocationHandler(anno);
            Field memberValues = handler.getClass().getDeclaredField("memberValues");
            memberValues.setAccessible(true);
            Type genericType = memberValues.getGenericType();
            System.out.println(genericType.getTypeName());
            genericType.getTypeName();
            Map map = (Map) memberValues.get(handler);
            map.put("value", "100");
            System.out.println("修改后的注解值：{}" + anno.value());

            //实例化
            Constructor<StudentDto> constructor = studentDtoClass.getConstructor(String.class, int.class, int.class);
            StudentDto lisi = constructor.newInstance("李四", 18, 1);

            System.out.println(JSON.toJSON(lisi));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
