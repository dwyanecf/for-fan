package com.fanchen.clearmind.lianjia;

//Input:  [1,2,3,4]
//Output: [24,12,8,6]
public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int temp=1;
        for(int i=0;i<nums.length;i++){
            res[i]=temp;
            temp*=nums[i];
        }
        temp=1;
        for(int i=res.length-1;i>=0;i--){
            res[i]*=temp;
            temp*=nums[i];
        }
        return res;
}

    public static void main(String[] args) {
       productExceptSelf(new int[]{
                1,2,3,4
        });
    }

}
