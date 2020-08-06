package com.lzg.vo;

/**
 * @PACKAGE_NAME: com.lzg.vo
 * @NAME: BlogQuery
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 16:16
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 16
 * @MINUTE: 16
 * @PROJECT_NAME: blog
 **/
public class BlogQuery {

    private  String title;
    private Long typeId;
    private boolean recommend;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
