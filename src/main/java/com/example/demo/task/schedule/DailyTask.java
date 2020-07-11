package com.example.demo.task.schedule;

import com.example.demo.base.FundProperties;
import com.example.demo.model.FundDetails;
import com.example.demo.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * created by zhenzhong on 2020/6/23
 */
@Component
public class DailyTask
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FundProperties fundPropertie;

    @Scheduled(cron = "0 0 15 0 0 0 ?")
    public void dailyFundData() throws Exception
    {
        String fundDetailUrl = fundPropertie.getFundDetailUrl();


        String                   fundUrl    = fundPropertie.getFundUrl();
        final ArrayList<Integer> fundIdList = fundPropertie.getFundIdList();
        for (Integer integer : fundIdList)
        {


            final ResponseEntity<String> responseEntity = restTemplate.getForEntity(fundDetailUrl, String.class);
            // jsonpgz({"fundcode":"161030","name":"富国中证体育产业指数分级","jzrq":"2020-06-22","dwjz":"1.0890","gsz":"1.1249",
            // "gszzl":"3.30","gztime":"2020-06-23 15:00"});
            String body  = responseEntity.getBody();
            int    first = body.indexOf("(");
            int    last  = body.lastIndexOf(")");
            body = body.substring(first + 1, last);
            final FundDetails fundDetails = JacksonUtils.json2pojo(body, FundDetails.class);

        }

        //当前策略：每周定投1000，分成周，两周，三周，一个月，两个月的收益。分别设置在10个选定的基金上。
        //优选策略：根据一个月之前的。每周，每个月，每三个月，每6个月绩效最好的10只基金进行购买的收益。
        //1.
    }
}
