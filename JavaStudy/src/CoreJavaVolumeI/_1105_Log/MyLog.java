package CoreJavaVolumeI._1105_Log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wy on 2016-07-26.
 */
public class MyLog {
    //创建日志记录器，com.cqupt.mylog表示域名，com.cqupt是该域名的父亲，子域会继承父亲的设置。
    private static final  Logger logger = Logger.getLogger("com.cqupt.mylog");

    public static void main(String[] args) {
        logger.setLevel(Level.FINE);
        logger.info("这里是info日志记录测试");
        logger.warning("这里是warning日志记录测试");
        //默认情况下，下面这个日志不会处理，需要设置$JAVA_HOME/jre/lib/logging.properties文件内的java.util.logging.ConsoleHandler.level = FINE
        logger.fine("这里是fine日志记录测试");
    }
}
