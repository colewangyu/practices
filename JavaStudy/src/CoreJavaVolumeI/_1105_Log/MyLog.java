package CoreJavaVolumeI._1105_Log;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * Created by wy on 2016-07-26.
 */
public class MyLog {
    //创建日志记录器，com.cqupt.mylog表示域名，此时com是该域名的一个父亲，子域会继承父亲的设置。
    private static final Logger logger = Logger.getLogger("com.cqupt.mylogtest");
    private static final Logger loggerSuper = Logger.getLogger("com");
//    private static final Logger logger2 = Logger.getLogger("com.cqupt");

    public static void main(String[] args) {
        loggerSuper.setLevel(Level.FINE);
//        logger2.setLevel(Level.INFO);
//        logger.setLevel(Level.INFO);
        //设置记录器
        //避免父记录器重复输出，本记录器输出一次，父记录器输出一次
        logger.setUseParentHandlers(false);
        //设置过滤器
//        logger.setFilter(new MyFilter());

        //设置Console处理器（输出到console）
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        handler.setFormatter(new MyFormatter());
        logger.addHandler(handler);

        //设置File处理器（输出到文件）
        try {
            //使用配置的输出路径
            Handler fileHandler = new FileHandler("C:\\Users\\wy\\Desktop\\java%uJavaStudyLog", 5000, 3);
//            fileHandler.setFormatter(new MyFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("这里是info日志记录测试");
        logger.warning("这里是warning日志记录测试");
        //默认情况下，下面这个日志不会处理，需要设置$JAVA_HOME/jre/lib/logging.properties文件内的java.util.logging.ConsoleHandler.level = FINE
        logger.fine("这里是fine日志记录测试");
        //设置过滤器
//        logger.setFilter(new MyFilter());
    }
}

/**
 * 自定义日志处理器
 */
class MyHandler extends Handler {

    @Override
    public void publish(LogRecord record) {

    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}

/**
 * 自定义日志记录器和处理器的过滤器
 */
class MyFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        Level level = record.getLevel();
        if (level.equals(Level.FINE))
            return true;
        return false;
    }
}

/**
 * 自定义格式化器
 */
class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getMessage() + "\n";
    }

    @Override
    public synchronized String formatMessage(LogRecord record) {
        return super.formatMessage(record);
    }

    @Override
    public String getHead(Handler h) {
        return "<xml 这里是头>\n";
    }

    @Override
    public String getTail(Handler h) {
        return "</xml>\n";
    }
}
