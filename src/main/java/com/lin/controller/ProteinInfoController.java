package com.lin.controller;


import com.lin.entity.ProteinInfo;
import com.lin.service.ProteinInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proteinInfo")
public class ProteinInfoController {


    @Autowired
    private ProteinInfoService proteinInfoService;

    /**
     * 查询全部
     */
    @GetMapping(value="/selectAll")
    public List<ProteinInfo> findAll() {
        List<ProteinInfo> all = proteinInfoService.findAll();
        return all;
    }


    /**
     * 查询根据ID
     */
    @GetMapping("/selectByName")
    public ProteinInfo findByNameLike(@RequestParam("name") String name) {
        return proteinInfoService.findByNameLike(name);
    }

    /**
     * 添加
     */
    @PostMapping("/addProteinInfo")
    public String add(@RequestBody ProteinInfo proteinInfo) {
        return proteinInfoService.addProteinInfo(proteinInfo);
    }

    /**
     * 修改
     */
    @PutMapping("/updateProteinInfo")
    public String update(@RequestBody ProteinInfo proteinInfo) {
        return proteinInfoService.updateProteinInfo(proteinInfo);
    }


    /**
     * 删除
     */
    @DeleteMapping("/deleteProteinInfo")
    public String delete(@RequestBody ProteinInfo proteinInfo) {
        return proteinInfoService.deleteProteinInfo(proteinInfo);
    }

}
