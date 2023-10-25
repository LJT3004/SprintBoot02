package cn.bdqn.service;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.Players;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayersService {
    public PageBean<Players> playersList(String pname, Integer cid, Integer currPageNo, Integer pageSize);
    public int findCount(String pname,Integer cid);
    public int add(Players players);
    public int delete(Integer pid);
}
