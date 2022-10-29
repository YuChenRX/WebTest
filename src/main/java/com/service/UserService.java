package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;



    public User getUser(Integer id) {

        return userMapper.getUser(id);
    }

    public boolean isExist(String name) {
        User userInfo = getUserByName(name);
        return null != userInfo;
    }

    public boolean isExists(String name, String password) {
        User userInfo = getUserByNameAndPassword(name, password);
        return null != userInfo;
    }

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public boolean modifyUser(User user) {
        return userMapper.modifyUser(user);
    }

    public boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    public List<User> getAll() {

        return userMapper.getAll();
    }

    public User getUserByName(String name) {
//        return userMapper.getUserByName(name);
        LambdaQueryWrapper<User> condition = new LambdaQueryWrapper<User>()
            .eq(User::getUname, name);
        return getOne(condition);
    }

    public User getUserByNameAndPassword(String name, String password) {
//        return userMapper.getUserByNameAndPassword(name, password);
        LambdaQueryWrapper<User> condition = new LambdaQueryWrapper<User>()
            .eq(User::getUname, name)
            .eq(User::getUpassword, password);
        return getOne(condition);
    }

    public static String getRandomJianHan(int len) {
        String randomName = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            randomName += str;
        }
        return randomName;
    }

    public int register(User user) {

        String name = user.getUname();

        String face = user.getUface();
        String password = user.getUpassword();


        name = HtmlUtils.htmlEscape(name);
        user.setUname(name);
        //前端获取密码
        password = HtmlUtils.htmlEscape(password);
        user.setUpassword(password);

        user.setUlname(getRandomJianHan(4));

        if (name.equals("") || password.equals("")) {
            return 0;
        }
        String[] b = {"https://i.postimg.cc/QtL2KzNK/01cfd95d145660a8012051cdb52093-png-1280w-1l-2o-100sh.png"
                , "https://i.postimg.cc/KcWn7ySW/72f298b9-E880884-d0f63115.png",
                "https://i.postimg.cc/Xv2TQvgF/0165cb5d14565ca8012155290a6d86-png-2o.png"};
        Random rand = new Random();
        int num = rand.nextInt(3);
        user.setUface(b[num]);
        boolean exist = isExist(name);

        if (exist) {
            return 2;
        }

        boolean i = userMapper.addUser(user);
        if (i) {
            return 1;
        } else {
            return 3;
        }

    }

    public int Login(User user) {

        String name = user.getUname();
        String password = user.getUpassword();


        user.setUlname(getRandomJianHan(4));

        if (name.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExists(name, password);

        if (exist) {
            return 1;
        }else {
            return 2;
        }

    }

}



