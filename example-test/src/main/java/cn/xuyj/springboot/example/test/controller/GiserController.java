package cn.xuyj.springboot.example.test.controller;

import cn.xuyj.springboot.example.test.domain.Giser;
import cn.xuyj.springboot.example.test.service.GiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 11:21
 */
@RestController
@RequestMapping("/giser")
public class GiserController {
    @Autowired
    GiserService service;

    @GetMapping("/{name}")
    public Giser findByName(@PathVariable(value = "name") String name) {
        return service.findByName(name);
    }

    @PostMapping("/save")
    public void saveGiser(@RequestBody Giser giser) {
        service.saveGiser(giser);
    }
}
