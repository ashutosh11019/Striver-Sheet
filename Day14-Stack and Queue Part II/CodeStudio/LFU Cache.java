import java.util.*;
public class LFUCache {
    class DLLNode{
        int key, value, freq;
        DLLNode prev, next;
        DLLNode(int _key, int _value){
            this.key = _key;
            this.value = _value;
            this.freq = 1;
        }
    }
    
    class DLList{
        DLLNode head, tail;
        int listsize;
        DLList(){
            head = new DLLNode(0,0);
            tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        public void addNode(DLLNode currNode){
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listsize++;
        }
        public void removeNode(DLLNode currNode){
            DLLNode prevNode = currNode.prev;
            DLLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listsize--;
        }
        public DLLNode removeTail(){
            if(listsize > 0){
                DLLNode tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }
    
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode>cache;
    Map<Integer, DLList>frequencyMap;
    
	LFUCache(int capacity) {
		// Write your code here.
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
	}

	int get(int key) {
		// Write your code here.
        DLLNode currNode = cache.get(key);
        if(currNode == null){
            return -1;
        }
        updateNode(currNode);
        return currNode.value;
	}

	void put(int key, int value) {
		// Write your code here.
        if(capacity == 0){
            return; 
        }
        
        if(cache.containsKey(key)){
            DLLNode currNode = cache.get(key);
            currNode.value = value;
            updateNode(currNode);
        }else{
            curSize++;
            if(curSize > capacity){
                DLList minFreqList = frequencyMap.get(minFrequency);
                DLLNode deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            DLList currList = frequencyMap.getOrDefault(1, new DLList());
            currList.addNode(newNode);
            frequencyMap.put(1, currList);
            cache.put(key, newNode);
        }
	}
    public void updateNode(DLLNode currNode){
        int currFreq = currNode.freq;
        DLList currList = frequencyMap.get(currFreq);
        currList.removeNode(currNode);
        if(currFreq == minFrequency && currList.listsize == 0){
            minFrequency++;
        }
        currNode.freq++;
        DLList newList = frequencyMap.getOrDefault(currNode.freq , new DLList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.freq, newList);    
    }
}
