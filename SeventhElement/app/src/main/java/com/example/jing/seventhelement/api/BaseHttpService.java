package com.example.jing.seventhelement.api;

/**
 * 项目名称： SeventhElement
 * 创建人： Jing
 * 创建时间： 16/8/14  16:40
 * 修改备注：
 */
public interface BaseHttpService {
    @GET("tnfs/api/list")
    Call<Classify> getImageClassify(@Query("id") int id);
}
