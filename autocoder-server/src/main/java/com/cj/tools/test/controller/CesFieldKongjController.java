package com.cj.tools.controller;

import com.cj.tools.entity.CesFieldKongj;
import com.cj.tools.service.ICesFieldKongjService;
import com.cj.tools.autocoderserver.base.base.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

/**
* <p>
 *  前端控制器
 * </p>
*
* @author zhilonng
* @since 2020-10-18
*/
@Api(tags = "")
 @RestController
@RequestMapping("/ces-field-kongj")
  public class CesFieldKongjController {

 @Autowired
 private ICesFieldKongjService iCesFieldKongjService;

 @ApiOperation(value = "分页列表", response = CesFieldKongj.class)
 @ApiImplicitParams({
 @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
 @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
 @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
 @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
 @PostMapping(value = "/page")
 public  Object list(@Valid @RequestBody CesFieldKongj param) {

 Object data = iCesFieldKongjService.page(param);
 return Response.success(data);
 }

 @ApiOperation(value = "详情", response = CesFieldKongj.class)
 @GetMapping(value = "/info/{id}")
 public  Object info(@PathVariable Long id) {

 Object data = iCesFieldKongjService.info(id);
 return Response.success(data);
 }

 @ApiOperation(value = "新增")
 @PostMapping(value = "/add")
 public  Object add(@Valid @RequestBody CesFieldKongj param) {

 iCesFieldKongjService.add(param);
 return Response.success();
 }

 @ApiOperation(value = "修改")
 @PostMapping(value = "/modify")
 public  Object modify(@Valid @RequestBody CesFieldKongj param) {

 iCesFieldKongjService.modify(param);
 return Response.success();
 }

 @ApiOperation(value = "删除(单个条目)")
 @GetMapping(value = "/remove/{id}")
 public  Object remove(@PathVariable Long id) {

 iCesFieldKongjService.remove(id);
 return Response.success();
 }

 @ApiOperation(value = "删除(多个条目)")
 @PostMapping(value = "/removes")
 public  Object removes(@Valid @RequestBody List<Long> ids) {

 iCesFieldKongjService.removes(ids);
 return Response.success();
 }

 }
