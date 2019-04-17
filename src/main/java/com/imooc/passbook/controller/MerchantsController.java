package com.imooc.passbook.controller;

import com.imooc.passbook.service.IMerchantsServ;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    private final IMerchantsServ iMerchantsServ;
    public MerchantsController(IMerchantsServ iMerchantsServ) {
        this.iMerchantsServ = iMerchantsServ;
    }


    @PostMapping("/createmerchants")
    public Response CreateMerchants(@RequestBody CreateMerchantsRequest createMerchantsRequest){
        return iMerchantsServ.createMerchants(createMerchantsRequest);
    }

    @RequestMapping("/{id}")
    public Response BuildMerchantsInfo(@PathVariable("id") Integer id){
        return iMerchantsServ.buildMerchantsInfoById(id);
    }

    @RequestMapping("/dropasstemplate")
    public Response DropPassTemplate(PassTemplate passTemplate){
        return iMerchantsServ.dropPassTemplate(passTemplate);
    }

}
