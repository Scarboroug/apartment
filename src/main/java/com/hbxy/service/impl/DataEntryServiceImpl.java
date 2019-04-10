package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.DataEntryService;
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
public class DataEntryServiceImpl implements DataEntryService {
    @Autowired
    DaoSupport dao;

    @Override
    public void save(PageData pd) throws Exception
    {
        dao.save("DataEntryMapper.save", pd);
    }

    @Override
    public void updateById(PageData pd) throws Exception
    {
        dao.update("DataEntryMapper.updateById", pd);
    }

    @Override
    public PageData findById(PageData pd) throws Exception
    {
        return (PageData) dao.findForObject("DataEntryMapper.findById", pd);
    }

    @Override
    public List<PageData> listPage(Page page) throws Exception
    {
        return (List<PageData>) dao.findForList("DataEntryMapper.listPage", page);
    }

    @Override
    public List<PageData> updateDaysById(PageData pd) throws Exception
    {
        return (List<PageData>) dao.findForList("DataEntryMapper.updateDaysById", pd);
    }

}
