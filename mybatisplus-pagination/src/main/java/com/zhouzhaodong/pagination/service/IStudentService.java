package com.zhouzhaodong.pagination.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhouzhaodong.pagination.entity.Student;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-06-04
 */
public interface IStudentService extends IService<Student> {

    Object findList(IPage<Student> page);

}
