/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import lombok.extern.slf4j.Slf4j;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 04. 18.
 */
@Slf4j
public class NumberTest {

    public static void main(String[] args) {

        int divisor = 1083 / 250;
        double doubleDivisor = 1083D / 250D;
        double carryDivisor = Math.ceil(1083/250D);

        log.info("int divisor = {}", divisor);
        log.info("double doubleDivisor = {}", doubleDivisor);
        log.info("double carryDivisor = {}", carryDivisor);


    }
}
