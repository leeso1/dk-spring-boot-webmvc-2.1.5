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
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 04. 11.
 */
@Slf4j
public class StreamTest {

    public static void main(String[] args) {

        log.info("[스트림테스트] == Distinct 테스트 ==");
        List<Integer> list = Lists.newArrayList(30408053, 420528312, 11808542, 420531791, 30408053, 420528312, 11808542, 420531791);

        List<Integer> distinctlist = list.stream()
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        log.info("[스트림테스트] == 결과 출력 ==");
        distinctlist.stream().forEach(System.out::println);


    }
}
