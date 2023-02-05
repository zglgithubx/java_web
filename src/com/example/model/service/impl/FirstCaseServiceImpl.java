package com.example.model.service.impl;
import com.example.model.dao.FirstCaseDao;
import com.example.model.dao.UserDao;
import com.example.model.dao.impl.FirstCaseDaoImpl;
import com.example.model.dao.impl.UserDaoImpl;
import com.example.model.domain.FirstCase;
import com.example.model.domain.PageBean;
import com.example.model.domain.User;
import com.example.model.service.FirstCaseService;
import java.util.List;
import java.util.Map;

public class FirstCaseServiceImpl implements FirstCaseService {
    private FirstCaseDao firstCaseDao=new FirstCaseDaoImpl();
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<FirstCase> findALl() {
//        调用dao
        return firstCaseDao.findAll();
    }
    @Override
    public User login(User ser){
        return userDao.login(ser);
    }
    @Override
    public void add(FirstCase firstCase){
        firstCaseDao.add(firstCase);
    }
    @Override
    public void delete(String id){
        firstCaseDao.delete(id);
    }


    @Override
    public FirstCase findOne(String id) {
        return firstCaseDao.findOne(id);
    }

    @Override
    public void update(FirstCase firstCase) {
        firstCaseDao.update(firstCase);
    }
    @Override
    public PageBean<FirstCase> pageQuery(String current_Page, String ro_ws, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(current_Page);
        int rows=Integer.parseInt(ro_ws);
        if(currentPage<=0){
            currentPage=1;
        }
        PageBean<FirstCase> pb=new PageBean<FirstCase>();

        int totalCount=firstCaseDao.findTotalCount(condition);
        int start=(currentPage-1)*rows;
        int totalPage=totalCount%rows==0 ? totalCount/rows : totalCount/rows+1;
        if(currentPage>=totalPage){
            currentPage=totalPage;
        }
        pb.setTotalCount(totalCount);
        pb.setList(firstCaseDao.pageQuery(start,rows,condition));
        pb.setTotalPage(totalPage);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }
}
