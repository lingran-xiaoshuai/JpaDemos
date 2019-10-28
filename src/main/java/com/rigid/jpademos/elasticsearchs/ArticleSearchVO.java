package com.rigid.jpademos.elasticsearchs;

import com.alibaba.fastjson.JSON;
import org.apache.catalina.webresources.TomcatJarInputStream;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;


/**
 * @tool: Created with IntelliJ IDEA
 * @program: CaimaoReptile
 * @description: @Document 作用在类，标记实体类为文档对象，一般有两个属性
 * --------------indexName：对应索引库名称
 * --------------type：对应在索引库中的类型
 * --------------shards：分片数量，默认5
 * --------------replicas：副本数量，默认1
 * @author: Rigid_Shuai
 * @create: 2019-09-19 08:45
 */
@Document(indexName = "articles_search_test", type = "sports", shards = 1, replicas = 0)
public class ArticleSearchVO implements Serializable {

    @Id
    private Integer dataId;
    @Field(type = FieldType.Integer)
    private String articleId;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String intro;
    @Field(type = FieldType.Text)
    private String content;
    @Field(type = FieldType.Text)
    private String[] tab;
    @Field(type = FieldType.Text)
    private String tag;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Text)
    private String source;
    @Field(type = FieldType.Text)
    private String sourceUrl;
    @Field(type = FieldType.Text)
    private String[] thumbnail;
    @Field(type = FieldType.Long)
    private Date publishTime;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTab() {
        return tab;
    }

    public void setTab(String[] tab) {
        this.tab = tab;
    }

    public String getTag() {
        return tag;
    }

    public String[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}


