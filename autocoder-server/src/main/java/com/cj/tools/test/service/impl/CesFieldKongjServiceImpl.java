package com.cj.tools.service.impl;

import com.cj.tools.entity.CesFieldKongj;
import com.cj.tools.mapper.CesFieldKongjMapper;
import com.cj.tools.service.ICesFieldKongjService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cj.tools.autocoderserver.base.base.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* <p>
 *  服务实现类
 * </p>
*
* @author zhilonng
* @since 2020-10-18
*/
@Service
 public class CesFieldKongjServiceImpl extends ServiceImpl<CesFieldKongjMapper, CesFieldKongj> implements ICesFieldKongjService {

 @Autowired
 private PageUtils pageUtils;

 /**
 * 分页列表
 * @param param 根据需要进行传值
 * @return
 */
 @Override
 public IPage<CesFieldKongj> page(CesFieldKongj param) {

 QueryWrapper<CesFieldKongj> queryWrapper = new QueryWrapper<>();
 queryWrapper.lambda()
  // 主键
    .eq(!StringUtils.isEmpty(param.getId()), CesFieldKongj::getId, param.getId())
   // 创建人
    .eq(!StringUtils.isEmpty(param.getCreateBy()), CesFieldKongj::getCreateBy, param.getCreateBy())
   // 创建日期
    .eq(param.getCreateTime() != null, CesFieldKongj::getCreateTime, param.getCreateTime())
   // 更新人
    .eq(!StringUtils.isEmpty(param.getUpdateBy()), CesFieldKongj::getUpdateBy, param.getUpdateBy())
   // 更新日期
    .eq(param.getUpdateTime() != null, CesFieldKongj::getUpdateTime, param.getUpdateTime())
   // 所属部门
    .eq(!StringUtils.isEmpty(param.getSysOrgCode()), CesFieldKongj::getSysOrgCode, param.getSysOrgCode())
   // 用户名
    .eq(!StringUtils.isEmpty(param.getName()), CesFieldKongj::getName, param.getName())
   // 下拉框
    .eq(!StringUtils.isEmpty(param.getSex()), CesFieldKongj::getSex, param.getSex())
   // radio
    .eq(!StringUtils.isEmpty(param.getRadio()), CesFieldKongj::getRadio, param.getRadio())
   // checkbox
    .eq(!StringUtils.isEmpty(param.getCheckbox()), CesFieldKongj::getCheckbox, param.getCheckbox())
   // 下拉多选
    .eq(!StringUtils.isEmpty(param.getSelMut()), CesFieldKongj::getSelMut, param.getSelMut())
   // 下拉搜索
    .eq(!StringUtils.isEmpty(param.getSelSearch()), CesFieldKongj::getSelSearch, param.getSelSearch())
   // 时间
    .eq(param.getBirthday() != null, CesFieldKongj::getBirthday, param.getBirthday())
   // 图片
    .eq(!StringUtils.isEmpty(param.getPic()), CesFieldKongj::getPic, param.getPic())
   // 文件
    .eq(!StringUtils.isEmpty(param.getFiles()), CesFieldKongj::getFiles, param.getFiles())
   // markdown
    .eq(!StringUtils.isEmpty(param.getRemakr()), CesFieldKongj::getRemakr, param.getRemakr())
   // 富文本
    .eq(!StringUtils.isEmpty(param.getFuwenb()), CesFieldKongj::getFuwenb, param.getFuwenb())
   // 选择用户
    .eq(!StringUtils.isEmpty(param.getUserSel()), CesFieldKongj::getUserSel, param.getUserSel())
   // 选择部门
    .eq(!StringUtils.isEmpty(param.getDepSel()), CesFieldKongj::getDepSel, param.getDepSel())
   // DD类型
    .eq(param.getDdd() != null, CesFieldKongj::getDdd, param.getDdd())
 ;

 IPage<CesFieldKongj> page = page(pageUtils.page(), queryWrapper);

 return page;
 }

 /**
 * 详情
 * @param id
 * @return
 */
 @Override
 public CesFieldKongj info(Long id) {

 return getById(id);
 }

 /**
 * 新增
 * @param param 根据需要进行传值
 * @return
 */
 @Override
 public void add(CesFieldKongj param) {

 save(param);
 }

 /**
 * 修改
 * @param param 根据需要进行传值
 * @return
 */
 @Override
 public void modify(CesFieldKongj param) {

 updateById(param);
 }

 /**
 * 删除(单个条目)
 * @param id
 * @return
 */
 @Override
 public void remove(Long id) {
 removeById(id);
 }

 /**
 * 删除(多个条目)
 * @param ids
 * @return
 */
 @Override
 public void removes(List<Long> ids) {

 removeByIds(ids);
 }
 }
