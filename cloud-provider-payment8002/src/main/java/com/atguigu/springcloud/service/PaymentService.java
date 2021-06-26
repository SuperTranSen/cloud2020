package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author Transen
 * @version 1.0
 * @date 2021-04-01 20:09
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
