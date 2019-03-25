import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class csThread {
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    //读锁
    public  static void Read(Thread t){
        lock.readLock().lock();
        System.out.println("read StartTime"+System.currentTimeMillis());
        boolean readLock = lock.isWriteLocked();
        if (!readLock) {
            System.out.println("当前为读锁！");
        }
        for (int i = 0; i < 3; i++) {
            try{
                Thread.sleep(2);
            }catch (Exception e){

            }
            System.out.println(t.getName()+"read");
        }
        System.out.println(t.getName()+"read 结束");
        System.out.println("read endTime"+System.currentTimeMillis());
        lock.readLock().unlock();
    }

    //写锁
    public  static void write(Thread t){

        lock.writeLock().lock();
        System.out.println("write  StartTime"+System.currentTimeMillis());
        boolean readLock = lock.isWriteLocked();
        if (readLock) {
            System.out.println("当前为写锁！");
        }
        for (int i = 0; i < 3; i++) {
            try{
                Thread.sleep(2);
            }catch (Exception e){

            }
            System.out.println(t.getName()+"write");
        }
        System.out.println(t.getName()+"write结束");
        System.out.println("write endTime"+System.currentTimeMillis());
        lock.writeLock().unlock();
    }



    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        //RandomAccessFile cs = new RandomAccessFile("d:/cx.txt","rw");
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new Thread(new Runnable() {
           @Override
           public void run() {
                write(Thread.currentThread());

               //Read(Thread.currentThread());
           }

       }));

        service.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                //Read(Thread.currentThread());
                write(Thread.currentThread());
            }
        }));

    }
}
