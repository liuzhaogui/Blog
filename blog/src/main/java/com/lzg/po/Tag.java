package com.lzg.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Table  声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe)
 * @Entity  表明该类 (UserEntity) 为一个实体类
 */
@Entity
@Table(name = "t_tag")
public class Tag {

    /**
     * @javax.persistence.Id 标注为唯一标识
     * @GeneratedValue 一个实体生成一个唯一标识的主键
     */
    @Id
    @GeneratedValue
    private Long id;
    private String name;


    /**
     *  @ManyToOne 多对一
     *  @ManyToMany 多对多
     *  @OneToMany 一对多
     */
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

    public Tag() {
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
