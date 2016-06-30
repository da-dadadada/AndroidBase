package com.lht.chuangyiyun.interfaces.net;

import com.lht.chuangyiyun.util.debug.DLog;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.interfaces.net
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> IRestfulApi
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/6/30.
 */
public interface IRestfulApi {


    enum Schema {
        HTTP("http://"),

        HTTPS("https://");

        private final String schema;

        Schema(String s) {
            schema = s;
        }

        @Override
        public String toString() {
            return schema;
        }
    }

    Schema DEFAULT_SCHEMA = Schema.HTTP;

    String SERVER = "";

    String SEPRATOR = "/";

    String QUERY_SYMBOL = "?";

    String AND_SYMBOL = "&";


    /**
     * default schema is http
     *
     * @param restParams params in rest
     * @return request url
     */
    String formatUrl(String[] restParams);

    /**
     * @param restParams        params in rest
     * @param queryStringParams
     * @return
     */
    String formatUrl(String[] restParams, String[] queryStringParams);

    /**
     * @param schema
     * @param restParams params in rest
     * @return
     */
    String formatUrl(Schema schema, String[] restParams);

    /**
     * @param schema            模式
     * @param restParams        params in rest
     * @param queryStringParams
     * @return
     */
    String formatUrl(Schema schema, String[] restParams, String[] queryStringParams);

    /**
     * <p><b>Package</b> com.lht.chuangyiyun.interfaces.net
     * <p><b>Project</b> Chuangyiyun
     * <p><b>Classname</b> AbsRestApi
     * <p><b>Description</b>: 抽象restful api，主要作用：
     * 格式化rest api，特殊情况下同时格式化queryString，
     * <p/>
     * Created by leobert on 2016/6/30.
     */
    abstract class AbsRestApi implements IRestfulApi {

        protected abstract String getUnformatedRestString();

        /**
         * @return null if do not need to format qs
         */
        protected abstract String getUnformatedQuerystring();

        @Override
        public String formatUrl(String[] restParams) {
            return this.formatUrl(restParams, null);
        }

        @Override
        public String formatUrl(String[] restParams, String[] queryStringParmas) {
            return this.formatUrl(DEFAULT_SCHEMA, restParams, queryStringParmas);
        }

        @Override
        public String formatUrl(Schema schema, String[] restParams) {
            return this.formatUrl(schema, restParams, null);
        }

        @Override
        public String formatUrl(Schema schema, String[] restParams, String[] queryStringParams) {
            StringBuilder builder = new StringBuilder(schema.toString());
            builder.append(SERVER);

//            if (restParams == null) {
//                throw new IllegalArgumentException("Are you sure no rest params?");
//            }

            builder.append(String.format(getUnformatedRestString(), restParams));

            if (queryStringParams != null) {
                builder.append(QUERY_SYMBOL).append(String.format(getUnformatedQuerystring(), queryStringParams));
            }

            String ret = trim(builder);
            log(ret);
            return ret;
        }

        protected void log(String s) {
            DLog.d(getClass(), "format url:" + s);
        }

        protected String trim(StringBuilder builder) {
            return builder.toString().trim();
        }
    }

    //    interface Test extends {}
    class LoginApi extends AbsRestApi {

        public static final String REST = "user/login";

        @Override
        protected String getUnformatedRestString() {
            return REST;
        }

        @Override
        protected String getUnformatedQuerystring() {
            return null;
        }
    }
}
