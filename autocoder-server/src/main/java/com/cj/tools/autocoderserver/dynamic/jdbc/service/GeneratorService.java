package com.cj.tools.autocoderserver.dynamic.jdbc.service;

import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.GeneratorVO;

public interface GeneratorService {
    Response generate(GeneratorVO generatorVO);
}
