package com.zhouzhaodong.pagination.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhouzhaodong.pagination.entity.Student;
import com.zhouzhaodong.pagination.mapper.StudentMapper;
import com.zhouzhaodong.pagination.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-04
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public Object findList(IPage<Student> page) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        IPage<Student> userIPage = baseMapper.selectPage(page, wrapper);
        return userIPage;
    }
}
