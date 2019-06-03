package com.imooc.handler;

import com.imooc.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//基于注解的方式，不需要实现Controller类
//设置其为控制器
@Controller
public class AnnotationHandler {
    /**
     * 业务方法：ModelAndView完成数据的传递，视图的解析
     */

    //设置匹配的请求
    @RequestMapping("/AnnotationTest")
    public ModelAndView modelAndViewTest(){

        //创建ModelAndView对象
        //装载模型数据和逻辑视图
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("name","Jack");
        //添加逻辑视图
        modelAndView.setViewName("show");
        return modelAndView;

    }
    /**
     * 方法2：
     * 业务方法：Model传值，String进行视图解析
     */
    @RequestMapping("/ModelTest")
    public String ModelTest(Model model){
        //填充模型数据
        model.addAttribute("name","jerry");
        //设置逻辑视图
        return "show";

    }

    /**
     * 方法3：
     * 业务方法：Map传值，String进行视图解析
     */
    @RequestMapping("/MapTest")
    public String MapTest(Map<String,String> map){
        //填充模型数据
        map.put("name","cat");
        //设置逻辑视图
        return "show";

    }

    /**
     * 添加商品并展示
     */
    @RequestMapping("/addGoods")
    public ModelAndView addGoods(Goods goods){
        System.out.println(goods.getName()+"---"+goods.getPrice());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("goods",goods);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
