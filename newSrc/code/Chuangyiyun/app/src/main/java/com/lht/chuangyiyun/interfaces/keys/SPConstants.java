package com.lht.chuangyiyun.interfaces.keys;

/**
 * @author
 * @version 1.0
 * @date 2016/4/25
 */
public interface SPConstants {

    /**
     * app 基础sharedpreferences配置
     */
    interface Basic {
        /**
         * 命名
         */
        public String SP_NAME = "base";


        /**
         * 属性1：启动次数统计
         */
        public String KEY_STARTCOUNT = "start_count";

        String KEY_THEME_COLOR = "cur_theme_color";
    }
}
