package org.example;

import java.util.Objects;

public class Human
//TODO: Создайте класс Human с полями: фамилия, имя, отчество, возраст и методами:
// конструкторы, геттеры/сеттеры, equals и hashCode.
{
    String first_name, second_name, last_name;
    int age;

    public Human(String first_name, String second_name, String last_name, int age) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return getAge() == human.getAge() && Objects.equals(getFirst_name(), human.getFirst_name()) && Objects.equals(getSecond_name(), human.getSecond_name()) && Objects.equals(getLast_name(), human.getLast_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getSecond_name(), getLast_name(), getAge());
    }

    @Override
    public String toString() {
        return "Human{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                '}';
    }
}