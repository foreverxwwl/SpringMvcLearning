package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-01 0:48
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    //查询所有产品
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
}
