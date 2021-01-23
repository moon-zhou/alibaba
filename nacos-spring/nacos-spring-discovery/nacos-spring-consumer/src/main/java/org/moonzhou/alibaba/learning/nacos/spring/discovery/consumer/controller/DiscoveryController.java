package org.moonzhou.alibaba.learning.nacos.spring.discovery.consumer.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("discovery")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    /**
     * http://localhost:8090/nacos_spring_consumer_war/discovery/get?serviceName=moon-provider-nacos-spring
     * @param serviceName
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    /**
     * http://localhost:8090/nacos_spring_consumer_war/discovery/getService?serviceName=moon-provider-nacos-spring
     * @param serviceName
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/getService", method = GET)
    @ResponseBody
    public String getService(@RequestParam String serviceName) throws NacosException {
        // 根据服务名从注册中心获取一个健康的服务实例
        Instance instance = namingService.selectOneHealthyInstance(serviceName);

        // 这里只是为了方便才新建RestTemplate实例
        // 不够简洁，如果在SpringCloud体系中，结合Feign客户端则可以省略这些模板代码。
        RestTemplate template = new RestTemplate();

        // 此示例编写时，加了启动的上下文
        String url = String.format("http://%s:%d/%s/service/hello?name=moonzhou", instance.getIp(), instance.getPort(), "nacos_spring_provider_war");
        String result = template.getForObject(url, String.class);

        System.out.println(result);

        return result;
    }
}
