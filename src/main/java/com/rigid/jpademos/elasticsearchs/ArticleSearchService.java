package com.rigid.jpademos.elasticsearchs;

public interface ArticleSearchService {
    /**
     * elasticsearch数据总数
     *
     * @return
     */
    Long countElasticsearch();

    /**
     * 查询所有数据
     *
     * @return
     */
    Iterable<ArticleSearchVO> findAllElasticsearch();

    /**
     * 删除所有数据
     *
     * @return
     */
    boolean deleteAllElasticsearch();
}
