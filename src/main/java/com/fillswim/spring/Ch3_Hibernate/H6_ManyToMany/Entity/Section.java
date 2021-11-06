package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {

    @Id
    @GeneratedValue
    int Id;
    private String name;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(
            // Название таблицы для связи
            name = "child_section",
            // С помощью какого столбца таблица Child связывается с таблицей JoinTable
            joinColumns = @JoinColumn(name = "section_id"),
            // С помощью какого столбца таблица Section связывается с таблицей JoinTable
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> children;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public void addChildToSection(Child child) {
        if (children == null) {
            children = new ArrayList<>();
        }

        children.add(child);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
