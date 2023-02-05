package com.example.model.dao.impl;
import com.example.model.dao.FirstCaseDao;
import com.example.model.domain.FirstCase;
import com.example.model.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class FirstCaseDaoImpl implements FirstCaseDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<FirstCase> findAll() {
        String sql="select*from firstcase";
        List<FirstCase> firstCase= jdbcTemplate.query(sql,new BeanPropertyRowMapper<FirstCase>(FirstCase.class));
        return firstCase;
    }

    @Override
    public void add(FirstCase firstCase) {
        String sql="insert into firstcase values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,firstCase.getName(),firstCase.getGender(),firstCase.getAddress(),firstCase.getQq(),firstCase.getEmail());
    }

    @Override
    public void delete(String id) {
        String sql="delete from firstcase where id=?";
        jdbcTemplate.update(sql,new Long(id));
    }

    @Override
    public FirstCase findOne(String id) {
        String sql="select*from firstcase where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<FirstCase>(FirstCase.class),new Long(id));
    }
    @Override
    public void update(FirstCase firstCase) {
        String sql="update firstcase set name=?,gender=?,address=?,qq=?,email=? where id=?";
        jdbcTemplate.update(sql,firstCase.getName(),firstCase.getGender(),firstCase.getAddress(),firstCase.getQq(),firstCase.getEmail(),firstCase.getId());
    }
    @Override
    public List<FirstCase> pageQuery(int start, int rows, Map<String, String[]> condition){
        String sql="select * from firstcase where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
//        遍历msp
        Set<String> keySet=condition.keySet();
//        定义参数集合
        List<Object> params=new ArrayList<Object>();
        for(String key:keySet){
//            排除分页条件参数
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
//            获取value
            String value=condition.get(key)[0];
//            判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ?");
                params.add("%"+value+"%");//?条件的值
            }
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        sql=sb.toString();
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<FirstCase>(FirstCase.class),params.toArray());
    }
    @Override
    public int findTotalCount(Map<String, String[]> condition){
//        初始化sql
        String sql="select count(*) from firstcase where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
//        遍历msp
        Set<String> keySet=condition.keySet();
//        定义参数集合
        List<Object> params=new ArrayList<Object>();
        for(String key:keySet){
//            排除分页条件参数
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
//            获取value
            String value=condition.get(key)[0];
//            判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        return jdbcTemplate.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
}
