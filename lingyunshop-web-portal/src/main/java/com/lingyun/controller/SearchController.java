package com.lingyun.controller;

import com.alibaba.fastjson.JSON;
import com.lingyun.entity.TbItem;
import com.lingyun.service.TbItemService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Star
 * @version 1.0
 * @date 2020/11/4 17:49
 */
@RestController
public class SearchController {

    @DubboReference
    private TbItemService tbItemService;

    @Resource(name = "restHighLevelClient")
    private RestHighLevelClient client;

    /**
     * 添加所有数据
     * @return Result
     */
    @GetMapping("/test")
    public Result test(){
        List<TbItem> tbItems = tbItemService.queryAll(null);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (TbItem tbItem : tbItems) {
            bulkRequest.add(new IndexRequest("lingyunshop_goods").source(JSON.toJSONString(tbItem), XContentType.JSON));
        }
        try {
            BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            return ResultGenerator.genSuccessResult(!bulk.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("添加失败！");
        }
    }

    @GetMapping("/search")
    public Result search(String keyword,Integer pageNum,Integer pageSize){
        SearchRequest searchResult = new SearchRequest("lingyunshop_goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(pageNum);
        sourceBuilder.size(pageSize);
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", keyword);
        sourceBuilder.query(queryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.field("tittle");
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);
        searchResult.source(sourceBuilder);
        try {
            SearchResponse search = client.search(searchResult, RequestOptions.DEFAULT);
            ArrayList<Map<String,Object>> list = new ArrayList<>();
            for (SearchHit hit : search.getHits().getHits()) {
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField tittle = highlightFields.get("tittle");
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                if (tittle != null){
                    Text[] texts = tittle.fragments();
                    StringBuilder nTittle = new StringBuilder();
                    for (Text text : texts) {
                        nTittle.append(text);
                    }
                    sourceAsMap.put("tittle",nTittle);
                }
                list.add(sourceAsMap);
            }
            return ResultGenerator.genSuccessResult(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult();
    }
}
