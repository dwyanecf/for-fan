package com.fanchen.clearmind.lianjia;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int index =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[index++]=nums[i-1];
            }
        }
        nums[index++]=nums[nums.length-1];
        return index;
    }

}
