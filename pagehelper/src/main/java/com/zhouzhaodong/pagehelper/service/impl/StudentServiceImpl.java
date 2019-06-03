package com.zhouzhaodong.pagehelper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhouzhaodong.pagehelper.entity.Student;
import com.zhouzhaodong.pagehelper.mapper.StudentMapper;
import com.zhouzhaodong.pagehelper.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public Object findList(Integer pageNo, Integer pageSize) {
        IPage<Student> page = new Page<>(pageNo, pageSize);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        IPage<Student> userIPage = baseMapper.selectPage(page, wrapper);
        return userIPage;
    }

}
