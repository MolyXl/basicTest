package spring.spring_aop;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author MaZhuli
 * @description 测试Controller
 * @date 2019/7/4
 */
@RequestMapping("/test")

public class TestController {
    @RequestMapping("add")
    @Encrypt
    public Map add(@RequestBody Map userInfo) {
        return userInfo;
    }

}
