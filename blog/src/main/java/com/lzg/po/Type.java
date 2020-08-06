package com.lzg.po;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Table  声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe)
 * @Entity  表明该类 (UserEntity) 为一个实体类
 */
@Entity
@Table(name = "t_type")
public class Type {

    /**
     * @javax.persistence.Id 标注为唯一标识
     * @GeneratedValue 一个实体生成一个唯一标识的主键
     */
    // id
    @Id
    @GeneratedValue
    private Long id;

    /**
     *  @ManyToOne 多对一
     *  @ManyToMany 多对多
     *  @OneToMany 一对多
     */
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs =new ArrayList<>();
    // 分类名字
    /**
     * NotBlank 进行非空验证
     */
    @NotBlank(message = "分类名称不能为空,请重新输入")
    private String name;

    public Type() {
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
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
