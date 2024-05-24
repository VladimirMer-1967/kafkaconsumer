package com.merkulov.kafkaconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merkulov.kafkaconsumer.service.MessageListener;

import java.util.List;

@RestController
@RequestMapping
public class ConsumerController {

    @Autowired
    private MessageListener messageListener;

    @GetMapping(value = "/")
    public List<String> list() {
        return messageListener.getMessages();
    }
}
