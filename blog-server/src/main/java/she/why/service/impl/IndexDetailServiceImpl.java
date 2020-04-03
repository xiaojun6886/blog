package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.IndexDetailEntity;
import she.why.mapper.IndexDetailMapper;
import she.why.service.IndexDetailService;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/2.
 */
@Service
public class IndexDetailServiceImpl implements IndexDetailService {

    @Autowired
    private IndexDetailMapper indexDetailMapper;

    @Override
    public List<IndexDetailEntity> getIndexDetailEntity() {
        return indexDetailMapper.queryIndexDetail();
    }
}
