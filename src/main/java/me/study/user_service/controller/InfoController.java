package me.study.user_service.controller;


import me.study.user_service.model.Payment;
import me.study.user_service.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping
    public Payment[] getAllPaymentsByUserId(@RequestParam Long userId) {
        return infoService.getAllPaymentsByUserId(userId);
    }

}
