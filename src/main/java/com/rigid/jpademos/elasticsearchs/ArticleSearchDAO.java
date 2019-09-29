package com.rigid.jpademos.elasticsearchs;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: CaimaoReptile
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-09-19 09:30
 */
@Component
public interface ArticleSearchDAO extends ElasticsearchRepository<ArticleSearchVO,Integer> {

}
