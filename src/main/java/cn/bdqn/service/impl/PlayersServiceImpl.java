package cn.bdqn.service.impl;

import cn.bdqn.dao.PlayersMapper;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.Players;
import cn.bdqn.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {
    @Autowired
    private PlayersMapper playersMapper;
    @Override
    public PageBean<Players> playersList(String pname, Integer cid, Integer currPageNo, Integer pageSize) {
        PageBean<Players> pageBean=new PageBean<Players>();
        pageBean.setCurrPageNo(currPageNo);
        int totalCount=playersMapper.findCount(pname, cid);
        pageBean.setTotalCount(totalCount);
        int totalPageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        pageBean.setTotalPageCount(totalPageCount);
        List<Players> list=playersMapper.playersList(pname,cid,(currPageNo-1)*2,pageSize);
        pageBean.setListc(list);
        return pageBean;
    }

    @Override
    public int findCount(String pname, Integer cid) {
        return playersMapper.findCount(pname, cid);
    }

    @Override
    public int add(Players players) {
        return playersMapper.add(players);
    }

    @Override
    public int delete(Integer pid) {
        return playersMapper.delete(pid);
    }
}
