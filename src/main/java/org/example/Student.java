package org.example;

public class Student extends Human
//TODO:Создайте класс Student, производный от Human,
// новое поле — название факультета, к нему геттер, сеттер и конструктор.
{
    String nameFaculty;
    public Student(String first_name, String second_name, String last_name, int age, String nameFaculty) {
        super(first_name, second_name, last_name, age);
        this.nameFaculty = nameFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }
}
