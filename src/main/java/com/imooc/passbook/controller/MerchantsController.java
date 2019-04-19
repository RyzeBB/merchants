package com.imooc.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.service.IMerchantsServ;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    private final IMerchantsServ iMerchantsServ;
    public MerchantsController(IMerchantsServ iMerchantsServ) {
        this.iMerchantsServ = iMerchantsServ;
    }


    @PostMapping("/createmerchants")
    public Response CreateMerchants(@RequestBody CreateMerchantsRequest createMerchantsRequest){
        log.info("CreateMerchants {}" + JSON.toJSONString(createMerchantsRequest));
        return iMerchantsServ.createMerchants(createMerchantsRequest);
    }

    @GetMapping("/{id}")
    public Response BuildMerchantsInfo(@PathVariable("id") Integer id){
        log.info("BuildMerchantsInfo {}" + JSON.toJSONString(id));
        return iMerchantsServ.buildMerchantsInfoById(id);
    }

    @PostMapping("/droppasstemplate")
    public Response DropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("DropPassTemplate {}" + JSON.toJSONString(passTemplate));
        return iMerchantsServ.dropPassTemplate(passTemplate);
    }

}
