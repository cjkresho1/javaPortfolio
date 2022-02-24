// DynamicList.java
// a partial implementation of ArrayList

public class DynamicList<Type> {
    private Type [] array;
    private int size;

    private void resize() {
        @SuppressWarnings("unchecked")
        Type [] temp = (Type[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    /** 
     * constructs a DynamicList with an initial capacity of 10
     */
    public DynamicList() {
        @SuppressWarnings("unchecked")
        Type[] genericArray = (Type[]) new Object[10];
        array = genericArray;
        size = 0;
    }
    
    /**
     * constructs a DynamicList with the given initial capacity
     * @param capacity the starting capacity of the list
     */
    public DynamicList(int capacity) {
        @SuppressWarnings("unchecked")
        Type[] genericArray = (Type[]) new Object[capacity];
        array = genericArray;
        size = 0;
    }
    
    /**
     * sets the item at the specified index to the specified item
     * @param index list location for item to be set
     * @param item item to be set
     * @throws IndexOutOfBoundsException if index is out of the scope of the array
     */
    public void set(int index, Type item) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        array[index] = item;
    }

    /**
     * adds a new item to the end of the list
     * @param item the item to be added
     */
    public void add(Type item) {
        if (size == array.length) {
            resize();
        }

        array[size] = item;
        size++;
    }
    
    /**
     * adds an element to a given position of the list
     * @param index the location the item is to be inserted at
     * @param item the object being inserted into the list
     */
    public void add(int index, Type item) {
       if (size == array.length) {
           resize();
       } 
       
       for (int i = size-1; i >= index; i--) {
            array[i + 1] = array[i];
       }

        array[index] = item;
        size++;
    }
    
    /**
     * removes an item from the list by position
     * @param index the index of the item to be removed
     */
    public void remove(int index) {
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }

        size--; 
    }
   
    /**
     * removes the first occurence of item from the list
     * @param item the value to be removed
     */
    public void remove(Type item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
        }
    }
   
    /**
     * searches the list for an item
     * @param target the item to search for
     * @return the index of the first item in the list equal to target, or -1 if not found
     */ 
    public int indexOf(Type target) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Return the last location of the item passed. Return -1 if no item found.
     * @param item item to be found
     * @return last index of the passed item, or -1 if no such item is in the list
     */
    public int lastIndexOf(Type item) {
        if (size == 0)
        {
            return -1;
        }
        
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * returns an item from the list by position
     * @param index the location of the item to return
     * @return the item stored at that index
     * @throws IndexOutOfBoundsException when the index is not valid
     */
    public Type get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException();
        } 

        return array[index];
    }

    /**
     * resets the list back to an empty one
     */
    public void clear() {
        size = 0;
    }
    
    public void trimToSize() {
        if (size != array.length)
        {
            @SuppressWarnings("unchecked")
            Type [] temp = (Type[]) new Object[size];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        
        System.out.println("Size = " + size + "\nCapacity = " + array.length);
    }

    /** 
     * gets the number of elements stored in the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }
} 

