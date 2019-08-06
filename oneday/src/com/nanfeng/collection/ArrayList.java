package com.nanfeng.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-06 21:36
 */
public class ArrayList<E> {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 空数组，如果传入的容量为0时使用
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
     * 空数组，传入容量时使用，添加第一个元素的时候会初始化为默认容量大小
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * 储存元素的数组
     * 关键字transient作用：阻止实例中那些用此关键字声明的变量持久化
     */
    transient Object[] elementData;
    /**
     * 集合中元素的个数
     */
    private int size;
            /**
             * modCount 记录ArrayList结构性变化的次数
             */
            protected transient int modCount = 0;
    /**
     * ArrayList(int inittialCapacity)构造方法
     */
    public ArrayList(int initialCapacity){
        if (initialCapacity > 0){
            //如果传入的初始化容量大于0，就新建一个数组存储元素
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            //如果传入的容量等于0，使用空数组EMPTY_ELEMENTDATA
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            //如果传入的初始化容量小于0，抛出异常
            throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
        }
    }
    public ArrayList(){
        //如果没有传入初始化容量，则使用空数组DEFAULT_EMPTY_ELEMENTDATA
        //使用这个数组实在添加第一个元素发时候会扩容到默认大小10
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    public ArrayList(Collection<? extends E> c){
        //集合转数组
        elementData = c.toArray();
        if ((size = elementData.length) != 0){
            //检查c.toArray()返回的是不是Object[]类型，如果不是，重新拷贝成Object[].class类型
            if (elementData.getClass() != Object[].class){
                elementData = Arrays.copyOf(elementData,size,Object[].class);
            }
        }else {
            //如果c的空集合，则初始化为空数组EMPTY_ELEMENTDATA
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }
    //add(E e)方法
    public boolean add(E e){
        //检查是否要扩容
        ensureCapacityInternal(size + 1);
        //吧元素添加最后一位
        elementData[size++] = e;
        return true;
    }
    //判断是否要扩容
    private void ensureCapacityInternal(int minCapacity){
        ensureExplicitCapacity(calculCapacity(elementData,minCapacity));
    }
    //扩容
    private static int calculCapacity(Object[] elementData,int minCapacity){
        //如果是空数组DEFAULTCAPACITY_EMPTY_ELEMENTDATA，就初始化为默认大小10
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            return Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        return minCapacity;
    }
    private void ensureExplicitCapacity(int minCapacity){
        modCount++;
        if (minCapacity - elementData.length > 0){
            grow(minCapacity);
        }
    }

    /**
     * 最大容量Integer的最大值
     */
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity){
        int oldCapacity = elementData.length;
        //新容器为就容器的1.5倍
        int newCapacity = oldCapacity+(oldCapacity>>1);
        //如新容器发现比需要的容器还小，则以需要的容器为准
        if (newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        //如果新容器已经超过最大容器了，则使用最大容器
        if (newCapacity - MAX_ARRAY_SIZE > 0){
            newCapacity = MAX_ARRAY_SIZE;
        }
        //以新容器拷贝出一个新数组
        elementData = Arrays.copyOf(elementData,newCapacity);
    }
    /**
     * 添加到指定位置
     */
    public void add(int index,E element){
        //检查是否越界
        rangeCheckForAdd(index);
        //检查是否需要扩容
        ensureCapacityInternal(size+1);
        //将index及其之后的元素向后移一位，这index位置就空出来了
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        //将元素插入到index的位置
        elementData[index] = element;
        //大小增一
        size++;
    }
    private void rangeCheckForAdd(int index){
        if (index > size || index <0){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * 求两个集合的并集
     */
    public boolean addAll(Collection<? extends E> c){
        //将c集合转为数组
        Object[] obj = c.toArray();
        int numNew = obj.length;
        //检查是否要扩容
        ensureCapacityInternal(size+numNew);
        //将c中的元素全部拷贝到数组的最后
        System.arraycopy(obj,0,elementData,size,numNew);
        //大小增加c的大小
        size += numNew;
        //如果c不为空就返回true,否则返回false
        return numNew != 0;
    }
    /**
     * 元素索引的方法
     */
    public E get(int index){
        //检查是狗越界
        rangeCheckForAdd(index);
        //返回数组index位置的元素
        return elementData(index);
    }

    E elementData(int index){
        return (E) elementData[index];
    }

    /**
     * 索引删除元素
     * @param index
     * @return
     */
    public E remove(int index){
        //检查是否越界
        rangeCheckForAdd(index);
        modCount++;
        //获取index位置的元素
        E oldValue = elementData(index);
        //如果不是最后一位，就将index之后的元素往前挪一位
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        //将最后一位元素删除，帮助GC
        elementData[--index] = null;
        //返回旧值
        return oldValue;
    }
    /**
     * 删除某一个元素
     */
    public boolean remove(Object o){
        if (o == null){
            //遍历整个数组，找到第一次出现的位置，将其快速删除
            for (int index = 0; index < size; index++) {
                //如果要删除的元素为null,则以null进行比较，使用==
                if (elementData[index] == null){
                    fastRemove(index);
                    return true;
                }
            }
        }else {
            //遍历整个数组，找到元素第一次出现的位置，并将其快速删除
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])){
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index){
        //在次不用判断越界的检查
        modCount++;
        //如果index不是最后一位，则将index之后的元素往前挪一位
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        //将最后一个元素删除，帮助GC
        elementData[--size] = null;
    }

    /**
     * 求两个集合的并集
     */
    public boolean retainAll(Collection<?> c){
        //集合c不能为空
        Objects.requireNonNull(c);
        //调用批量删除方法，这时complement传入true,表示删除不包含在c中的元素
        return batchRemove(c,true);
    }
    /**
     * 批量删除元素
     * complement为true表示删除c中不包含的元素
     * complement为false表示删除c中包含的元素
     */
    private boolean batchRemove(Collection<?> c, boolean complement){
        final Object[] elementData = this.elementData;
        //使用读写两个指针同时遍历数组
        //读指针每次自增1，写指针在放入元素的时候加1
        //这样不需要额外的空间，只需要在原有的数组上操作就可以了
        int r = 0, w = 0;
        boolean modified = false;
        try {
            //遍历整个数组，如果c中包含该元素，则把该元素写入到指针的位置（以complement为准）
            for (; r<size;r++){
                if (c.contains(elementData[r]) == complement){
                    elementData[w++] = elementData[r];
                }
            }
        }finally {
            //正常来说r最后等于size,除非c.contains()抛出了异常
            if (r != size){
                //如果抛出了异常，则把未读的元素拷贝到写指针之后
                System.arraycopy(elementData,r,elementData,w,size-r);
                w += size - r;
            }
            if (w != size){
                //将写指针之后的元素置为空，帮助GC
                for (int i = w; i < size; i++) {
                    elementData[i] = null;
                }
                modCount += size -w;
                //新大小等于写指针的位置（因为每一次写指针就加1，所以新大小正好等于写指针的位置）
                size = w;
                modified = true;
            }
        }
        //有修改就返回true
        return modified;
    }
    /**
     * 差集
     */
    public boolean removeAll(Collection<?> c){
        //集合不能为空
        Objects.requireNonNull(c);
        //同样调用批量删除方法，这时complement传入false,表示删除包含在c中的元素
        return batchRemove(c,false);
    }



}
