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

}
