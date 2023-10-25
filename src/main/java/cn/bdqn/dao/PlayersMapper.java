package cn.bdqn.dao;

import cn.bdqn.pojo.Players;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlayersMapper {
    public List<Players> playersList(@Param("pname")String pname,@Param("cid")Integer cid,@Param("currPageNo")Integer currPageNo,@Param("pageSize")Integer pageSize);
    public int findCount(@Param("pname")String pname,@Param("cid")Integer cid);
    public int add(Players players);
    public int delete(int pid);
}
