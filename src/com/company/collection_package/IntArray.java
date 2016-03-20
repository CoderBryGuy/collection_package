package com.company.collection_package;

/**
 * Created by Bryan on 3/18/2016.
 */
//is this being updated
public class IntArray implements Collection {
    private int[] thisArr = null;
    private int lastIndex;
    private boolean firstIntialized = false;

    public IntArray(){
        thisArr = null;
        thisArr = new int[10];
        lastIndex = 0;
    }
    public IntArray(int x){
        thisArr = null;
        thisArr = new int[x];
        lastIndex = 0;
    }
    //for (int i = 0; i < thisArr.length ; i++) {      }

    @Override
    public void add(int x){

        if(lastIndex  < thisArr.length )
            {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if(firstIntialized == false)
                {
                    thisArr[lastIndex] = x;
                    firstIntialized = true;
                }
                else {
                    thisArr[lastIndex] = x;
                    lastIndex++;
                    // System.out.println(x +"is this going nuts?");
                }
            }
        else
        {
            int newSize = thisArr.length *2;
            int[] tempArr = new int[newSize];

            for (int i = 0; i < thisArr.length ; i++) {
               tempArr[i] = thisArr[i];
                //System.out.println(tempArr[i]);
            }

           // System.out.println(lastIndex + " last index" + " x is: " + x);
            tempArr[lastIndex] = x;
            lastIndex++;
            //System.out.println(x + " new value of extended array");
            thisArr = tempArr;
            //tempArr = null;
        }


    }
    @Override
    public void add(int x, int index){
        int temp;
        if(lastIndex  < thisArr.length )
        {
            temp = thisArr[index];
            thisArr[index] = x;
            thisArr[lastIndex] = temp;

            lastIndex++;
            // System.out.println(x +"is this going nuts?");

        }
        else if(lastIndex  >= thisArr.length)
        {
            int newSize = thisArr.length * 2;
            int[] tempArr = new int[newSize];

            for (int i = 0; i < thisArr.length ; i++) {
                tempArr[i] = thisArr[i];
                //System.out.println(tempArr[i]);
            }
            thisArr = tempArr;
            // System.out.println(lastIndex + " last index" + " x is: " + x);
            temp = thisArr[index];
            thisArr[index] = x;
            thisArr[lastIndex] = temp;
            lastIndex++;
        }
    }
    @Override
    public void add(Collection collections)
    {
    if(collections == null)
            return;

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
            int newSize = (thisArr.length + size) *2;
            System.out.println("newSize "+newSize);
            int[] tempArr = new int[newSize];
            for (int i = 0; i < thisArr.length ; i++) {
                tempArr[i] = thisArr[i];
            }
            thisArr = tempArr;
            tempArr = null;

            for (int i = 0; i < size ; i++)
            {
                thisArr[lastIndex] = collections.get(i);
                lastIndex++;
                System.out.println("lastIndex "+lastIndex);
            }
        }
    }
    @Override
    public void clear(){
        //thisArr = null;
        for (int i = 0; i <thisArr.length; i++) {
            thisArr[i]=0;
        }
    }
    @Override
    public boolean contains(int x){
        boolean IsValueFound = false;
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
               IsValueFound = true;
        }
        return IsValueFound;
    }
    @Override
    public int get(int index){
        //if(index < thisArr.length)
        return thisArr[index];
    }
    //for (int i = 0; i < thisArr.length ; i++) {      }
    @Override
    public int indexOf(int x){
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
                return i;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(int x){
        int lastIndexOf = -1;
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x) lastIndexOf = i;
        }
        return lastIndexOf;
    }
    @Override
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
    @Override
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
    @Override
    public void removeAll(int x){
        for (int i = 0; i < thisArr.length ; i++) {
            if(thisArr[i] == x)
                {
                    System.out.println("remove "+x+". lastIndex "+lastIndex);
                thisArr[i] = thisArr[lastIndex];
                thisArr[lastIndex] = 0;
                lastIndex--;
                }
        }
    }
    @Override
    public int size(){
        return thisArr.length;
    }

    @Override
    public Collection subList(int fromIndex, int toIndex){
        int tempLength = toIndex - fromIndex;
        IntArray tempArr = null;
        if(toIndex <= lastIndex)
            {
                tempArr = new IntArray(tempLength);
                for (int i = fromIndex; i < toIndex+1 ; i++) {
                    tempArr.add(thisArr[i]);
                }
            return tempArr;
            }
        else return null;
        
    }
    @Override
    public int[] toArray(){
        int[] tempArr = new int[thisArr.length];
        for (int i = 0; i < thisArr.length ; i++) {
            tempArr[i] = thisArr[i];
        }
        return tempArr;
    }
    @Override
    public String toString(){
        String output = "";
        for (int i = 0; i < thisArr.length; i++) {
            output += "value: " + thisArr[i] +" index: " + i + "\n";
        }
        return output;
    }

    public int getLastIndex(){return lastIndex;}
}
