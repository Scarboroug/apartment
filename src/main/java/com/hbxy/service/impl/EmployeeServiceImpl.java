package com.hbxy.service.impl;

import com.hbxy.bean.Page;
import com.hbxy.dao.DaoSupport;
import com.hbxy.service.EmployeeService;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @create 2019/4/10
 * @since 1.0.0
 */
@Service
@Transactional("transactionManager")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private DaoSupport dao;

    @Override
    public void updateEmpById(PageData pd) throws Exception {
        dao.update("EmployeeMapper.updateEmpById", pd);
    }

    @Override
    public void save(PageData pd) throws Exception {
        dao.save("EmployeeMapper.insertEmployee", pd);
        dao.update("RoomMapper.updateTotalById", pd);
    }

    @Override
    public List<PageData> datalistPage(Page page) throws Exception {
        return (List<PageData>) dao.findForList("EmployeeMapper.datalistPage", page);
    }

    @Override
    public List<PageData> findAlllistPage(Page page) throws Exception {
        return (List<PageData>) dao.findForList("EmployeeMapper.findAlllistPage", page);
    }

    @Override
    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("EmployeeMapper.findById", pd);
    }

    @Override
    public void deleteById(PageData pd) throws Exception {
        dao.delete("EmployeeMapper.deleteById", pd);
    }

    @Override
    public void updateWEPayTimeById(PageData pd) throws Exception {
        dao.update("EmployeeMapper.updateWEPayTimeById", pd);
    }

}
