package com.example.model.service.impl;

import com.example.model.dao.ProvinceDao;
import com.example.model.dao.impl.ProvinceDaoImpl;
import com.example.model.domain.Province;
import com.example.model.service.ProvinceService;
import com.example.model.util.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAllProvince() {
        return provinceDao.findAllProvince();
    }

    /**
     * redis缓存的使用
     * @return
     */
    @Override
    public String findJson() {
//        1.先从redis数据库查询数据
//        1.1获取redis客户端连接
        Jedis jedis=JedisPoolUtils.getJedis();

        String prince_json=jedis.get("province");
        System.out.println(prince_json);
//        2.判断province_json数据是否为null
        if(prince_json==null||prince_json.length()==0){
            //redis中没有说数据
            System.out.println("redis no data ...");
            //从数据库中查询
            List<Province> ps=provinceDao.findAllProvince();
            ObjectMapper mapper=new ObjectMapper();
            try {
                prince_json=mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",prince_json);
            jedis.close();
        }else{
            System.out.println("redis have data");
        }
        return prince_json;
    }
}
