package com.cj.tools.service;

import com.cj.tools.entity.CesFieldKongj;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
* <p>
 *  服务类
 * </p>
*
* @author zhilonng
* @since 2020-10-18
*/
 public interface ICesFieldKongjService extends IService<CesFieldKongj> {

 /**
 * 分页列表
 * @param param 根据需要进行传值
 * @return
 */
 IPage<CesFieldKongj> page(CesFieldKongj param);

 /**
 * 详情
 * @param id
 * @return
 */
 CesFieldKongj info(Long id);

 /**
 * 新增
 * @param param 根据需要进行传值
 * @return
 */
 void add(CesFieldKongj param);

 /**
 * 修改
 * @param param 根据需要进行传值
 * @return
 */
 void modify(CesFieldKongj param);

 /**
 * 删除(单个条目)
 * @param id
 * @return
 */
 void remove(Long id);

 /**
 * 删除(多个条目)
 * @param ids
 * @return
 */
 void removes(List<Long> ids);
 }
