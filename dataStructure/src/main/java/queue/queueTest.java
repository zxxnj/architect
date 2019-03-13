package queue;

import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.Queue;

public class queueTest {

    public static void main(String[] args) {
        Queue q = new LinkedList();
        Jedis jedis = new Jedis("localhost");
        jedis.set("age", "101");
        System.out.println("age = " + jedis.get("age"));
    }

 }
