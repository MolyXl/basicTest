package spring.aop;

import aspect.Radar;
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
    @Radar(value = {"扫描到","准备打击"})
    public Map add(@RequestBody Map userInfo) {
        return userInfo;
    }

}
