package com.kuang.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author wbw
 * @date 2021/6/19 11:15
 */
class LRUCache {
    public Map map = new HashMap<Integer, Integer>(); //这个map存的是数组对
    public Integer size = 0;
    public LinkedList<Map<Integer, Integer>> head = new LinkedList<Map<Integer, Integer>>();
    //定义一个结构体
    public LRUCache(int capacity) {
        //创建容量为capacity的结构体
        map = new HashMap<Integer, Integer>(capacity);
        this.size = capacity;
    }

    public int get(int key) {
        int res = -1;
        if(map.get(key)!=null){
            res = (int)map.get(key);
        }else{
            return -1;
        }
        //todo将当前的key值放到列表前面，变换列表顺序
        Map node =  new HashMap<Integer, Integer>();
        node.put(key, map.get(key));
        //变换位置
        int len = head.size();
        for(int i=0;i<len;i++){
            Set set =  head.get(i).keySet();
            Object[] key2 = set.toArray();
            if((int)key2[0] == key){
                head.remove(i);
                break;
            }
        }
        head.remove();
        head.addFirst(node);
        return res;
    }

    public void put(int key, int value) {
        Map node =  new HashMap<Integer, Integer>();
        node.put(key, value);
        if(!map.containsKey(key)){
            if(map.size() < this.size){//容量不够,直接放Map中
                map.put(key, value);
            }else{//找到最后的列表的key,删除后再添加
                Map last =  head.getLast();
                Set set = last.keySet();
                Object[] key2 = set.toArray();
                map.remove(key2[0]); //移除
                map.put(key, value);
            }
        }

        if(head.size() >= this.size){ //删除尾巴，添加头
            head.removeLast();
            head.addFirst(node); //加头节点
        }else{//直接加
            head.addFirst(node); //加头节点
        }

    }
}
