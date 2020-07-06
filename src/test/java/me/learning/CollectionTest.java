/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.learning.bootstrap.IntegrationProperties;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 02. 27.
 */
public class CollectionTest {

    public static void main(String[] args) {

        /**
         * Test Collection partition
         */
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9, 0);

        /**
         * subList test
         */
        System.out.println("=====================================" + "서브 리스트 출력");
        list = list.subList(0, Math.min(20, list.size()));
        list.forEach(System.out::println);

        System.out.println("=====================================" + "파티션 목록 출력");

        Collections.sort(list, Comparator.comparingInt(Integer::intValue).reversed());

        List<List<Integer>> partitions = Lists.partition(list, 7);
        System.out.println("Partition Size = " + partitions.size());

        partitions.stream().forEach(System.out::println);

        /**
         * Test TreeMap
         */
        Map<Integer, String> map = Maps.newHashMap();
        map.put(1, "송대권");
        map.put(2, "이미경");
        map.put(4, "송준석");
        map.put(3, "Frost");
        map.put(8, "Daniel");
        map.put(7, "Chris");

        System.out.println("=====================================" + "Key 출력");
        map.keySet().stream().forEach(System.out::println);

        System.out.println("=====================================" + "Value 출력");
        // 정렬전
        map.values().stream().forEach(System.out::println);

        TreeMap<Integer, String> treeMap = new TreeMap<>(map);
        treeMap.entrySet().stream().sorted(Map.Entry.comparingByKey());

        System.out.println("=====================================");
        treeMap.values().stream().forEach(System.out::println);

        /**
         * Test Optional
         */
        list = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());

        System.out.println("=====================================");

        Map<Long, String> nullableMap = Maps.newHashMap();
        nullableMap.put(1L, null);

        nullableMap.forEach((K,V) -> System.out.println("==> Key = " + K + ", Value = " + V));

        /**
         * 중복 제거 테스트
         */
        System.out.println("=====================================");

        list.add(2);
        list.add(3);

        list.forEach(System.out::println);

        System.out.println(":: 중복 제거 후 ::");

        list = list.stream().distinct().collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("============ 중복 제거 테스트 ===========");

        ArrayList<Integer> totalList = new ArrayList<>();
        totalList.add(1);
        totalList.add(2);
        totalList.add(3);
        totalList.add(4);
        totalList.add(5);

        ArrayList<Integer> subList = new ArrayList<>();
        subList.add(1);
        subList.add(4);


        totalList.removeAll(subList);

        List<Integer> fullList = new ArrayList<>();
        fullList.addAll(subList);
        fullList.addAll(totalList);

        fullList.forEach(System.out::println);


        System.out.println("============= subList 테스트 ============");

        /**
         * subList 테스트
         */
        List<Integer> all = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> order = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        try {
            List<Integer> remain = all.subList(Math.min(order.size(), all.size()), all.size());
            remain.forEach(System.out::println);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============= Order 테스트 ============");

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);

        List<Person> orderList = Arrays.asList(person1, person2, person3, person4, person5);
        orderList.forEach(System.out::println);

        orderList.sort(Comparator.comparingInt(Person::getAge).reversed());
        orderList.forEach(System.out::println);

    }

    public static class Person {
        int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
