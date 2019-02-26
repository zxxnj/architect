import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class csThread {

    public static void main(String[] args) throws FileNotFoundException {
        //RandomAccessFile cs = new RandomAccessFile("d:/cx.txt","rw");

        Map m = new ConcurrentHashMap();

        int a = true ? 1:0;
        System.out.println(a);



    }
}
