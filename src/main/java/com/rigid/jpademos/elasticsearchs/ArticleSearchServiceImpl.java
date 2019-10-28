package com.rigid.jpademos.elasticsearchs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: CaimaoReptile
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-09-20 08:42
 */
@Service
public class ArticleSearchServiceImpl implements ArticleSearchService {

    @Autowired
    private ArticleSearchDAO articleSearchDAO;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public Long countElasticsearch() {
        return articleSearchDAO.count();
    }

    @Override
    public Iterable<ArticleSearchVO> findAllElasticsearch() {
        Iterable<ArticleSearchVO> searchVOS = articleSearchDAO.findAll();
        return searchVOS;
    }

    @Override
    public boolean deleteAllElasticsearch() {
        try {
            articleSearchDAO.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
