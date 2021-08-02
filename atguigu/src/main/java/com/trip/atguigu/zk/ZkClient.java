package com.trip.atguigu.zk;

import lombok.SneakyThrows;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class ZkClient {
    static String host = "192.168.3.96:2181,192.168.3.97:2181,192.168.3.98:2181";
    static ZooKeeper zkCli = null;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zkCli = new ZooKeeper(host, 2000, new Watcher() {
            @SneakyThrows
            @Override
            public void process(WatchedEvent watchedEvent) {
                Event.EventType type = watchedEvent.getType();
                System.out.println(type);
                List<String> children = zkCli.getChildren("/", true);
                for (int i = 0; i < children.size(); i++) {
                    System.out.println(children.get(i));
                }
            }
        });

        List<String> children = zkCli.getChildren("/", true);
        for (int i = 0; i < children.size(); i++) {
            System.out.println(children.get(i));
        }
        Thread.sleep(Long.MAX_VALUE);
    }
}
