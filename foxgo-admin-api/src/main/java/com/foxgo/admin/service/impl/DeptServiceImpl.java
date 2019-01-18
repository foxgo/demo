package com.foxgo.admin.service.impl;

import com.foxgo.admin.entity.Dept;
import com.foxgo.admin.mapper.DeptMapper;
import com.foxgo.admin.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
