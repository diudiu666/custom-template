package com;

import org.springframework.stereotype.Component;

/**
 *公共常量实体
 *@author :Muggle.Wang
 *Create in 12:31 2021/8/4
 */
@Component
public final class Constant {

    /**
     * 代码常量
     * */
    public static final String TOKEN = "Token";
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";

    /**
     * 格式化常量
     * */
    public static final String FORMAT_YYYY_MM_DD = "yyyyMMdd";
    public static final String FORMAT_4D = "%04d";
    public static final String FORMAT_3D = "%03d";

    /**
     * 序列常量
     * */
    public static final String SEQ_REPORT_NUMBER = "";

    /**
     * 数字常量
     * */
    public static final Integer NUM_ZERO = 0;
    public static final Integer NUM_ONE = 1;
    public static final Integer NUM_TWO = 2;
    public static final Integer NUM_THREE = 3;
    public static final Integer NUM_FOUR = 4;
    public static final Integer NUM_FIVE = 5;
    public static final Integer NUM_SIX = 6;
    public static final Integer NUM_SEVEN = 7;
    public static final Integer NUM_EIGHT = 8;
    public static final Integer NUM_NINE = 9;
    public static final Integer NUM_TEN = 10;
    public static final Integer NUM_ELEVEN1 = 11;
    public static final Integer NUM_TWELVE = 12;
    public static final Integer NUM_THIRTEEN = 13;
    public static final Integer NUM_FOURTEEN = 14;
    public static final Integer NUM_FIFTEEN = 15;
    public static final Integer NUM_SIXTEEN = 16;
    public static final Integer NUM_SEVENTEEN = 17;
    public static final Integer NUM_EIGHTEEN = 18;
    public static final Integer NUM_NINETEEN = 19;
    public static final Integer NUM_TWENTY = 20;
    public static final Integer NUM_NINETY_NINE = 99;
    public static final Integer NUM_HUNDRED = 100;
    public static final Integer NUM_TWO_HUNDRED = 200;
    public static final Integer NUM_FOUR_HUNDRED_FOUR = 404;
    public static final Integer NUM_FIVE_HUNDRED = 500;
    public static final Integer NUM_THOUSAND = 1000;
    public static final Integer NUM_NINE_THOUSAND = 9000;

    /**
     * 英文常量
     * */
    public static final String X = "X";

    /**
     * 异常常量
     * */
    public static final String EXCEPTION_INFO = "系统异常";
    public static final String EXCEPTION_VALIDATION_INFO = "实体校验异常";
    public static final String EXCEPTION_JSON_PROCESSING_INFO = "json解析异常";
    public static final String EXCEPTION_DUPLICATE_KEY_INFO = "数据库重复键值异常";
    public static final String EXCEPTION_TOKEN_INFO = "token获取失败或过期";
    public static final String EXCEPTION_LOGIN_VERIFY_INFO = "登录验证异常";

    /**
     * 中文常量
     * */
    public static final String EMPTY = "";
    public static final String PASS = "通过";
    public static final String FAIL = "不通过";
}
