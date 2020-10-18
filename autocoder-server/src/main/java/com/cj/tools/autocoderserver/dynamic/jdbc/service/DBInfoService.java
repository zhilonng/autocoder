package com.cj.tools.autocoderserver.dynamic.jdbc.service;

import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.DBSearchVO;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface DBInfoService {
    Response<PageInfo<Map>> tables(DBSearchVO dbSearchVO);
}
