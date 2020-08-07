package com.lzg.service;

import com.lzg.po.Comment;

import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.service
 * @NAME: CommentService
 * @USER: 86185
 * @DATE: 2020/8/5
 * @TIME: 10:43
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 05
 * @DAY_NAME_SHORT: 周三
 * @DAY_NAME_FULL: 星期三
 * @HOUR: 10
 * @MINUTE: 43
 * @PROJECT_NAME: blog
 **/
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);





}
