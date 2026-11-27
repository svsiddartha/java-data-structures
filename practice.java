import java.io.*;
import java.util.*;

public class practice {
    public static void main(String[] args){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(bufferedReader.readLine());
            int arr[] = new int[size];
            String[] str = bufferedReader.readLine().split(" ");
            for(int i=0;i<size-1;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            int key = Integer.parseInt(bufferedReader.readLine());
            practice obj = new practice();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public int second_largest(int arr[]){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int first = -1;
        int second = -1;
        for(Map.Entry<Integer,Integer> et: map.entrySet()){
            if(et.getValue() == 1){
                if(et.getKey() > first){
                    second = first;
                    first = et.getKey();
                }
            }
        }
        return second;
    }
    public int indices(int arr[]){
        int even_sum = 0;
        int odd_sum = 0;
        for(int i=0;i<arr.length;i++){
            if(i%2 == 0){
                even_sum += arr[i];
            } else {
                odd_sum += arr[i];
            }
        }
        return (int)Math.abs(even_sum - odd_sum);
    }
    public int[] rotate(int arr[],int key){
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            list.add(num);
        }
        for(int i =1 ;i <= key ;i++){
            int temp = list.remove(list.size()-1);
            list.add(0,temp);
        }
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public int max_subarray(int arr[]){
        int max = arr[0];
        int curr = arr[0];
        for(int i=1;i<arr.length;i++){
            curr = Math.max(arr[i],curr+arr[i]);
            max = Math.max(max,curr);
        }
        return max;
    }
    public int[] move_zeros(int arr[]){
        int ind = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[ind++] = arr[i];
            }
        }
        for(int i=0;i<=arr.length-ind;i++){
            arr[ind++] = 0;
        }
        return arr;
    }
    public int max_diff(int arr[]){
        int max = Integer.MIN_VALUE;
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            int sum = arr[i] - min;
            max = Math.max(sum,max);
            min = Math.min(min,arr[i]);
        }
        return max;
    }
    public int missing_number(int key,int arr[]){
        int sum = 0;
        for(int i=0;i< arr.length ;i++){
            sum = sum + arr[i];
        }
        int missing = key*(key+1)/2;
        return missing-sum;
    }
    public void found_subarray(int arr[],int target){
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum == target){
                    System.out.println(i+1 +" "+(j+1));
                    return;
                }
            }
        }
        System.out.println(-1);
    }
    public int count_subarray(int arr[],int target){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum == target){
                    count++;
                }
            }
        }
        if(count != 0){
            return count;
        }
        return -1;

    }
    public int prefixsum(int arr[],int target){
        int prefix = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : arr){
            prefix = prefix+num;
            int reemaining = prefix - target;
            if(map.containsKey(reemaining)){
                count += map.get(reemaining);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return count;
    }
    public int min_diff(int arr[]){
        int min = Integer.MAX_VALUE;
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            int sum = arr[i] - max;
            min = Math.min(sum,min);
            max = Math.max(max,arr[i]);
        }
        return min;
    }
    public int long_subarray(int arr[],int target){
        int left = 0;
        int max_count = 0;
        int sum = 0;
        for(int right = 0;right<arr.length;right++){
            sum += arr[right];
            while(sum > target && left <= right){
                sum = sum - arr[left];
                left++;
            }
            if(sum == target){
                int count = right - left+1;
                max_count = Math.max(max_count,count);

            }
        }
        return max_count;


    }
    public int zero_subarray(int arr[]){
         Map<Integer,Integer> map = new HashMap<>();
         map.put(0,1);
         int count = 0;
         int sum = 0;
         for(int num : arr){
             sum = sum+num;
             if(map.containsKey(sum)){
                 count += map.get(sum);
             }
             map.put(sum,map.getOrDefault(sum,0)+1);
         }
         return count;
    }
    public int majority_element(int arr[]){
        Map<Integer,Integer> map = new HashMap<>();
        int res = -1;
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int check = arr.length/2;
        for(Map.Entry<Integer,Integer> et: map.entrySet()){
            if(et.getValue()>check){
                res = et.getKey();
                break;
            }
        }
        return res;
    }
    public int[] Sort_array(int arr[]){
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int new_arr[] = new int[arr.length];
        int ind = 0;
        for(Map.Entry<Integer,Integer> et: map.entrySet()){
            for(int i=0;i<et.getValue();i++){
                new_arr[ind++] = et.getKey();
            }
        }
        return new_arr;
    }
}
