package com.lzg.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Table  声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe)
 * @Entity  表明该类 (UserEntity) 为一个实体类
 */
@Entity
@Table(name = "t_user")
public class User {

    /**
     * @javax.persistence.Id 标注为唯一标识
     * @GeneratedValue 一个实体生成一个唯一标识的主键
     */
    @Id
    @GeneratedValue
    private Long id;
    // 昵称
    private String nickname;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 头像
    private String avatar;
    // 类型
    private Integer type;
    /**
     * @Temporal(TemporalType.TIMESTAMP) 转换日期格式
     */
    // 创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    // 更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;



    /**
     *  @ManyToOne 多对一
     *  @ManyToMany 多对多
     *  @OneToMany 一对多
     */
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();


    /**
     * 无参构造及参数封装
     */
    public User() {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
