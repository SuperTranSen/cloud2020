package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author Transen
 * @version 1.0
 * @date 2021-04-01 20:12
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int i = paymentService.create(payment);
        log.info("*****插入结果" + i);

        if (i > 0) {
            return new CommonResult<>(200, "插入结果成功,serverPort  " + serverPort, i);
        } else {
            return new CommonResult<>(400, "插入结果失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果" + payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort  " + serverPort, payment);
        } else {
            return new CommonResult<>(400, "没有对应记录，查询id" + id, null);
        }
    }
}
