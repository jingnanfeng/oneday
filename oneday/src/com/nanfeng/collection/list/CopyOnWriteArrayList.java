package com.nanfeng.collection.list;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-16 17:36
 */
public class CopyOnWriteArrayList<E> implements Serializable,Cloneable{
    private static final long serialVersionUID = -7435665474528402519L;
    /**
     * 用于修改时加锁
     */
    final transient ReentrantLock lock= new ReentrantLock();
    /**
     * 真正存储元素的地方，只能通过getArray()/setArray()访问
     */
    private transient volatile Object[] array;

    final Object[] getArray() {
        return array;
    }

    final void setArray(Object[] a) {
        this.array = a;
    }
    public CopyOnWriteArrayList(){
        //对所有的array的操作都是通过setArray()和getArray()进行的
        setArray(new Object[0]);
    }
/*    public CopyOnWriteArrayList( Collection<? extends E> c){
        Object[] elements;
        if (c.getClass() == CopyOnWriteArrayList.class){
            elements = ((CopyOnWriteArrayList<?>)c).getArray();
        }else {
            elements = c.toArray();
            if (elements.getClass() != Object[].class){
                elements = Arrays.copyOf(elements,elements.length,Object[].class);
            }
        }
        setArray(elements);
    }*/
    public CopyOnWriteArrayList(E[] toCopyIn){
        setArray(Arrays.copyOf(toCopyIn,toCopyIn.length,Object[].class));
    }
    public int size(){
        return getArray().length;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    //查找元素第一次出现的位置
    private static int indexOf(Object o,Object[] elements,int index,int fence){
        if (o == null){
            for (int i = index; i < fence; i++){
                if (elements[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = index; i < fence; i++){
                if (o.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    //查询元素最后一次出现的位置
    private static int lastIndexOf(Object o, Object[] element, int index){
        if (o == null){
            for (int i = index; i >= 0; i--){
                if (element[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = index; i >= 0; i--){
                if (o.equals(element[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * 查询是否包含该元素
     */
    public boolean contains(Object o){
        Object[] elements = getArray();
        return indexOf(o,elements,0,elements.length) >= 0;
    }
    /**
     * 查询某一元素第一次出现的位置
     */
    public int indexOf(Object o){
        Object[] elements = getArray();
        return indexOf(o,elements,0,elements.length);
    }
    /**
     * 查询某一个元素在哪个位置后第一次出现的位置
     */
    public int indexOf(E e,int index){
        Object[] elements = getArray();
        return indexOf(e,elements,index,elements.length);
    }
    /**
     * 查询该该元素最后一次出现的位置
     */
    public int lastIndexOf(Object o){
        Object[] elements = getArray();
        return lastIndexOf(o,elements,elements.length - 1);
    }
    public int lastIndexOf(E e,int index){
        Object[] elements = getArray();
        return lastIndexOf(e,elements,index);
    }

    public Object clone(){
        try {
            CopyOnWriteArrayList<E> clone =
                    (CopyOnWriteArrayList<E>)super.clone();
            clone.resetLock();
            return clone;
        }catch (CloneNotSupportedException e){
            throw new InternalError();
        }
    }

    private void resetLock() {
    }

    public Object[] toArray(){
        Object[] elements = getArray();
        return Arrays.copyOf(elements,elements.length);
    }

    public <T> T[] toArray(T[] a){
        Object[] element = getArray();
        int len = element.length;
        if (a.length <= len){
            return (T[])Arrays.copyOf(element,len,a.getClass());
        }else {
            System.arraycopy(element,0,a,0,len);
            if (a.length > len){
                a[len] = null;
            }
            return a;
        }
    }
    /**
     * 添加元素(最后一位)
     */
    public boolean add(E e){
        final ReentrantLock lock = this.lock;
        //加锁
        lock.lock();
        try {
            //获取旧数据
            Object[] elemants = getArray();
            int len = elemants.length;
            //将就数据元素拷贝到新的数组中
            //新数组大小事旧数组+1
            Object[] newElements = Arrays.copyOf(elemants,len+1);
            //将元素放到最后一位
            newElements[len] = e;
            setArray(newElements);
            return true;
        }finally {
            //释放锁
            lock.unlock();
        }
    }
    /**
     * 添加找指定位置
     */
    public void add(int index, E element){
        final ReentrantLock lock  = this.lock;
        //加锁
        lock.lock();
        try {
            //获取旧数组
            Object[] elements = getArray();
            int len = elements.length;
            //检查时候下标越界
            if (index > len || index < 0){
                throw new IndexOutOfBoundsException("Index"+index+",Size"+len);
            }
            Object[] newElements;
            int numMoved = len - index;
            if (numMoved == 0){
                //如果插入的位置事最后一位
                //那么拷贝一个n+1的数组，其前n个元素与旧数组一致
                newElements = Arrays.copyOf(elements,len + 1);
            }else {
                //如果插入的位置不是最后一位
                //那么新建一个n+1的数组
                newElements = new Object[len + 1];
                System.arraycopy(elements,0,newElements,0,index);
                //将index及其之后的元素往后挪一位拷贝到新的数组中
                //正好index的位置空出来
                System.arraycopy(element,index,newElements,index+1,numMoved);
            }
            //将元素放到index出
            newElements[index] = element;
            setArray(newElements);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 添加一个元素如果这个元素不存在于集合中
     */
    public boolean addIfAbsent(E e){
        //获取元素数组，取名为快照
        Object[] snapshot = getArray();
        //检查如果元素不存在，直接返回false;
        //如果存在在调用addIfAbsent()方法添加元素
        return indexOf(e,snapshot,0,snapshot.length) >= 0 ? false:
               addIfAbsent(e,snapshot);
    }

    private boolean addIfAbsent(E e,Object[] snapshot){
        final ReentrantLock lock = this.lock;
        //加锁
        lock.lock();
        try {
            //重新获取就数组
            Object [] current = getArray();
            int len = current.length;
            //如果快照和刚刚回去的数组不一样，说明有修改
            if (snapshot != current){
                //重新检查元素是否在刚回去的数组里
                int common = Math.min(snapshot.length,len);
                for (int i = 0; i < common; i++) {
                    if (current[i] != snapshot[i] &&
                            Objects.equals(e,current[i])){
                        return false;
                    }
                }
                if (indexOf(e,current,common,len) >=0){
                    return false;
                }
            }
            //拷贝一份n+1的数组
            Object[] newElements = Arrays.copyOf(current,len+1);
            //将元素放到最后一位
            newElements[len] = e;
            setArray(newElements);
            return true;
        }finally {
            //释放锁
            lock.unlock();
        }
    }

    /**
     * 获取指定索引的元素，支持随机访问，时间复杂度为O(1)
     */
    public E get(int index){
        //获取元素不需要锁
        //直接返回index位置的元素
        //这里没用做越界检查，因为数组本身会做越界检查
        return get(getArray(),index);
    }
    private E get(Object[] a, int index){
        return (E) a[index];
    }
    /**
     * 删除元素
     */
    public E remove(int index){
        synchronized(lock){
            //获取旧的数组
            Object[] elements = getArray();
            int len = elements.length;
            E oldValue = get(elements,index);
            int numMoved = len - index - 1;
            if (numMoved == 0){
                //如果移除的是最后一位
                //那么直接拷贝一份n-1的新数组，会后一位就自动删除了
                setArray(Arrays.copyOf(elements,len - 1));
            }else {
                //如果移除的不是最后一位，那么就新建一个n-1的新数组
                Object[] newElements = new Object[len - 1];
                //将index前面的元素拷贝到新的苏数组中
                System.arraycopy(elements,0,newElements,0,index);
                //然后将index后面的元素向前诺一位
                System.arraycopy(elements,index+1,newElements,index,numMoved);
                setArray(newElements);
            }
            return oldValue;
        }
    }

}
