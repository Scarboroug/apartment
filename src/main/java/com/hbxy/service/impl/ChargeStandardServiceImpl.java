package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.ChargeStandardService;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Meng
 * @create 2019/4/10
 * @since 1.0.0
 */
@Service
public class ChargeStandardServiceImpl implements ChargeStandardService {

    @Autowired
    private DaoSupport dao;

    @Override
    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("ChargeStandardMapper.findById", pd);
    }

    @Override
    public void updateById(PageData pd) throws Exception {
        dao.update("ChargeStandardMapper.update", pd);
    }

    @Override
    public List<PageData> findAll(Page page) throws Exception {
        return (List<PageData>) dao.findForList("ChargeStandardMapper.findAlllistPage", page);
    }

}
