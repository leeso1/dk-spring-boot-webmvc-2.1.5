/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 03. 10.
 */
public class MultimapTest {

    public static void main(String[] args) {

        List<Test> samples = new ArrayList<>();

        String prefix = "sdk";
        List<String> list = null;

        for (int i = 0; i < 10; i++) {
            list = new ArrayList<>();

            for (int j = 0; j< 10; j++) {
                list.add(prefix+i+j);
            }
            samples.add(new Test(i, list));
        }

        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        for (Test test : samples) {
            System.out.println("====>" + test);
            multimap.putAll(test.getId(), test.list);
        }

        System.out.println("====================================");

        multimap.values().forEach(System.out::println);

    }

    @Data
    @ToString
    static class Test {
        Integer id;
        List<String> list = new ArrayList<>();

        public Test(Integer i, List<String> list) {
            this.id = i;
            this.list = list;
        }
    }
}
