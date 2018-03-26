package science.jiangqi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Chong AiZhen on 18-3-26,下午7:20.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public void testGet(){
        //应该为JsonObject.class，此处是因为没有jar包依赖
        String string = restTemplate.getForEntity("",String.class).getBody();
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.GET)
    public void testPost(){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        JSONObject jsonObj = JSONObject.parseObject("json value");
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
        String result = restTemplate.postForObject("", formEntity, String.class);
    }
}
