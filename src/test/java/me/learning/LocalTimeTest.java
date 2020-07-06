/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 05. 29.
 */
public class LocalTimeTest {

    public static void main(String[] args) {

        long sec = LocalTime.of(23,59,59).until(LocalTime.MAX, ChronoUnit.SECONDS);
        System.out.println("====> " + sec);


    }
}
