package com.demo.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.bean.User;
import com.demo.enumpackage.SexEnum;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lcl100
 * @create 2021-05-23 11:33
 */
public class TestMybatisPlus {

    @Test
    public void testInsert() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 创建测试实体类并封装数据
        User user = new User();
        user.setUsername("tangseng");
        user.setPassword("123456");
        user.setName("唐僧");
        user.setAge(18);
        user.setEmail("tangseng@qq.com");
        // 调用insert方法进行插入操作，返回受影响的行数
        int result = userMapper.insert(user);
        // 打印结果
        System.out.println("受影响行数：" + result);// 打印受影响行数
        System.out.println(user.getId());// 自增后的id会回填到对象中
    }

    @Test
    public void testUpdateById() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 创建要更新的字段，将主键id字段和其他要更新的字段封装在对象中
        User user = new User();
        user.setId(4L);// 待更新的主键ID
        user.setPassword("abcdef");// 更新的字段
        user.setAge(22);// 更新的字段
        // 调用updateById方法进行更新操作，返回受影响的行数
        int result = userMapper.updateById(user);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testUpdate() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 创建要更新的字段，将主键id字段和其他要更新的字段封装在对象中
        User user = new User();
        user.setPassword("abcdef");// 更新的字段
        user.setAge(22);// 更新的字段
        // 添加更新的条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("id", 6);
        // 执行更新操作
        // 第一个参数是设置SQL语句中的set后面的参数（如set username='zhangsan',age=13）
        // 第二个参数是设置SQL语句中的where后面的参数（如where id=3 and name='张三'）
        int result = userMapper.update(user, wrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testUpdate2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 设置更新的条件及更新的字段
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        // eq相当于设置where后面的条件；set相当于设置set后面的字段
        wrapper.eq("id", 6).set("password", "123456");
        // 执行更新操作
        int result = userMapper.update(null, wrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testDeleteById() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 执行删除操作
        int result = userMapper.deleteById(5L);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testDeleteByMap() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 将条件放到集合中
        Map<String, Object> columnMap = new HashMap<String, Object>();
        columnMap.put("age", "20");
        columnMap.put("name", "张三");
        // 执行多条件删除操作，多个条件之间为AND关系
        int result = userMapper.deleteByMap(columnMap);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testDelete() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 封装条件
        User user = new User();
        user.setAge(20);
        user.setId(3L);
        user.setName("李四");
        // 将实体对象进行封装，包装为操作条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>(user);
        // 执行删除操作，多个条件之间为AND关系
        int result = userMapper.delete(wrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testDeleteBatchIds() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 将要删除的id放到集合中
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(12L);
        list.add(22L);
        // 根据id集合批量删除
        int result = userMapper.deleteBatchIds(list);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testSelectById() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 根据id进行查询
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 根据id集合进行查询
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(2L);
        idList.add(3L);
        idList.add(4L);
        // 调用方法进行查询
        List<User> userList = userMapper.selectBatchIds(idList);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectOne() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 设定条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("name", "李四");
        // 根据条件查询一条数据，如果结果超过一条就会报错
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectCount() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 设定条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.gt("age", 15);// 查询年龄大于15岁的人
        // 根据条件查询记录总数
        Integer count = userMapper.selectCount(wrapper);
        System.out.println("记录总数：" + count);
    }

    @Test
    public void testSelectList() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 设定条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.gt("age", 15);// 查询年龄大于15岁的人
        // 根据条件查询记录
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectPage() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 设定分页参数，第一个参数是页码（从1开始），第二个参数是页显示条数
        Page<User> page = new Page<User>(1L, 2L);
        // 设定筛选条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.gt("age", 15);// 查询年龄大于15岁的人
        // 根据条件查询记录
        IPage<User> userPage = userMapper.selectPage(page, null);
        System.out.println("数据总条数：" + userPage.getTotal());
        System.out.println("总页数：" + userPage.getPages());
        // 打印分页记录
        List<User> userList = userPage.getRecords();// 获取分页记录数
        for (User user : userList) {
            System.out.println(user);
        }
    }

//    @Test
//    public void testFindAll() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
//        List<User> all = userMapper.findAll();
//        for (User user : all) {
//            System.out.println(user);
//        }
//    }

    @Test
    public void testAllEq() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 2);
        map.put("name", "李四");
        map.put("age", null);
        Wrapper<User> wrapper = new QueryWrapper<User>();
        ((QueryWrapper<User>) wrapper).allEq(map);
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testAllEq2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 2);
        map.put("name", "李四");
        map.put("age", null);
        Wrapper<User> wrapper = new QueryWrapper<User>();
        ((QueryWrapper<User>) wrapper).allEq(map, false);
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testAllEq3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 2);
        map.put("name", "李四");
        map.put("age", null);
        Wrapper<User> wrapper = new QueryWrapper<User>();
        // 意思是Map中的键名存在"name"或"age"才进行查询
        ((QueryWrapper<User>) wrapper).allEq((k, v) -> (k.equals("name") || k.equals("age")), map, false);
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testEq() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /*
            等价于
                select * from tb_user where passowrd=? and age>=? and name in (?,?,?)
         */
        wrapper.eq("password", "123456")
                .ge("age", 15)
                .in("name", "张三", "李四", "王五");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testLike() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /*
            等价于
                select * from tb_user where name like ?
         */
        wrapper.like("name", "王");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testOrderBy() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /*
            等价于
                select * from tb_user order by age desc
         */
        wrapper.orderByDesc("age");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testOr() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /*
            等价于
                select * from tb_user where name=? or age=?
         */
        wrapper.eq("name", "李四").or().eq("age", 24);
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelect() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /*
            等价于
                select name,password from tb_user where name=? or age=?
         */
        wrapper.eq("name", "李四").or().eq("age", 24).select("name", "password");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testAR1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 实例化对象
        User user = new User();
        user.setId(4L);// 设置主键id
        // 调用AR的查询方法selectById()
        User resultUser = user.selectById();
        System.out.println(resultUser);
    }

    @Test
    public void testAR2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 实例化对象，并封装要插入的数据
        User user = new User();
        user.setName("张飞");
        user.setAge(20);
        user.setPassword("abcdefg");
        user.setUsername("zhangfei");
        user.setEmail("zhangfei@qq.com");
        // 调用插入方法insert
        boolean result = user.insert();
        System.out.println("是否插入成功：" + result);
    }

    @Test
    public void testAR3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 实例化对象，封装id和要更新的数据
        User user = new User();
        user.setId(3L);
        user.setPassword("xxxxxx");
        // 执行更新操作
        boolean result = user.updateById();
        System.out.println("是否更新成功：" + result);
    }

    @Test
    public void testAR4() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 实例化对象，封装要删除的id
        User user = new User();
        user.setId(2L);
        // 执行删除操作
        boolean result = user.deleteById();
        System.out.println("是否删除成功：" + result);
    }

//    @Test
//    public void testFindById() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
//        // 调用自定义的方法findAll
//        List<User> userList = userMapper.findAll();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//    }

    @Test
    public void testAutoInsert() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        User user = new User();
        user.setName("猪八戒");
        user.setUsername("zhubajie");
        user.setEmail("zhubajie@qq.com");
        user.setAge(1999);
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testLogicDelete() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 执行逻辑删除
        int result = userMapper.deleteById(2L);
        System.out.println(result);
    }

    @Test
    public void testInsertByEnum() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 封装要插入的数据
        User user = new User();
        user.setName("关银屏");
        user.setUsername("guanyinping");
        user.setAge(35);
        user.setEmail("guanyinping@qq.com");
        user.setPassword("xxxxxx");
        user.setSex(SexEnum.WOMAN);// 设置性别用枚举类型
        // 执行插入
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testSelectByEnum() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 执行查询
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
