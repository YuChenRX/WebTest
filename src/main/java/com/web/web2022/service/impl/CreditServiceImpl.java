package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.CreditDao;
import com.web.web2022.dao.UserDao;
import com.web.web2022.model.RespBean;
import com.web.web2022.model.domain.Credit;
import com.web.web2022.model.domain.User;
import com.web.web2022.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GuXianWN
 * @date 2022/03/12 11:25
 **/
@Service
public class CreditServiceImpl extends ServiceImpl<CreditDao, Credit> implements CreditService {
    @Autowired
    private CreditDao creditDao;
    @Autowired
    private UserDao userDao;

    @Override
    public RespBean clockIn(Integer id) {
        // TODO credit table is out of use, use credit column in user table instead.
        Credit credit = creditDao.selectById(id);
        if (credit == null) {
            credit = new Credit(id, new Date());
            creditDao.insert(credit);
            User user = userDao.selectById(id);
            user.setCredit(user.getCredit().add(BigDecimal.valueOf(10)));
            userDao.updateById(user);
            return RespBean.success("签到成功,积分+10").data("credit", credit);
        } else {
            User user = userDao.selectById(id);
            Date date = credit.getTime();
            if (date.before(new Date(System.currentTimeMillis() - 86400000))) {
                credit = new Credit(id, new Date());
                creditDao.updateById(credit);
                user.setCredit(user.getCredit().add(BigDecimal.valueOf(3)));
                userDao.updateById(user);
                return RespBean.success("签到成功,积分+3");
            } else {
                return RespBean.success("今天你已签过到");
            }
        }
    }
}
