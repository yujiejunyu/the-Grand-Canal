package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    private Integer id;//主键
    private String title;//文章名字
    private String author;//文章作者
    private String brief;//文章简介
    private String title_photo;//照片
    private Integer date_type;//类型id
    private String video;//视频
    private String video_source;//视频简介
    private Integer collect_volume;//收藏量
    private Integer like_coult;//点赞量
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间

}
