package com.company.collection_package;

/**
 * Created by Bryan on 3/18/2016.
 */
public class IntArray implements Collection {
    private int[] thisArr;
    private int lastIndex;

    IntArray(){
        thisArr = new int[10];
        lastIndex = 0;
    }
    IntArray(int x){
        thisArr = new int[x];
        lastIndex = 0;
    }
    //for (int i = 0; i < thisArr.length ; i++) {      }

    public void add(int x){
        if(lastIndex + 1 < thisArr.length )
            {
                lastIndex++;
                thisArr[lastIndex] = x;
            }
        else if(lastIndex >= thisArr.length)
        {
            int[] tempArr = new int[thisArr.length *2];
            for (int i = 0; i < thisArr.length ; i++) {
               tempArr[i] = thisArr[i];
            }

            lastIndex = thisArr.length;
            tempArr[lastIndex] = x;
            thisArr = tempArr;
            tempArr = null;
        }

    }
    public void add(int x, int index){
        int temp;

        if(lastIndex + 1 < thisArr.length )
        {

            lastIndex++;
            temp = thisArr[index];
            thisArr[index] = x;
            thisArr[lastIndex] = temp;
        }
        else if(lastIndex + 1 >= thisArr.length)
        {
            int[] tempArr = new int[thisArr.length *2];
            for (int i = 0; i < thisArr.length ; i++) {
                tempArr[i] = thisArr[i];
            }
            lastIndex = thisArr.length;
            thisArr = tempArr;
            temp = thisArr[index];
            thisArr[index] = x;
            thisArr[lastIndex] = temp;

        }
    }
    public void add(Collection collections)
    {
     int size = collections.size();
        if(lastIndex + size < thisArr.length)
        {
            for (int i = 0; i < size ; i++)
                {
                lastIndex++;
                thisArr[lastIndex] = collections.get(i);
                }
        }
        else{
            int[] tempArr = new int[thisArr.length + size *2];
            for (int i = 0; i < thisArr.length ; i++) {
                tempArr[i] = thisArr[i];
            }
            thisArr = tempArr;
            tempArr = null;

            for (int i = 0; i < size ; i++)
            {
                lastIndex++;
                thisArr[lastIndex] = collections.get(i);
            }
        }
    }

    public void clear(){
        thisArr = null;
    }
    public boolean contains(int x){
        boolean IsValueFound = false;
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
               IsValueFound = true;
        }
        return IsValueFound;
    }
    public int get(int index){
        //if(index < thisArr.length)
        return thisArr[index];
    }
    //for (int i = 0; i < thisArr.length ; i++) {      }
    public int indexOf(int x){
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
                return i;
        }
        return -1;
    }
    public int lastIndexOf(int x){
        int lastIndexOf = -1;
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x) lastIndexOf = i;
        }
        return lastIndexOf;
    }
    public boolean isEmpty(){
        if(thisArr == null)
            return true;
        else{
            for (int i = 0; i < thisArr.length ; i++) {
                if(thisArr[i] != 0 )
                    return false;
            }
        }
        return true;
    }
    public void remove(int x){
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
            {
                thisArr[i] = thisArr[lastIndex];
                thisArr[lastIndex] = 0;
                lastIndex--;
                break;
            }
        }
    }
    public void removeAll(int x){
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
                {
                thisArr[i] = thisArr[lastIndex];
                thisArr[lastIndex] = 0;
                lastIndex--;
                }
        }
    }
    public int size(){
        return thisArr.length;
    }
    public Collection subList(int fromIndex, int toIndex){
        int tempLength = toIndex - fromIndex;
        IntArray tempArr = null;
        if(toIndex <= lastIndex)
            {
                tempArr = new IntArray(tempLength);
                for (int i = fromIndex; i < toIndex+1 ; i++) {
                    tempArr.add(thisArr[i]);
                }
            }
        return tempArr;
    }
    public int[] toArray(){
        int[] tempArr = new int[thisArr.length];
        for (int i = 0; i < thisArr.length ; i++) {
            tempArr[i] = thisArr[i];
        }
        return tempArr;
    }
}
