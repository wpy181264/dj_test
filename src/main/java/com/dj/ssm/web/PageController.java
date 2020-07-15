package com.dj.ssm.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.ssm.domain.ResultModel;
import com.dj.ssm.domain.User;
import com.dj.ssm.domain.UserQuery;
import com.dj.ssm.domain.UserVO;
import com.dj.ssm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Mybatis-Plus 分页操作
 */
@RestController
public class PageController {

    @Autowired
    private UserService userService;

    /**
     * 单表分页
     *
     * @return
     */
    @RequestMapping("/list/page1")
    public ResultModel page1(Integer pageNo, Integer pageSize) {
        try {
            // 分页插件的实现原理 SQL拦截器
            IPage<User> page = new Page<>(pageNo, pageSize);// 当前页,每页条数
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sex", "1");
            // 无查询条件可以直接使用 .page(page);
            IPage<User> pageInfo = userService.page(page, queryWrapper);
            System.out.println(pageInfo.getPages());// 总页数
            System.out.println(pageInfo.getRecords());// 数据结果
            System.out.println(pageInfo.getTotal());// 总条数
            return new ResultModel().success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 自定义分页查询
     *
     * @param query
     * @return
     */
    @RequestMapping("/list/page2")
    public ResultModel page2(UserQuery query) {
        try {
            List<UserVO> userVoList = userService.page2(query);
            return new ResultModel().success(userVoList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

}
