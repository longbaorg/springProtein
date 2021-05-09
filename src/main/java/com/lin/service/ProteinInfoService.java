package com.lin.service;
import cn.hutool.core.util.IdUtil;
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


    /**
     *  增加
     * @param proteinInfo
     * @return
     */
    public String addProteinInfo(ProteinInfo proteinInfo ){
        String returns = "";

        if (proteinInfo.getName() == null || proteinInfo.getClassification() == null|| proteinInfo.getOrganism() == null|| proteinInfo.getExpressionSystem() == null
                || proteinInfo.getDeposited() == null|| proteinInfo.getDepositionAuthor() == null|| proteinInfo.getFastaSequence() == null
                || proteinInfo.getImageUrl() == null){
            returns = "新增失败";
        }else {
            String simpleUUID = IdUtil.simpleUUID();
            int i = proteinInfoRepository.addProteinInfo(
                    simpleUUID,
                    proteinInfo.getClassification(),
                    proteinInfo.getOrganism(),
                    proteinInfo.getExpressionSystem(),
                    proteinInfo.getDeposited(),
                    proteinInfo.getDepositionAuthor(),
                    proteinInfo.getFastaSequence(),
                    proteinInfo.getImageUrl(),
                    proteinInfo.getName()
            );
            if (i>0){
                returns = "新增成功";
            }else {
                returns = "新增失败";
            }
        }
        return returns;
    }


    /**
     * 修改
     * @param proteinInfo
     * @return
     */
    public String updateProteinInfo(ProteinInfo proteinInfo ){
        String returns = "";

        if (proteinInfo.getId()== null){
            returns = "传参错误，ID应必传";
        }else {
            ProteinInfo byId = proteinInfoRepository.findByProteinId(proteinInfo.getId());
            if (byId == null){
                returns = "没有该数据";
            }else {
                int i = proteinInfoRepository.updateProteinInfo(
                        proteinInfo.getClassification(),
                        proteinInfo.getOrganism(),
                        proteinInfo.getExpressionSystem(),
                        proteinInfo.getDeposited(),
                        proteinInfo.getDepositionAuthor(),
                        proteinInfo.getFastaSequence(),
                        proteinInfo.getImageUrl(),
                        proteinInfo.getName(),
                        proteinInfo.getId()
                );
                if (i>0){
                    returns = "修改成功";
                }else {
                    returns = "修改失败";
                }
            }
        }
        return returns;
    }


    /**
     * 删除
     */
    public String deleteProteinInfo(ProteinInfo proteinInfo){
        String id = proteinInfo.getId();
        String returns = "";

        if (id == null){
            returns = "缺少必穿参数ID";
        }else {
            ProteinInfo byId = proteinInfoRepository.findByProteinId(id);
            if (byId == null) {
                returns = "没有该数据";
            }else {
                int i = proteinInfoRepository.deleteProteinInfo(id);
                if (i>0){
                    returns = "删除成功";
                }else {
                    returns = "删除失败";
                }
            }
        }
        return returns;
    }


}
