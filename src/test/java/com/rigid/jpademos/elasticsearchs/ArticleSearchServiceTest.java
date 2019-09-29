package com.rigid.jpademos.elasticsearchs;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleSearchServiceTest {
    @Autowired
    private ArticleSearchDAO articleSearchDAO;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void test() {
        Iterable<ArticleSearchVO> all = articleSearchDAO.findAll();
        for (ArticleSearchVO a : all) {
            System.out.println(a.toString());
        }
    }

    @Test
    public void test1() {
        ArticleSearchVO asv = new ArticleSearchVO();
        asv.setDataId(456);
        asv.setTitle("123");
        asv.setIntro("123");
        asv.setContent("123");
        String[] s = new String[1];
        asv.setTab(s);
        asv.setTag("123");
        asv.setAuthor("123");
        asv.setSource("123");
        asv.setSourceUrl("123");
        asv.setPublishTime(new Date());
        articleSearchDAO.save(asv);
    }


    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-09-29 9:07
     * * //        System.out.println("页数" + sampleEntities.getTotalPages());
     * * //        System.out.println("行数" + sampleEntities.getTotalElements());
     * * //        System.out.println("大小" + sampleEntities.getSize());
     * * //        System.out.println("当前第几页" + sampleEntities.getNumber());
     * * //        System.out.println("当前页的数量"+sampleEntities.getNumberOfElements());
     * * //        System.out.println("List<Book>:"+sampleEntities.getContent());
     * @Param: []
     * @return: void
     */
    @Test
    public void test2() {
        //页面初始化(lt <   gt >)
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchPhraseQuery("tab", ""));
        //刷新页面
        if (1 > 0) {
            //9.8.7.6.5.4.3.2.1  id>(gt)9
            queryBuilder.filter(QueryBuilders.rangeQuery("dataId").gt(1));
        }
        //下一页
        if (2 > 0) {
            //9.8.7.6.5.4.3.2.1  id<(lt)8.7.6.5.4.3.2.1
            queryBuilder.filter(QueryBuilders.rangeQuery("dataId").lt(2));
        }
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withSort(SortBuilders.fieldSort("dataId").order(SortOrder.DESC))
                .withPageable(PageRequest.of(0, 20));

        List<ArticleSearchVO> listSearch = elasticsearchTemplate.queryForList(searchQueryBuilder.build(), ArticleSearchVO.class);

        Page<ArticleSearchVO> queryForPage = elasticsearchTemplate.queryForPage(searchQueryBuilder.build(), ArticleSearchVO.class);


    }

    public void test3() {
        //页面初始化
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchPhraseQuery("tab", ""));
        //分页
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withSort(SortBuilders.fieldSort("publishTime").order(SortOrder.DESC))
                .withPageable(PageRequest.of(0, 20));

        Page<ArticleSearchVO> queryForPage = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), ArticleSearchVO.class);

        //System.out.println("查询的语句:" + queryForPage.getQuery().toString());
    }
}