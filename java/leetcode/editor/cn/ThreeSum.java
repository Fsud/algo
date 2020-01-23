  //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针
  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          List<List<Integer>> lists = solution.threeSum(new int[]{0,0,0});
          System.out.println(lists);
      }
      
//暴力算法，超时

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> r = new ArrayList<>();
            for (int i = 0;i< nums.length;i++){

                for(int j=i+1;j<nums.length;j++){
                    int a = nums[i] + nums[j];
                    for(int k = j+1;k<nums.length;k++){
                        boolean flag = false;
                        if(nums[k] + a == 0){
                            for (List<Integer> integers : r) {
                                integers.sort(null);
                                List<Integer> integers1 = Arrays.asList(nums[i], nums[j], nums[k]);
                                integers1.sort(null);
                                if(integers.equals(integers1)){
                                    flag = true;
                                }

                            }
                            if(!flag){
                                r.add(Arrays.asList(nums[i],nums[j],nums[k]));
                            }
                        }
                    }
                }
            }
            return r;
        }
    }


//leetcode submit region begin(Prohibit modification and deletion)
      class Solution{
          public List<List<Integer>> threeSum(int[] nums) {
              List<List<Integer>> res = new ArrayList<>();
              Arrays.sort(nums);
              for (int k = 0; k< nums.length-2;k++){
                  if(k > 0 && nums[k-1] == nums[k]){
                      continue;
                  }
                  if(nums[k] > 0){
                      break;
                  }
                  int i=k+1,j=nums.length-1;
                  while(i<j){
                      int sum = nums[k] + nums[i] + nums[j];
                      if(sum == 0){
                          res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                          int i1 = i+1;
                          while(nums[i1]==nums[i] && i1 < j){
                              i1 ++;
                          }
                          i = i1;

                          int j1 = j-1;
                          while(nums[j1] == nums[j] && j1 >i){
                              j1--;
                          }
                          j = j1;
                      }else if(sum>0){
                          int j1 = j-1;
                          while(nums[j1] == nums[j] && j1 >i){
                              j1--;
                          }
                          j = j1;
                      }else if (sum <0){
                          int i1 = i+1;
                          while(nums[i1]==nums[i] && i1 < j){
                              i1 ++;
                          }
                          i = i1;
                      }
                  }


              }
              return res;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)
//总结，果然是medium的题，技巧性和边界条件的处理是难点。排序之后，双指针，指针的移动，都是技巧。
      // k 作为循环对象，双指针一个为k+1,一个为最大数。依次判断是否满足，不满足的话，根据结果大小进行操作：
      //结果偏大，j左移；结果偏小，i右移。结果刚好，ij都移动。
      //k,j,j移动过程中需要跳过相同的值。
      //边界条件需要注意判断ij不能相等。且nums[k]>0时直接退出，因为nums[k]作为最小值，大于零的话不会有结果。
      //代码行数较多，写的啰嗦，看起来清晰些。
  }
