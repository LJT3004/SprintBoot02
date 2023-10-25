package cn.bdqn.dao;

import cn.bdqn.pojo.Clubs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubsMapper {
    @Select("select * from clubs")
    public List<Clubs> ClubsList();
}
