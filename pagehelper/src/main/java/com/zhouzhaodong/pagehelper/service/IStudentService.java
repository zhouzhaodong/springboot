package com.zhouzhaodong.pagehelper.service;

import com.zhouzhaodong.pagehelper.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-06-03
 */
public interface IStudentService extends IService<Student> {

    Object findList(Integer pageNo, Integer pageSize);

}
