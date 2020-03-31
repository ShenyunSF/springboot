package com.example.demo.test.templatetest;

import com.example.demo.bean.Alert;
import com.example.demo.bean.AlertConfig;
import com.example.demo.bean.Plugin;
import com.example.demo.bean.Template;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

/**
 * created by zhenzhong on 2019/12/5
 */
public class TemplateClassify
{
    @Test
    public void testTemplate()
    {
        Template template = new Template();
        template.setTemplateId(genUUID());
        template.setTemplateName("template_test_01");
        template.setScopeName("scope_01");
        template.setServiceName("service_01");
        template.setType("monitor");
        template.setStatus("new");

        Plugin plugin01 = new Plugin();
        plugin01.setId(0);
        plugin01.setPluginName("server_test");
        plugin01.setInstance(false);
        HashMap<String, Object> parmas = new HashMap<>();
        parmas.put("cpu", "max");
        plugin01.setRuntime(object2json(parmas));
        plugin01.setMetrics(Arrays.asList("cpu"));

        Plugin plugin2 = new Plugin();
        plugin2.setId(22);
        plugin2.setPluginName("file_monitor");
        plugin2.setInstance(true);
        HashMap<String, Object> parmas02 = new HashMap<>();
        parmas02.put("_file_path", "/etc/hosts/host");
        plugin2.setRuntime(object2json(parmas02));
        plugin2.setMetrics(Arrays.asList("size", "count"));

        template.setPlugins(Arrays.asList(plugin01, plugin2));

        Alert alert = new Alert();
        alert.setPluginName("server_test");
        alert.setInstance(object2json(parmas02));
        alert.setMetricName("cpu");
        alert.setMetricUnit("m");
        AlertConfig alertConfig = new AlertConfig();
        alertConfig.setAlertName("mem is over {$limit}");
        alertConfig.setDuration(60);
        alertConfig.setLevel("notice");
        alertConfig.setLowerLimitValue("30");
        alertConfig.setUpperLimitValue("40");
        alertConfig.setTimeUnit("m");
        alertConfig.setLogic("in");
        alert.setAlertConfig(alertConfig);

        Alert alert02 = new Alert();
        alert02.setPluginName("file_monitor");
        alert02.setInstance(object2json(parmas02));
        alert02.setMetricName("exit");
        alert02.setMetricUnit("m");
        AlertConfig alertConfig02 = new AlertConfig();
        alertConfig02.setAlertName("${file} is not exit");
        alertConfig02.setDuration(60);
        alertConfig02.setLevel("notice");
        alertConfig02.setLowerLimitValue("0");
        alertConfig02.setUpperLimitValue("0");
        alertConfig02.setTimeUnit("m");
        alertConfig02.setLogic("in");
        alert02.setAlertConfig(alertConfig02);

        Alert alert03 = new Alert();
        alert03.setPluginName("file_monitor");
        alert03.setInstance(object2json(parmas02));
        alert03.setMetricName("size");
        alert03.setMetricUnit("m");
        AlertConfig alertConfig03 = new AlertConfig();
        alertConfig03.setAlertName("${file} size too large");
        alertConfig03.setDuration(60);
        alertConfig03.setLevel("major");
        alertConfig03.setLowerLimitValue("30");
        alertConfig03.setUpperLimitValue("40");
        alertConfig03.setTimeUnit("m");
        alertConfig03.setLogic("in");
        alert03.setAlertConfig(alertConfig03);

        template.setAlerts(Arrays.asList(alert, alert02, alert03));

        String s = object2json(template);
        System.out.println(s);

    }

    @Test
    public void doTest() throws IOException
    {
        String path = this.getClass().getResource("/templatejson.json").getPath();
        System.out.println(path);
        String s = readClassPathFile(path);
        System.out.println(s);
        Template template = json2Obj(s, Template.class);
     /*   Template template = objectMapper.readValue(s, Template.class);*/
        System.out.println(template);
    }

    public String readClassPathFile(String filePath)
    {
        File   file = new File(filePath);
        String s    = null;
        try
        {
            s = FileUtils.readFileToString(file, "UTF-8");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return s;
    }

    private String genUUID()
    {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String object2json(Object obj)
    {
        try
        {
            String asString = objectMapper.writeValueAsString(obj);
            return asString;
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T json2Obj(String s, Class<T> clazz)
    {
        try
        {
            T t = objectMapper.readValue(s, clazz);
            return t;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
