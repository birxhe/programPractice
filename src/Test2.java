import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("111");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 5, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//        threadPoolExecutor.submit();
        HashMap map = new HashMap();
        ConcurrentHashMap cMap = new ConcurrentHashMap();
        ThreadLocal threadLocal = new ThreadLocal();
        new Hashtable();
    }
    
}
