package org.vectorcontroller.baseframework.service.right.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.vectorcontroller.baseframework.mapper.right.SysUserMapper;
import org.vectorcontroller.baseframework.pojo.po.right.SysUser;
import org.vectorcontroller.baseframework.service.right.ISysUerService;

@Service
public class SysUerServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUerService {
}
