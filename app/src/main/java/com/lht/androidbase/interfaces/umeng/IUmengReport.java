package com.lht.androidbase.interfaces.umeng;

/**
 * @package com.lht.androidbase.interfaces
 * @project AndroidBase
 * @classname IUmengReport
 * @description: 进行友盟统计的接口，实现于activity、fragment，调用于presenter，presenter提供model需要的回调
 * Created by leobert on 2016/4/1.
 */
public interface IUmengReport extends  IUmengEventKey{
    /**
     * @param pageName
     */
    void reportPageStart(String pageName);

    /**
     * @param pageName
     */
    void reportPageEnd(String pageName);
}
