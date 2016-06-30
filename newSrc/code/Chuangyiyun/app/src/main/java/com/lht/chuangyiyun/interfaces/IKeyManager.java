package com.lht.chuangyiyun.interfaces;

/**
 * <p><b>Package</b>
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> IKeyManager
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/5.
 */
public interface IKeyManager {
	interface Debug {
		public boolean DEBUG_MODE = false;
	}
	/**
	 * @ClassName: Token
	 * @Description: 管理保存登录验证后核心数据的sp 的名称 和key
	 * @date 2015年11月25日 上午11:26:00
	 * 
	 * @author leobert.lan
	 * @version 1.0
	 */
	interface Token {

		public String SP_TOKEN = "sp_token";

		public String KEY_ACCESS_ID = "access_id";

		public String KEY_ACCESS_TOKEN = "access_token";

		public String KEY_USERNAME = "username";

	}

	interface Timer {
		public String SP_TIMER = "sp_timer";

		public String KEY_VERIFICATE = "timestamp_";
	}

	/**
	 * @ClassName: VersionSp
	 * @Description: 缓存服务器版本等信息
	 * @date 2016年2月29日 上午9:45:43
	 * 
	 * @author leobert.lan
	 * @version 1.0
	 */
	interface VersionSp {
		public String SP_VERSION = "version_info";

		/**
		 * KEY_CHECKEDSAVE:保存
		 */
		public String KEY_CHECKEDSAVE = "checked_save";

		/**
		 * KEY_IGNORED:该版本是否已经忽略
		 */
		public String KEY_IGNORED = "ignored";
	}

}
