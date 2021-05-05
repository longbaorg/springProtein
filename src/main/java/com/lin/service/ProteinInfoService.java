package com.lin.service;
import com.lin.entity.ProteinInfo;
import com.lin.repository.ProteinInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProteinInfoService {


    @Autowired
    public ProteinInfoRepository proteinInfoRepository;


    /**
     * 查询全部
     */
    public List<ProteinInfo> findAll(){
        return proteinInfoRepository.findAll();
    }


    /**
     * 查询ById
     */
    public ProteinInfo findByNameLike(String name ){
        ProteinInfo byNameLike = proteinInfoRepository.findByNameLike(name);
        return byNameLike;
    }

}
