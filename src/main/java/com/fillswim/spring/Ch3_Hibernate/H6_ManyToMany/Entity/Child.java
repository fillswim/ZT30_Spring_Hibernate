package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private int Id;
    private String firstName;
    private int age;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(
            // Название таблицы для связи
            name = "child_section",
            // С помощью какого столбца таблица Child связывается с таблицей JoinTable
            joinColumns = @JoinColumn(name = "child_id"),
            // С помощью какого столбца таблица Section связывается с таблицей JoinTable
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public Child() {
    }

    public Child(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }

        sections.add(section);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
