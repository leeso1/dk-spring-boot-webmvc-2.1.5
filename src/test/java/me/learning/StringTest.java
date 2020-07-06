/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.List;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 01. 21.
 */
public class StringTest {

    public static void main(String[] args) {

        String first = "abc";
        String second = "abc";
        String third = new String("abc");
        String forth = new String(first);

        System.out.println("first.equals(second)" + first.equals(second));
        System.out.println("first == second = " + first == second);
        System.out.println("first == third = " + first == third);
        System.out.println("first == forth = " + first == forth);

        System.out.println("===================== 문자열 숫자 정렬 테스트 ====================");
        List<String> unsorted = Lists.list("101", "1012", "102");
        Collections.sort(unsorted);
        unsorted.stream().forEach(System.out::println);

        System.out.println("===================== startWith 테스트 ====================");
        String s1 = "20000000";
        String s2 = "20400000";


        boolean result = s1.startsWith("200") || s2.startsWith("200");
        System.out.println("---> result = " + result);

    }
}
