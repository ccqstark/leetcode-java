package 综合.No146LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ccqstark
 * @description 就是维护一个哈希表和一个双向链表而已
 * @date 2022/1/29 15:52
 */
class LRUCache {

    private int size; // 当前size
    private int capacity; // 容量
    private Map<Integer, LRUNode> hashmap = new HashMap<>(); // 哈希表
    private LRUNode head, tail; // dummy头，dummy尾

    /**
     * LRU链表节点
     */
    class LRUNode {
        int key;
        int value;
        // 双向链表
        LRUNode prev;
        LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LRUNode();
        tail = new LRUNode();
        // 注意dummy头节点和尾节点指针的初始化
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 先尝试获取
        LRUNode getNode = hashmap.get(key);
        if (getNode == null) {
            // 找不到
            return -1;
        }
        // 找到了记得移动到head再返回value
        moveToHead(getNode);
        return getNode.value;
    }

    public void put(int key, int value) {
        LRUNode getNode;
        // 如果put的key已经存在，那就覆盖一下然后移到head就可以退出了
        if ((getNode = hashmap.get(key)) != null) {
            getNode.value = value;
            moveToHead(getNode);
            return;
        }
        // 达到容量上限
        if (size == capacity) {
            // 记得链表中和哈希表中都要移除
            hashmap.remove(removeTail().key);
            // size要减1
            size--;
        }
        LRUNode newNode = new LRUNode(key, value);
        hashmap.put(key, newNode);
        // 添加成功也要移动到head
        addToHead(newNode);
        // size要加1
        size++;
    }

    /**
     * 下面主要是一些工具方法了，就是节点的指针操作
     */
    public void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(LRUNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public void moveToHead(LRUNode node) {
        removeNode(node);
        addToHead(node);
    }

    public LRUNode removeTail() {
        LRUNode last = tail.prev;
        removeNode(last);
        return last;
    }

}
