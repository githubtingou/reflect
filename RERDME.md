# 反射

## 1.什么是反射

- java反射的机制核心是在程序运行是动态加载并获取类的详细信息，从而操作类或类对象的属性和方法。本质是JVM得到class对象之后，在通过class对象进行反编译，从而获取对象的各种信息。
- java属于边编译在运行的语言，程序中的对象的类型在程序编译期就已经确定下来了，而当程序还在运行时可能需要动态的加载某些类，这些类之前用不到，所以没有被加载到JVM中。通过反射，可以动态的创建对象并调用其属性，不需要提前在编译期知道运行的对象是谁。

## 2.反射的原理

![类加载流程图](https://raw.githubusercontent.com/githubtingou/reflect/master/src/main/resources/static/image/%E7%B1%BB%E7%9A%84%E5%8A%A0%E8%BD%BD%E6%B5%81%E7%A8%8B.png)

## 3.反射的优缺点

1. 优点

   在运行时可以获得类的各种内容，进行反编译，可以创建更加灵活的代码。可以在运行是装配，无需在在组件之间就行源代码的链接，更加容易实现面相对象。

2. 缺点

   - 对类进行反编译从而消耗一定的系统资源。
   - 反射在调用方法是可以忽略权限检查，破坏类的封装行从而导致安全问题。

## 4.反射的用途

1. 反编译：.class->.java
2. 可以通过反射访问类的类型、方法、构造方法
3. 反射最重要的用途就是可以开发各种通用框架（如：spring通过xml文件配置Bean）。

## 5.反射机制常用的类

1. java.class.Class
2. java.lang.reflect.Constructor
3. java.lang.reflect.Fileld
4. java.lang.reflect.Method
5. java.lang.reflect.Modifier

## 6.反射的基本使用

1. 获得Class

   - Object->Class

     ```java
      StudentDto studentDto = new StudentDto();
      Class<? extends StudentDto> aClass = studentDto.getClass();
      System.out.println(aClass.getName());
     ```

     

   - 任何数据类型（包括基本数据类型）都有一个静态的class属性

     ```java
      Class bClass = StudentDto.class;
      System.out.println(bClass);
     ```

     

   - 通过class类的静态方法：forName(String className)(最常用)

     ```java
      Class<?> cClass = null;
      try {
          cClass = Class.forName("com.ting.learn.reflect.dto.StudentDto");
          System.out.println(cClass);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
     ```

     - 注意事项：在运行时间一个类只有有一个class文件


2. 判断是否是某个类的实例

   1. 通过	instanceof

      ```java
      if (studentDto instanceof StudentDto) {
          System.out.println("类型一致");
      }
      ```

      

   2. 通过    isIntance

      ```java
      if (StudentDto.class.isInstance(studentDto)) {
          System.out.println("类型一致");
      }
      ```

      

3. 通过反射创建实例

   - 使用class对象的newInstance()来创建Class对象对应类的实例

     ```java
     Class<?>[] interfaces = StudentDto.class.getInterfaces();
     ```

   - 先通过Class对象获取指定的Construction对象，在调用Construction对象的newInstance（）来创建对象，这种方法可以指定的构造器构造类的实例

