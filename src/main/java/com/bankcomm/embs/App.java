/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bankcomm.embs;

import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class App {

    // 记录所有节点访问次数
    private static final Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        showData();
        // 检测是否接收到所有节点
        while (true) {
            try {
                Thread.sleep(100);
                if (resultMap.size() == 32) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        loopMapPrint(resultMap);
        System.out.println("all nodes is active!");
    }

    private static void showData() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                    loopMapPrint(resultMap);
                    if (resultMap.size() == 32) {
                        break;
                    }
                }
            }
        }).start();
    }

    private static void loopMapPrint(Map<String, Integer> map) {
        Set<Entry<String, Integer>> entrySet = resultMap.entrySet();
        Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = iterator.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}
