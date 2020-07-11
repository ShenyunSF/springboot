package com.example.demo.java8.steam.comparator;

import com.google.common.base.Function;
import org.apache.tomcat.jni.Address;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * created by zhenzhong on 2020/4/6
 * https://blog.csdn.net/aitangyong/article/details/54880228
 */
public class LambdaCompatarator2
{
    // Stream.sort对集合进行排序，sort有2个重载方法

    //1.Stream<T>sort(); :必须实现Comparable 接口，否则会抛出异常。而且对于未排序的列表，是不稳定排序

    //2.Stream<T> sort(Comparator<? super T> comparator) 使用自定义的比较器，不要求实现Comparable 接口

    //使用实现了Comparable的 对象Student


    //stream().sorted()/Comparator.naturalOrder()/Comparator.reverseOrder()，要求元素必须实现Comparable接口。
    @Test
    public void doTestComparator()
    {
        List<Student> students = buildStudents();

        // 按照默认顺序排序
        List<Student> ascList1 = students.stream().sorted().collect(Collectors.toList());
        System.out.println(ascList1);

        // 按照自然序排序(其实就是默认顺序)
        List<Student> ascList2 = students.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(ascList2);

        // 按照默认顺序的相反顺序排序
        List<Student> descList = students.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(descList);

    }

    private static List<Student> buildStudents()
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, 20, "aty", "d"));
        students.add(new Student(1, 22, "qun", "c"));
        students.add(new Student(1, 26, "Zen", "b"));
        students.add(new Student(5, 23, "aty", "a"));
        return students;
    }

    @Test
    public void doTest2()
    {
        final List<Student> students = buildStudents();
        final Function<Student, Integer> getName = Student::getId;
        // Comparator.comparing(Function keyExtractor)
        final Comparator<Student> comparing = Comparator.comparing(getName);

        //升序
        final List<Student> collect = students.stream().sorted(comparing).collect(Collectors.toList());
        System.out.println(collect);

        //降序
        final List<Student> collect1 = students.stream().sorted(comparing.reversed()).collect(Collectors.toList());
        System.out.println(collect1);
    }
    // https://blog.csdn.net/frankenjoy123/article/details/70739800
    @Test
    public void doTest3()
    {
        final List<Student> students = buildStudents();
        final Map<Integer, Set<String>> collect = students.stream().collect(Collectors.groupingBy(Student::getId,
                Collectors.mapping(Student::getName, Collectors.toSet())));
        System.out.println(collect);

    }

    public interface  test{
        public static void test1(){
            System.out.println("test1");
        }
        default void test2(){
            System.out.println("test2");
        }
    }
    public interface test1 extends  test{

    }

}
