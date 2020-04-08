package com.example.demo.java8.steam.comparator;

import org.apache.tomcat.jni.Address;

/**
 * created by zhenzhong on 2020/4/6
 */
public class Student implements Comparable<Student>
{
    private int id;

    private int age;

    private String name;

    private String address;

    public Student(int id, int age, String name, String address)
    {
        this.id      = id;
        this.age     = age;
        this.name    = name;
        this.address = address;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Student [id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + "]";
    }


    @Override
    public int compareTo(Student o)
    {
        return this.id - o.id;
    }
}
