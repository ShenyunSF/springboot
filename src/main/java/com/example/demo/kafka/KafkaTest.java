package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by zhenzhong on 2020/7/15
 */
@RestController("/kafka")
@Slf4j
public class KafkaTest
{
    @Autowired
    private KafkaTemplate<String, String> template;

    @GetMapping("/send")
    public void sendFoo(String input)
    {
        final ListenableFuture<SendResult<String, String>> response_ = this.template.send("test0811 ", input);
        if (response_.isDone())
        {
            System.out.println("success");
        }
    }

    @KafkaListener(id = "webGroup", topics = "test0811")
    public void listen(String input)
    {
        log.info("input value: {}", input);
    }
}
