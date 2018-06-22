package com.example.demo.com.example.demo.dao;

import com.example.demo.com.example.demo.config.GuavaCache;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tiwenning on 18-6-12.
 */
@Service
public class UsrInfoDao {

    @GuavaCache
    public List<String> getUSer(int i){

        List<String> list= ImmutableList.of("111","2");
        return list;
    }
}
