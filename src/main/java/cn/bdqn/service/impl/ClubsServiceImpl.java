package cn.bdqn.service.impl;

import cn.bdqn.dao.ClubsMapper;
import cn.bdqn.pojo.Clubs;
import cn.bdqn.service.ClubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubsMapper clubsMapper;
    @Cacheable("clubsList")
    @Override
    public List<Clubs> clubsList() {
        return clubsMapper.ClubsList();
    }
}
