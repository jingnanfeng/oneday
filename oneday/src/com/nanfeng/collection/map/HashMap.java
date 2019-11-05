package com.nanfeng.collection.map;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;


/**
 * @author liutao
 * @Title HashMap
 * @Description HashMap采用了（数组+链表+红黑树）的复杂结构，数组的一个元素又称作桶
 * 在添加元素时，会根据hash值算出元素在数组中的位置，如果该位置没有元素，则直接把元素
 * 放在此处，如果该位置有元素了，则把元素以链表的形式存放在链表的尾部
 * 当一个链表的元素个数达到一定数量（且数组的长度达到一定的长度）后，则把链表转化为红黑
 * 树，从而提高效率，
 * 数组的查询效率为O(1),链表的查询效率为O(k),红黑树的查询效率为O(logk),k为桶中元素个数，
 * 所以当元素非常多的时候，转为红黑树能极大的提高效率
 * @date 2019-07-24 9:15
 */
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {

    private static final long serialVersionUID = 8086741854948762512L;
    /**
     * 默认初始容量为16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /**
     * 最大的容量为2的30次方
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * 默认的装载因子
     */
    static final float DEFFILT_LOAD_FACTOR = 0.75f;
    /**
     * 当一个桶中的元素个数大于等于8时进行树化
     */
    static final int TREEIFY_THRESHOLD = 8;
    /**
     * 当一个桶中元素个数小于等于6时把树转为链表
     */
    static final int UNTREEIFY_THRESHOLD = 6;
    /**
     * 当桶中个数达到64的时候才进行树化
     */
    static final int MIN_TREEIFY_CAPACITY = 64;
    /**
     * 数组，又叫做桶（bucket）
     */
    transient Node<K,V>[] table;
    /**
     * 作为entrey()的缓存
     */
    transient Set<Map.Entry<K,V>> entrySet;
    /**
     * 元素的数量
     */
    transient int size;
    /**
     * 修改的次数，用于在迭代器的时候执行快速失败策略
     */
    transient int modCount;
    /**
     * 当桶的使用数量达到多少时进行扩容，threshold = capacity * loadFactory
     */
    int threshold;
    /**
     * 装载因子
     */
    final float loadFactory;

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
    /* ----------------------------------内部类------------------------*/
    /**
     * 内部类（链表）
     */
    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V valeu;
        Node<K,V> next;
        Node(int hash,K key,V valeu,Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.valeu = valeu;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return key;
        }
        @Override
        public final V getValue() {
            return valeu;
        }
        public final String toString(){
            return key + "=" + valeu;
        }
        public final int hashCode(){
            return Objects.hashCode(key) ^ Objects.hashCode(valeu);
        }
        @Override
        public V setValue(V newValue) {
            V oldValue = valeu;
            valeu = newValue;
            return oldValue;
        }
        public final boolean equals(Object o){
            if (o == this){
                return true;
            }
            if (o instanceof Map.Entry){
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key,e.getKey()) &&
                        Objects.equals(valeu,e.getValue())){
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * 如果对象x的类型实现了Comparable<C>接口，那么返回x的类型，否则返回null
     * 这个方法的目的就是为了看看x的class是否implements Comparabel<x的class>
     */
    static Class<?> comparableClassFor(Object x){
        if (x instanceof Comparable){
            Class<?> c; Type[] ts, as; ParameterizedType p;
            if ((c = x.getClass()) == String.class){
                return c;
            }
            if ((ts = c.getGenericInterfaces()) != null){
                for (Type t : ts){
                    if ((t instanceof ParameterizedType) &&
                        ((p = (ParameterizedType)t).getRawType() ==
                                    Comparable.class)&&
                            (as = p.getActualTypeArguments()) !=null &&
                    as.length == 1 && as[0] == c){
                        return c;
                    }
                }
            }
        }
        return null;
    }
    /**
     * 如果x的类型是kc,返回k.compareTo(x)的比较结果
     * 如果x为空，或者类型不存在，返回0
     */
    @SuppressWarnings({"rwatypes","unchecked"})
    static int compareComparables(Class<?> kc,Object k, Object x){
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable)k).compareTo(x));
    }

    /**
     * 返回大于输入参数且最近的2的整数次幂的数
     * 例如10 ：返回的是16
     * 1 | 3 就是1和3的按位或，按位或（全0为0，反之为1）
     * 1 & 3 就是1和3的按位与，按位与（全1为1，反之为0）
     * 1 ^ 3 就是1和3的按位非，按位非（按位相反）
     * >>>
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap){
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    /* ----------------------------构造器 ------------------------------*/

    /**
     * 构造器
     * @param initialCapacity
     * @param loadFactory
     */
    public HashMap(int initialCapacity, float loadFactory){
        //如果初始化容量小于0，抛出异常
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal initial capacity: "+ initialCapacity);
        }
        //如果初始化容量大于最大容量，就最大容量
        if (initialCapacity > MAXIMUM_CAPACITY){
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactory <= 0 || Float.isNaN(loadFactory)){
            throw new IllegalArgumentException("Illegal initial capacity: "+loadFactory);
        }
        this.loadFactory = loadFactory;
        //计算扩容门槛
        this.threshold = tableSizeFor(initialCapacity);
    }
    public HashMap(int initialCapacity){
        this(initialCapacity,DEFFILT_LOAD_FACTOR);
    }
    public HashMap(){
        this.loadFactory = DEFFILT_LOAD_FACTOR;
    }
    public HashMap(Map<? extends K, ? extends  V> m){
        this.loadFactory = DEFFILT_LOAD_FACTOR;
        //putMapEntries(m,false);
    }

    /*--------------------------普通方法---------------------------------*/
   /**
     * 添加元素
     */
    public V put(K key, V value){
        //调用hash(key)计算出key的hash值
        return putVal(hash(key),key,value,false,true);
    }
    /**
     *利用key生成哈希
     */
    static final int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 添加元素
     * @param hash 传进来元素的hash值
     * @param key 传进来的key
     * @param value value
     * @param onlyIfAbsent 是否替换
     * @param evict
     * @return
     */
    final V putVal(int hash, K key, V value,boolean onlyIfAbsent,boolean evict){
        Node<K,V>[] tab;
        Node<K,V> p;
        int n,i;
        //如果桶的数量为0，则初始化
        if ((tab = table) == null || (n = tab.length) == 0) {
            //调用扩容的方法
            n = (tab = resize()).length;
        }
        //（n - 1）& hash 计算元素在哪一个桶中 , 1 & 3 就是1和3的按位与，按位与（全1为1，反之为0）
        //如果这个桶中还没有这个元素，则把这个元素放到桶中的第一个位置
        if ((p = tab[i = (n -1) & hash]) == null){
            //新建一个节点放到桶中
            tab[i] = newNode(hash,key,value,null);
        }else {
            //如果桶中已经有元素存在了
            Node<K,V> e;
            K k;
            //如果桶中第一个元素的key与带插入元素的key相同，保存到e中用于后续修改valie值;
            //p 目前是桶中的第一个元素
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))){
                //将桶中的第一元素赋给e
                e = p;
            }else if (p instanceof TreeNode){
                //如果第一个是树节点，则调用树节点的putTreeVal插入元素
                e = ((TreeNode<K,V>)p).putTreeVal(this,tab,hash,key,value);
            }else {
                //遍历这个桶对应的链表，binCount用于存储链表中元素的个数
                for(int binCount = 0;;++binCount){
                    //如果链表遍历完成都没有找到相同的key的元素，说明key对应的元素不存在，则在链表后添加一个新元素
                    if ((e = p.next) == null){
                        p.next = newNode(hash,key,value,null);
                        //如果插入新节点后链表长度大于8，则判断是否要进行树化，因为第一个元素没有加到binCount中，所以要-1
                        if (binCount >= TREEIFY_THRESHOLD -1){
                            treeifyBin(tab,hash);
                        }
                        break;
                    }
                    //如果待插入的key在链表中找到了，则退出循环
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))){
                        break;
                    }
                    p = e;
                }
            }
            //如果找到了对应的key的元素
            if (e != null){
                //记录旧值
                V oldValue = e.valeu;
                //判断是否需要替换旧值
                if (!onlyIfAbsent || oldValue == null){
                    //替换为新值
                    e.valeu = value;
                }
                //在节点被访问后做点什么，在LinkedHashMap中用到
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold){
            //扩容
            resize();
        }
        //在节点插入后做点什么事，在linkedHashMap中用到
        aterNodeInsertion(evict);
        return null;
    }


