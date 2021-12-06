package com.mosh.forum.service.impl;

import com.mosh.forum.entity.Label;
import com.mosh.forum.mapper.LabelMapper;
import com.mosh.forum.service.LabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛标签 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-20
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {

}
