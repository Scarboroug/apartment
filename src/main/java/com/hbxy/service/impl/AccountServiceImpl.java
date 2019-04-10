package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.AccountService;
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
public class AccountServiceImpl implements AccountService {
    @Autowired
    private DaoSupport dao;

    @Override
    public List<PageData> findlistPage(Page page) throws Exception
    {
        return (List<PageData>) dao.findForList("AccountMapper.findlistPage", page);
    }

    @Override
    public PageData findById(PageData pd) throws Exception
    {
        return (PageData) dao.findForObject("AccountMapper.findById", pd);
    }

    @Override
    public void updateById(PageData pd) throws Exception
    {
        dao.findForObject("AccountMapper.updateById", pd);
    }

    @Override
    public void save(PageData pd) throws Exception
    {
        dao.findForObject("AccountMapper.save", pd);
    }

    @Override
    public void removeAll(int[] ids) throws Exception
    {
        dao.findForObject("AccountMapper.removeAll", ids);
    }

    @Override
    public List<PageData> findAllLogin(PageData pd) throws Exception
    {
        return (List<PageData>) dao.findForList("DataEntryMapper.findAllLogin", pd);
    }
}
