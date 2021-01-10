package com.ex200518;

import com.base.util.Util;

/**
 * 1540 在既定时间做作业的学生人数
 * @author An Qi
 * @date 2020/5/18
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime{

    public static void main(String[] args) {
        int[] startTime = {9,8,7,6,5,4,3,2,1};
        int[] endTime = {10,10,10,10,10,10,10,10,10};
        int queryTime = 5;
        Util.print(busyStudent(startTime, endTime, queryTime));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // 校验
        if (startTime == null || endTime == null || startTime.length != endTime.length) {
            return 0;
        }

        // 计算
        int busyNum = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                busyNum++;
            }
        }
        return busyNum;
    }


}
