package com.bharath.core.services;

import com.bharath.core.dao.PaymentDAO;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDAO dao;

    public PaymentServiceImpl(PaymentDAO dao) {
        this.dao = dao;
    }

    public PaymentDAO getDao() {
        return dao;
    }
}
