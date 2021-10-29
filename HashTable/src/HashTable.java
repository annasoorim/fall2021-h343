import java.util.*;

public class HashTable<K,V> implements Map<K,V> {
    class Node<K,V> {
        K key;
        V value;
        int hashcode;

        public Node(K key, V value, int hashcode){
            this.key= key;
            this.value = value;
            this.hashcode = hashcode;
        }
    }

    int size;
    LinkedList<Node<K, V>>[] hashList;
    /*
     * TODO
     */
    public HashTable(int table_size) {
	//array of LinkedList
        hashList = new LinkedList[table_size];
        for(int i=0; i!=table_size; ++i){
            hashList[i]= new LinkedList<Node<K,V>>();
        }
        size = table_size;
    }

//    public int size() {
//        return size;
//    }

    public int prehash(K key){
        int returnValue= key.hashCode();
        //checking for negatives
        if(returnValue<0){
            returnValue= returnValue*(-1);
        }
        return returnValue;
    }
    public int getBin(int hashcode){
        //division method, k mod m
        return hashcode%size;
    }

    /*
     * TODO
     */
    public boolean containsKey(K key) {
        int number = prehash(key);
        int bin = getBin(number);
        int container = contains(key, bin);
        if(container>=0){
            return true;
        }
//        for(int i=0; i<hashList[bin].size(); ++i){
//            if(hashList[bin].get(i).key==key){
//                return true;
//            }
//        }
        return false;
    }

    /*
     * TODO
     */
    public V get(K key) throws Exception {
        int prehashed = prehash(key);
        int index = getBin(prehashed);
        Node<K, V> currentNode;
        for(int i=0; i<hashList[index].size(); ++i){
            currentNode= hashList[index].get(i);
            if(currentNode.key.equals(key)){
                return currentNode.value;
            }
        }
        throw new Exception("Does not exist");
    }


    /*
     * TODO
     */
    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value, prehash(key));
        int index = getBin(prehash(key));
        int container = contains(key, index);
        if(container>=0){
            hashList[index].get(container).value = value;
        }
        else{
            hashList[index].add(node);
        }
//        Node<K, V> currentNode;
//        for(int i=0; i<hashList[index].size(); ++i){
//            currentNode=hashList[index].get(i);
//            if(currentNode.key.equals(key)){
//                currentNode.value = value;
//                currentNode.hashcode= prehash(key); //I don't think I need this
//            }
//        }
//        if(!hashList[index].contains(node)){
//            hashList[index].add(node);
//        }
    }

    public int contains(K key, int index){
        //returns either position or -1 if it doesn't exist
        Node<K, V> currentNode;
        for(int i=0; i<hashList[index].size(); ++i){
            currentNode=hashList[index].get(i);
            if(currentNode.key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    /*
     * TODO
     */
    public void remove(K key) {
        int hashed = prehash(key);
        int bin = getBin(hashed);
        if(containsKey(key)) {
            Node<K, V> currentNode;
            for(int i=0; i<hashList[bin].size(); ++i){
                currentNode=hashList[bin].get(i);
                if(currentNode.key.equals(key)){
                    hashList[bin].remove(i);
                }
            }
        }

    }

}
