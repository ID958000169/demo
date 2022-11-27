package org.zgy.demo.springboot.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("annotation")
public class AnnotationController
{
    @RequestMapping(path = "/getMapping", method = RequestMethod.GET)
    public String getMapping()
    {
        return "hello";
    }
}
