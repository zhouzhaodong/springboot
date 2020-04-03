package xyz.zhouzhaodong.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import xyz.zhouzhaodong.mybatis.entity.Study;

import java.util.List;

/**
 * @author 10166815
 */
@Mapper
public interface StudyMapper {

    /**
     * 新增
     * @param name
     * @param age
     * @param address
     * @return
     */
    @Insert("insert into study (name, age, address) values (#{name}, #{age}, #{address})")
    int add(@Param("name") String name, @Param("age") int age, @Param("address") String address);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from study where id = #{id}")
    int delete(@Param("id") int id);

    /**
     * 更新
     * @param id
     * @param name
     * @param age
     * @param address
     * @return
     */
    @Update("update study set name = #{name}, age = #{age}, address = #{address} where id = #{id}")
    int update(@Param("id") int id, @Param("name") String name, @Param("age") int age, @Param("address") String address);

    /**
     * 查询一条数据
     * @param id
     * @return
     */
    @Select("select * from study where id = #{id}")
    Study findOne(@Param("id") int id);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from study")
    List<Study> findAll();

}
