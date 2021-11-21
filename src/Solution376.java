class Solution376 {
    //
    public int wiggleMaxLength(int[] nums) {
        int max_up=0,max_down=0;
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        if(nums.length==2){
            return 2;
        }

        max_up=nums[1]>nums[0]?2:0;
        max_down=nums[1]>nums[0]?0:2;
        for(int i =2 ; i< nums.length;i++){
            if(nums[i]<nums[i-1]){
                max_down=max_down>(max_up+1)?max_down:(max_up+1);
            }
            else{
                max_up=max_up>(max_down+1)?max_up:(max_down+1);
            }
        }

        return (max_up>max_down?max_up:max_down);
    }
}