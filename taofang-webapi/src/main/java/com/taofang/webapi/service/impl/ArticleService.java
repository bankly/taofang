package com.taofang.webapi.service.impl;

import com.taofang.webapi.dao.ArticleMapper;
import com.taofang.webapi.dao.DtsimageMapper;
import com.taofang.webapi.domain.*;
import com.taofang.webapi.model.ArticleWithBLOBs;
import com.taofang.webapi.model.Dtsimage;
import com.taofang.webapi.service.IArticleService;
import com.taofang.webapi.util.ArticleModelUtil;
import com.taofang.webapi.util.DatetimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-05-18
 */
@Service
public class ArticleService implements IArticleService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private DtsimageMapper dtsimageMapper;

    @Override
    public ArticlePaginationDomain getArticlePaginationDomain(int categoryId, int page, int pageSize) {
        List<ArticleDomain> articleDomainList;
        PaginationDomain pagination;
        try{
            int totalCount = articleMapper.countByCategory(categoryId);
            pagination = new PaginationDomain(page, pageSize, totalCount);
            int start = (page - 1) * pageSize;
            List<ArticleWithBLOBs> articleWithBLOBList = articleMapper.selectByCategoryLimit(categoryId, start, pageSize);
            articleDomainList = ArticleModelUtil.tranArticleWithBLOBsList(articleWithBLOBList);
        }catch(Exception e){
            pagination = new PaginationDomain(page, pageSize);
            articleDomainList = new ArrayList<>();
            LOGGER.error(e.getMessage(), e);
        }
        return new ArticlePaginationDomain(pagination, articleDomainList);
    }

    @Override
    public RitucharyaPaginationDomain getRitucharyaPaginationDomain(int ritucharya, int page, int pageSize) {
        List<RitucharyaDomain> ritucharyaList;
        PaginationDomain pagination;
        try{
            int totalCount = dtsimageMapper.countByCategory(ritucharya);
            pagination = new PaginationDomain(page, pageSize, totalCount);
            int start = (page - 1) * pageSize;
            List<Dtsimage> dtsimageList = dtsimageMapper.selectByCategoryPagination(ritucharya, start, pageSize);
            ritucharyaList = ArticleModelUtil.tranDtsimageList(dtsimageList);
        }catch(Exception e){
            pagination = new PaginationDomain(page, pageSize);
            ritucharyaList = new ArrayList<>();
            LOGGER.error(e.getMessage(), e);
        }

        return new RitucharyaPaginationDomain(pagination, ritucharyaList);
    }

    @Override
    public ArticlePaginationDomain getJKZSPaginationDomain(String queryDateStr, int page, int pageSize) {
        List<ArticleDomain> articleDomainList;
        PaginationDomain pagination;
        try{
            Timestamp beginTime = DatetimeUtil.tranDatetimeStr(queryDateStr + "000000", DatetimeUtil.FORMAT_DEFAULT_YMD_MIN);
            Timestamp endTime = DatetimeUtil.tranDatetimeStr(queryDateStr + "235959", DatetimeUtil.FORMAT_DEFAULT_YMD_MIN);
            int totalCount = articleMapper.countJKZSByVideodate(beginTime, endTime);
            pagination = new PaginationDomain(page, pageSize, totalCount);
            int start = (page - 1) * pageSize;
            List<ArticleWithBLOBs> articleWithBLOBsList = articleMapper.selectJKZSByVideodate(beginTime, endTime, start, pageSize);
            articleDomainList = ArticleModelUtil.tranArticleWithBLOBsList(articleWithBLOBsList);
        }catch(Exception e){
            pagination = new PaginationDomain(page, pageSize);
            articleDomainList = new ArrayList<>();
            LOGGER.error(e.getMessage(), e);
        }
        return new ArticlePaginationDomain(pagination, articleDomainList);
    }
}