/*    *//**
     * hashMap的扩容
     * @return
     *//*
    final Node<K,V>[] resize(){
        //旧数组
        Node<K, V>[] oldTab = table;
        //旧容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //旧的扩容门槛
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0){
            if (oldCap >= MAXIMUM_CAPACITY){
                //如果旧的扩容达到了最大的容量，则不再进行扩容
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }else if ((newCap = oldCap << 1) <MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY){
                //如果就的容量两倍小于最大容量并且旧容量大于默认初始化容量（16）
                //，则容量扩大为两倍，扩容门槛页扩大两倍
                newThr = oldThr << 1;
            }
        }else if (oldThr > 0){
            //使用非默认构造方法创建的map,第一次插入元素会做这里
            //如果旧的容量为0，并且扩容门槛大于0，则把新的容量扶植为旧门槛
            newCap = oldThr;
        }else {
            //调用默认构造方法创建map,第一次插入元素会走这里
            //如果旧的容量旧的扩容都是0，说明还没初始化，则初始化容量为默认容量，扩容门开为
            //默认容量*默认的装载因子
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFFILT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0){
            //如果新扩容门开为0，则计算为容量*装在因子，但不能超过最大容量
            float ft = (float)newCap * loadFactory;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        //赋值扩容门槛为新门槛
        threshold = newThr;
        //新建一个新容器数组
        @SuppressWarnings({"rawtypes","unckecked"})
        Node<K,V>[] newTab = (Node<K,V>[]) new Node[newCap];
        //把桶赋值给新的数组
        table = newTab;
        //如果旧数组不为空，则 搬移元素
        if (oldTab != null){
            //遍历旧数组
            for (int j = 0; j < oldCap; ++j){
                Node<K,V> e;
                //如果桶中的第一个元素不为空，赋值给e
                if ((e = oldTab[j]) != null){
                    oldTab[j] = null;
                    //如果这个桶中只有一个元素，则计算它在新桶中的位置并把它搬移到新桶中
                    //因为每次都要扩容两倍，所有这里的第一个元素搬移到新桶的时候新桶中肯定还没有元素
                    if (e.next == null){
                        newTab[e.hash & (newCap -1)] = e;
                    }else if (e instanceof TreeNode){
                        //如果第一个元素是树节点，则把这棵树打散成两棵树插入到新桶去
                        ((TreeNode<K, V>) e).split(this,newTab,j,oldCap);
                    }else {
                        //如果这个链表不止一个元素且不是一棵树
                        //则分化成两棵树插入到新的桶去
                        //比如，假如原来的容量为4，3、7、11、15这四个元素都在三号 桶中
                        //现在扩容到8，则3和11还在三号桶，7和15要搬移到七号桶中
                        //也是分化成两个链表
                        Node<K,V> loHead = null,loTail = null;
                        Node<K,V> hiHead = null,hiTail = null;
                        Node<K,V> next;
                        do{
                            next = e.next;
                            //(e.hash & oldCap) == 0 的元素应该放到链表中
                            if ((e.hash & oldCap) == 0){
                                if (loTail == null){
                                    loHead = e;
                                }else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            }else {
                                //(e.hash & oldCap) != 0的元素放到高位链表中
                                //比如 7 & 4 ！= 0
                                if (hiTail == null){
                                    hiHead = e;
                                }else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        }while ((e = next) != null);
                        //遍历完成分化成两个链表
                        //低链表在新桶中的位置和旧桶中一致
                        if (loTail != null){
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        //高位链表在新桶的的位置正好是原来的位置加旧桶的容量
                        if (hiTail != null){
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }

                }
            }
        }
        return newTab;
    }*/

    final Node<K,V>[] resize(){
        //旧数组
        Node<K,V>[] oldTab = table;
        //旧容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //旧的扩容门槛
        int oldThr = threshold;
        int newCap,newThr = 0;
        if (oldCap > 0){
            if (oldCap >= MAXIMUM_CAPACITY){
                //如果旧容量达到了最大的容量，则不再进行扩容
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }else if ((newCap = oldCap << 1) <MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY){
                //如果旧的容量的两倍小于最大容量并且旧容量大于默认初始化容量（16）
                //则容量扩大为两倍，扩容门槛也扩大为两倍
                newThr = oldThr << 1;
            }
        }else if (oldThr > 0){
            //使用非默认构造器创建map,第一次插入插入元素会走这里
            //如果旧容器为0且旧的扩容门槛大于0，则把新容器赋值为旧门槛
            newCap = oldThr;
        }else {
            //调用默认构造方法创建的map,第一次插入原属会走这里
            //如果旧容器容量为0，说明还未初始化，则初始化为默认容量
            //扩容门槛为默认容量*默认装在因子
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_INITIAL_CAPACITY * DEFFILT_LOAD_FACTOR);
        }
        if (newThr == 0){
            //如果新的扩容门槛为0，则计算为容量*装载因子，但不能超过最大容量
            float ft = (float)newCap * loadFactory;
            newThr = (newCap < MAXIMUM_CAPACITY && ft <(float)MAXIMUM_CAPACITY ?
                    (int) ft :Integer.MAX_VALUE);
        }
        //赋值扩容门槛为新门槛
        threshold = newThr;
        //创建一个新容器的数组
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[]) new Node[newCap];
        //把桶赋值为新数组
        table = newTab;
        //如果旧数组不为空，则搬移数组
        if (oldTab != null){
            //遍历旧数组
            for (int j = 0; j < oldCap; ++j){
                Node<K,V> e;
                //如果桶中第一个不为空，赋值给e
                if ((e = oldTab[j]) != null){
                    //清口旧桶，便于GC回收
                    oldTab[j] = null;
                    //如果这个桶中只有一个元素，则计算它在新桶的位置并把它搬移到新桶中
                    //因为每次都扩容两倍，所以这里的第一个元素搬移到新桶中肯定还没有元素
                    if (e.next == null){
                        newTab[e.hash & (newCap -1)] = e;
                    }else if (e instanceof TreeNode){
                        //如果第一个元素是树节点，这把这棵树大三成两棵树插入到新桶中去
                        ((TreeNode<K,V>)e).split(this,newTab,j,oldCap);
                    }else {
                        //如果这个链表不止一个元素且不是一棵树
                        //则分化成两个链表插入到新桶中去
                        //比如，假如原来容量为4，3、7、11、15这四个元素都在三号桶中
                        //现在扩容到8，则3和11还是在三号桶，7和15要搬到七号桶去
                        //也就是分化成两个链表
                        Node<K,V> loHead = null,loTail = null;
                        Node<K,V> hiHead = null,hitail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            //(e.hash & oldCap) == 0的元素放到低位链表中
                            //比如，3 & 4 == 0
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null){
                                    loHead = e;
                                }else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            }else {
                                //(e.hash & oldCap) != 0 的元素放到高位链表中
                                // 7 & 4 != 0
                                if (hitail == null){
                                    hiHead = e;
                                }else {
                                    hitail.next = e;
                                }
                                hitail = e;
                            }
                        }while ((e = next) != null);
                        //遍历完成分化成两个链表了
                        //地位链表在新桶中的位置与旧桶一样（即3和11还在三号桶中）
                        if (loTail != null){
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        //高位链表在新桶中的位置正好是原来的位置加上旧容量（7和15搬移到七号桶中）
                        if (hitail != null){
                            hitail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
    return newTab;
    }


    /**
     * 是否进行树化
     * @param tab
     * @param hash
     */
    private void treeifyBin(Node<K,V>[] tab, int hash) {
        int n,index;
        Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY){
            //如果桶数小于64，直接扩容不用树化
            //因为扩容后，连败哦会分化成两个链表，达到减少元素的作用
            //当然也不定，比如容量4，里面存的全是除以4余数为3的元素
            //这样即使扩容也无法减少链表的长度
            resize();
        }else if ((e = tab[index = (n - 1) & hash]) != null){
            TreeNode<K,V> hd = null,tl = null;
            //把所有的节点换成数节点
            do {
                TreeNode<K,V> p = replacementTreeNode(e,null);
                if (tl == null){
                    hd = p;
                }else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            }while ((e = e.next) != null);
            //如果进入上面的循环，则从头开始树化
            if ((tab[index]) != null){
                hd.treeify(tab);
            }
        }
    }
    TreeNode<K,V> replacementTreeNode(Node<K,V> p, Node<K,V> next){
        return new TreeNode<>(p.hash,p.key,p.valeu,next);
    }

    private void aterNodeInsertion(boolean evict) {
    }

    private void afterNodeAccess(Node<K,V> e) {
    }
    TreeNode<K,V> newTreeNode(int hash,K key,V value,Node<K,V> next){
        return new TreeNode<>(hash,key,value,next);
    }





    Node<K,V> newNode(int hash,K key, V value, Node<K,V> next){
        return new Node<>(hash,key,value,next);
    }

    /**
     * 红黑树
     * @param <K>
     * @param <V>
     */
    static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;//父节点
        TreeNode<K,V> left;//左子节点
        TreeNode<K,V> right;//右子节点
        TreeNode<K,V> prev; //在删除的时候删除连接
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next){
            super(hash,key,val,next);
        }

        /**
         * 查询根节点
         * @return
         */
        final TreeNode<K,V> root(){
            for (TreeNode<K,V> r = this,p;;){
                if ((p = r.parent) == null){
                    return r;
                }
                r = p;
            }
        }

        /**
         * 确保给出的根节点是箱中的第一个节点 也就是直接位于table上的
         * 原本的第一个节点若不是root节点则将root从连败哦中剪下放到第一个节点的前方
         * @param tab
         * @param root
         * @param <K>
         * @param <V>
         */
        static <K,V> void moveRootToFront(Node<K,V>[] tab,TreeNode<K,V> root){
            int n;
            if (root != null && tab !=null && (n = tab.length) > 0){
                //根据root的hash值快速定位下标
                int index = (n - 1) & root.hash;
                //取出table[index]中的第一个节点
                TreeNode<K,V> frist = (TreeNode<K,V>)tab[index];
                //如果root不是第一个节点
                if (root != frist){
                    Node<K,V> rn;
                    //将root放到table[index]的位置上
                    tab[index] = root;
                    //rp == root 的前一个节点
                    TreeNode<K,V> rp = root.prev;
                    //rn == root 的后一个节点
                    if ((rn = root.next) != null){
                        //rn的前指针指向root的前一个节点
                        ((TreeNode<K,V>)rn).prev = rp;
                    }
                    if (rp != null){
                        //rp的后指针指向root的后一个节点
                        frist.next = rn;
                    }
                    if (frist != null){
                        //将原本的frist放到root后面
                        frist.prev = root;
                    }
                    root.next = frist;
                    root.prev = null;
                }
                assert checkInvariants(root);
            }
        }

        /**
         * 从root开始递归查询红黑树的性质，仅在检查root是否落在table上调用
         */
        static <K,V> boolean checkInvariants(TreeNode<K,V> t){
            TreeNode<K,V> tp = t.parent,tl = t.left,tr = t.right,
                    tb = t.prev,tn = (TreeNode<K,V>)t.next;
            if (tb != null && tb.next != t){
                //t的前一个节点是后续节点应该为t
                return false;
            }
            if (tn != null && tn.prev != t){
                //t的后一个节点的前驱应为t
                return false;
            }
            if (tp != null && t != tp.right && t != tp.left){
                //t应为t的父亲的左儿子或者右儿子
                return false;
            }
            if (tl != null && (tl.parent != t || tl.hash > t.hash)){
                //t的右左儿子的hash值小于t,父亲应为t
                return false;
            }
            if (tr != null && (tr.parent != t || tr.hash < t.hash)){
                //t的右儿子的hash值应该大于t,父亲应为t
                return false;
            }
            if (t.red && tl != null && tl.red && tr != null && tr.red){
                //t和t的儿子不能同时为红色
                return false;
            }
            if (tl != null && !checkInvariants(tl)){
                //递归检查t的左儿子
                return false;
            }
            if (tr != null && !checkInvariants(tr)){
                //递归检查t的右儿子
                return false;
            }
            return true;
        }


        /**
         * 当存在hash碰撞的时候，且元素数量大于8的时候，就会以红黑树的方式将这些元素
         * 组织起来
         * map 当前节点的hashMap对象
         * tab 当前hashMap对象的元素数组
         * h 指定key的hash
         * k 指定k
         * v 指定k的value值
         * 返回，指定key所匹配到的节点对象，针对这个对象去修改V(返回空说明新建了一个节点)
         */
        final TreeNode<K,V> putTreeVal(HashMap<K,V> map,Node<K,V>[] tab,
                                       int h, K k, V v){
            Class<?> kc = null;
            //标记是否找到这个key的节点
            boolean searched = false;
            //找到树的根节点
            TreeNode<K,V> root = (parent != null) ? root() : this;
            //从树的根节点开始遍历
            for (TreeNode<K,V> p = root; ;){
                //dir = direction,标记是左节点还是右节点
                //ph = p.hash,当前节点的hash值
                int dir,ph;
                //pk = p.key,当前节点的key值
                K pk;
                if ((ph = p.hash) > h){
                    //当前hash比目标hash大,说明在左边
                    dir = -1;
                }else if (ph < h){
                    //当前hash比目标hash小，说明在右边
                    dir = 1;
                }else if ((pk = p.key) == k || (k != null && k.equals(pk))){
                    //两者hash相同且key相等，说明找到了节点，直接返回改节点
                    //回到putVal()中判断是否要修改其value值
                    return p;
                }else if ((kc == null &&
                        //如果K是Comparable的子类则返回真实的类，否则返回null
                        (kc = comparableClassFor(k)) == null) ||
                        //如果k和pk部署不是相同类型返回0，否则返回两者比较的结果
                        (dir = compareComparables(kc,k,pk)) == 0){
                    //这个条件表示两者的hash值相同但是一个不是Comparable类型或者两者类型不同
                    //比如key是Object类型，这时可以传String也可以传Integer,两者hash值可能相同
                    //在红黑树中把同样的hash值元素存储在同一颗子树上，这里相当于找到这颗子树的顶点
                    //从这个顶点分别遍历左右子树去寻找有没有待插入的key相同的元素
                    if (!searched){
                        TreeNode<K,V> q,ch;
                        searched = true;
                        //遍历左右子树找到了直接返回
                        if (((ch = p.left) != null &&
                            (q = ch.find(h,k,kc)) != null) ||
                            ((ch = p.right) != null &&
                                    (q = ch.find(h,k,kc)) != null)){
                            return q;
                        }
                    }
                    //如果两者类型相同，再根据他们内存地址计算hash值进行比较
                    dir = tieBreakOrder(k,pk);
                }
                TreeNode<K,V> xp = p;
                if ((p = (dir <= 0) ? p.left : p.right) == null){
                    //如果最后没有找到对应的key的元素，则返回新建一个节点
                    Node<K,V> xpn = xp.next;
                    TreeNode<K,V> x = map.newTreeNode(h,k,v,xpn);
                    if (dir <= 0){
                        xp.left = x;
                    }else {
                        xp.right = x;
                    }
                    xp.next = x;
                    x.parent = x.prev = xp;
                    if (xpn != null){
                        ((TreeNode<K,V>) xpn).prev = x;
                        //插入树节点平衡
                        //把root节点移动到第一个节点
                        moveRootToFront(tab,balanceInsertion(root,x));
                        return null;
                    }
                }

            }
        }

        /**
         * 从根节点寻找h和k符合的节点
         * @param h
         * @param k
         * @return
         */
        final TreeNode<K,V> getTreeNode(int h,Object k){
            return ((parent != null) ? root() : this).find(h, k,null);
        }

        /**
         * 从根节点p开始根据hash和key值寻找指定的节点。kc是key的class
         * @param h
         * @param k
         * @param kc
         * @return
         */
        final TreeNode<K,V> find(int h,Object k, Class<?> kc){
            //调用该方法时this是根节点
            TreeNode<K,V> p = this;
            do {
                int ph, dir;
                K pk;
                TreeNode<K, V> pl = p.left, pr = p.right, q;
                if ((ph = p.hash) > h) {
                    //h < p.hash,移向左子树
                    p = pl;
                } else if (ph < h) {
                    //h > p.hash 移向右子树
                    p = pr;
                } else if ((pk = p.key) == k || (k != null && k.equals(pk))) {
                    //p.key = k
                    return p;
                } else if (pl == null) {
                    //如hash相等但key不等，向左右子树非空的一侧移动
                    p = pr;
                } else if (pr == null) {
                    p = pl;
                } else if ((kc != null ||
                        //kc是否是一个可比较的类
                        (kc = comparableClassFor(k)) != null) &&
                        //比较k和p.key
                        (dir = compareComparables(kc, k, pk)) != 0) {
                    //k < p.key 向左移动否则向有移动
                    p = (dir < 0) ? pl : pr;
                } else if ((q = pr.find(h, k, kc)) != null) {
                    //从这里开始的条件仅当输入k == null 的时候才会进入，先检查右子树在检查左子树
                    return q;
                } else {
                    p = pl;
                }
            }while (p != null);
                return null;
        }

        /**
         * 将链表生成树 ，遍历链表获取节点，一个一个的插入到红黑树中，
         * 每次插入从根开始根据hash值寻找叶节点的位置进行插入，插入一个节点调用一次
         * @param tab
         */
        final void treeify(Node<K,V>[] tab){
            TreeNode<K,V> root = null;

        }

        /**
         * 检查x的位置的红黑树性质是否需要修复
         * @param root
         * @param x
         * @param <K>
         * @param <V>
         * @return
         */
        static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
                                                    TreeNode<K,V> x){
            return null;
        }

        /**
         * 是在插入节点的key值k和父节点的key无法比较出大小时
         * 用于比较k和pk的hash值大小
         * @param a
         * @param b
         * @return
         */
        static int tieBreakOrder(Object a,Object b){
            return 0;
        }

        final void split(HashMap<K, V> map, Node<K,V>[] tab,int index, int bit){

        }


    }






}
