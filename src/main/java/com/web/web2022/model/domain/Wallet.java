package com.web.web2022.model.domain;

import java.math.BigDecimal;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 12:47
 */
public class Wallet {
    private long uid;//用户id
    private BigDecimal balance;//余额
    private int score;//积分
    private BigDecimal alreadyDeposit;//已充值金额
    private BigDecimal alreadyUsed;//已消费金额

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public BigDecimal getAlreadyDeposit() {
        return alreadyDeposit;
    }

    public void setAlreadyDeposit(BigDecimal alreadyDeposit) {
        this.alreadyDeposit = alreadyDeposit;
    }

    public BigDecimal getAlreadyUsed() {
        return alreadyUsed;
    }

    public void setAlreadyUsed(BigDecimal alreadyUsed) {
        this.alreadyUsed = alreadyUsed;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "uid=" + uid +
                ", balance=" + balance +
                ", score=" + score +
                ", alreadyDeposit=" + alreadyDeposit +
                ", alreadyUsed=" + alreadyUsed +
                '}';
    }
}
