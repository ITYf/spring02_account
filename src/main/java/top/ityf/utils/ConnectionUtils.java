package top.ityf.utils;

import javafx.scene.chart.PieChart;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * ClassName:ConnectionUtils
 * Package: top.ityf.utils
 * Description: 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 *
 * @Date: 2020/2/7 10:59
 * @Author: YanFei
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection() {
        try {
            //1、先从ThreadLocal上获取
            Connection conn = tl.get();
            //2、判断当前线程上是否有连接
            if (conn == null) {
                //3、从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                //4、把connect存入
                tl.set(conn);
            }
            //5、返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 作用：把连接和线程解绑
     *
     *
     * 描述：当我们的项目是一个web项目时，肯定会用到服务器，服务器有线程池(当tomcat一启动时，会初始化一大堆的线程放到一个容器中，接下来每一次访问，都会到容器中拿出一个线程以供使用)
     * 线程池中的线程也是和连接池中的连接一样，调用close并不是关闭，而是把此线程还回池中。
     * 当我们把连接关闭，线程还回时，而此时这个线程中还绑着一个连接，所以每当我们使用完线程时，要解绑线程上面的连接
     */

    public void removeConnection(){
        tl.remove();
    }
}
