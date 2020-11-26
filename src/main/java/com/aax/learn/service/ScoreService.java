package com.aax.learn.service;

import java.math.BigDecimal;

/**
 * @date Created by 邵桐杰 on 2020/11/26 15:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description：
 */
public class ScoreService {
    private BigDecimal score;

    private static final ScoreService INSTANCE = new ScoreService();
    private ScoreService(){}

    public static ScoreService getInstance() {
        return INSTANCE;
    }

    public BigDecimal addScore(BigDecimal score) {
        return this.score.add(score);
    }

    public BigDecimal getScore() {
        return this.score;
    }
}
