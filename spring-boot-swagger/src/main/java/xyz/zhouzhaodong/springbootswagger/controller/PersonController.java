package xyz.zhouzhaodong.springbootswagger.controller;

import com.battcn.boot.swagger.model.DataType;
import com.battcn.boot.swagger.model.ParamType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.zhouzhaodong.springbootswagger.entity.Person;
import xyz.zhouzhaodong.springbootswagger.util.ResponseBody;

import java.util.List;

/**
 * 控制器
 *
 * @author zhouzhaodong
 */
@RestController
@RequestMapping("/person")
@Api(tags = "1.0.0-SNAPSHOT", description = "用户管理", value = "用户管理")
@Slf4j
public class PersonController {

    @GetMapping
    @ApiOperation(value = "条件查询（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    public ResponseBody<Person> getByPersonName(String name) {
        log.info("多个参数用  @ApiImplicitParams");
        return ResponseBody.<Person>builder().code(200).message("操作成功").data(new Person(1, name, "JAVA")).build();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "主键查询（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
    public ResponseBody<Person> get(@PathVariable Integer id) {
        log.info("单个参数用  @ApiImplicitParam");
        return ResponseBody.<Person>builder().code(200).message("操作成功").data(new Person(id, "u1", "p1")).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户（DONE）", notes = "备注")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public void delete(@PathVariable Integer id) {
        log.info("单个参数用 ApiImplicitParam");
    }

    @PostMapping
    @ApiOperation(value = "添加用户（DONE）", notes = "备注")
    public Person post(@RequestBody Person person) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return person;
    }

    @PostMapping("/multipar")
    @ApiOperation(value = "添加用户（DONE）", notes = "备注")
    public List<Person> multipar(@RequestBody List<Person> person) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");

        return person;
    }

    @PostMapping("/array")
    @ApiOperation(value = "添加用户（DONE）", notes = "备注")
    public Person[] array(@RequestBody Person[] person) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return person;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（DONE）", notes = "备注")
    public void put(@PathVariable Long id, @RequestBody Person person) {
        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
    }
}