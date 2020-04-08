package com.example.demo.java8.steam.comparator;

import org.junit.Test;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * created by zhenzhong on 2020/4/5
 */
public class LambdaComparator
{
    @Test
    public void doTest()
    {
        final List<Integer> ids = Arrays.asList(1, 2, 5, 4, 3);
        //使用lambda表达式
        Comparator<Integer> comparator1 = (a, b) -> a - b;
        //使用静态方法引用
        Comparator<Integer> comparator2 = Integer::compare;
        final List<Integer> collect     = ids.stream().sorted(comparator1).collect(Collectors.toList());
        final List<Integer> collect1    = ids.stream().sorted(comparator2).collect(Collectors.toList());

        System.out.println(ids); //[1, 2, 5, 4, 3]
        System.out.println(collect); //[1, 2, 3, 4, 5]
        System.out.println(collect1); //[1, 2, 3, 4, 5]
    }

    /*我们想实现整数list的排序，使用lambda我们还得自己编写一个Comparator对象(虽然也很简单)，实际上JDK类库已经提供了类似的实现，我们通过Integer::compare就可以引用已经存在的方法。

    JDK8中的方法引用分成4类：静态方法引用、实例方法引用、构造方法引用、以静态方式引用实例方法。*/

    //1.静态方法引用


    @FunctionalInterface
    public interface MyInterface
    {
        public double calculate(double a, double b);
    }

    @Test
    public void doTest1()
    {
        // 静态方法引用pow
        MyInterface ins1 = Math::pow;
        System.out.println(ins1.calculate(2, 4) == 16);

        //静态方法引用max
        MyInterface ins2 = Math::max;
        System.out.println(ins2.calculate(2, 4) == 4);

        // 可以看到我们定义的函数式接口MyInterface，必须要与其引用的静态方法，具有同样的返回值和入参。
    }

    // (2).实例方法引用

    @FunctionalInterface
    public interface MyInterface2
    {
        // 与String.concat()同样的入参和返回值
        public String transform(String input);
    }

    @Test
    public void doTest2()
    {
        String       content = "abc";
        MyInterface2 ins1    = content::concat;
        System.out.printf(ins1.transform("def"));
        // 可以看到我们实现的效果：定义一个函数式接口，它的方法与原始的concat拥有同样的参数类型和返回值，相当于是给concat重新命名。
    }

    // (3).构造方法引用
    public class Target
    {

        public int attr = 0;

        public Target()
        {

        }

        public Target(int b)
        {
            this.attr = b;
        }
    }

    @FunctionalInterface
    public interface MyInterface3
    {
        public Target create(int value);
    }

    @Test
    public void doTest3()
    {
        MyInterface3 ins3   = Target::new;
        final Target target = ins3.create(1);  // 可以自动推断使用的构造函数
        System.out.print(target.attr);
    }

    // 数组的构造函数与之类似，不过是构造函数有个参数(数组长度)。
    @FunctionalInterface
    public interface MyInterface4
    {
        public int[] create(int length);
    }

    @Test
    public void doTest4()
    {
        MyInterface4 ins4 = int[]::new;
        final int[]  ints = ins4.create(10);
        System.out.println(ints.length);
    }

    // (4).以静态方式引用实例方法
    public static class Target1
    {

        private int attr = 0;

        public Target1(int attr)
        {
            this.attr = attr;
        }

        public int compareTo(Target1 another)
        {
            return this.attr - another.attr;
        }

        public static int compare(Target1 one, Target1 another)
        {
            return one.attr - another.attr;
        }
    }

    // 函数式接口:实现Target对象比较
    @FunctionalInterface
    public interface MyInterface5
    {
        public int compare(Target1 one, Target1 another);
    }

    @Test
    public void doTest5()
    {
        Target1 target1 = new Target1(10);
        Target1 target2 = new Target1(100);
        //调用实例方法
        MyInterface5 ins5 = Target1::compare;
        System.out.print(ins5.compare(target1, target2));


    }
    // https://blog.csdn.net/aitangyong/article/details/54586197

    //最后给个例子，看下方法引用的威力：
    public class Person
    {
        private String name;

        private String birthday;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getBirthday()
        {
            return birthday;
        }

        public void setBirthday(String birthday)
        {
            this.birthday = birthday;
        }

        public Person(String name, String birthday)
        {
            this.name     = name;
            this.birthday = birthday;
        }

        @Override
        public String toString()
        {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", birthday='" + birthday + '\'' +
                    '}';
        }
    }

    // 如果我们相对person集合进行name排序
    // 方法1

    @Test
    public void doTest6()
    {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("c", "2017-01-01"));
        persons.add(new Person("b", "2016-01-01"));
        persons.add(new Person("a", "2015-01-01"));

        //如果我们相对persons集合进行按照name的排序
        //方式一是比较传统的做法，自己实现一个Comparator比较器。
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(persons);
    }
    @Test
    public void doTest7()
    {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("c", "2017-01-01"));
        persons.add(new Person("b", "2016-01-01"));
        persons.add(new Person("a", "2015-01-01"));
        //方式2使用了lambda表达式
        Collections.sort(persons,(o1,o2)->o1.getName().compareTo(o2.getName()));
        System.out.println(persons);
    }

    @Test
    public void doTest8()
    {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("c", "2017-01-01"));
        persons.add(new Person("b", "2016-01-01"));
        persons.add(new Person("a", "2015-01-01"));
        //方式3使用了方法引用，可以复用比较逻辑，不用自己实现Comparator。
        Collections.sort(persons,Comparator.comparing(Person::getName));
        System.out.println(persons);
    }
}
