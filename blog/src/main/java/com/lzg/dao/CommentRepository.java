package com.lzg.dao;

import com.lzg.po.Blog;
import com.lzg.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * @PACKAGE_NAME: com.lzg.dao
 * @NAME: CommentRepository
 * @USER: 86185
 * @DATE: 2020/8/5
 * @TIME: 10:35
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 05
 * @DAY_NAME_SHORT: 周三
 * @DAY_NAME_FULL: 星期三
 * @HOUR: 10
 * @MINUTE: 35
 * @PROJECT_NAME: blog
 **/
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

    //删除博客下的评论
    @Transactional
    @Modifying
    @Query("delete from Comment c where c.blog.id= ?1")
    int deletes(Long blogId);

}
