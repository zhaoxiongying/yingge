package com.yingge.qa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[] {1, 2, 3});
        System.out.println(list);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        def(new ArrayDeque<Integer>(), 0, nums.length, nums, list);
        return list;

    }

    /**
     *
     * @param path  Deque<Integer> path 存放访问的路径节点
     * @param now 当前访问的节点数，用来结算
     * @param length 访问的节点总数
     * @param nums 入参数组
     * @param list 返回结果
     */
    static void def(Deque<Integer> path, int now, int length, int[] nums, List<List<Integer>> list) {
        //结算路径
        if (now == length) {
            list.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            //如果节点已经被访问，跳过
            if (path.contains(nums[i])) {
                continue;
            }
            //加入节点
            path.addLast(nums[i]);
            //回溯调用
            def(path, now + 1, length, nums, list);
            //把加入的节点删除，用于下一次循环进行其他组合的递归，
            // 若加入节点前的path=[1]  访问的节点为2 那么加入节点后的path[1,2]  为了不影响路径 path结果值[1,3],所以应当把path恢复到节点2加入之前的场景 path = [1] 当
            // 访问节点为3的时候可以生成path[1,3]
            path.removeLast();
        }
    }
}
