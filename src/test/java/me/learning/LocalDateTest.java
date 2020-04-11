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

import java.time.LocalDate;
import java.util.List;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 03. 03.
 */
public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate d0217 = LocalDate.of(2020, 2, 17);
        LocalDate d0218 = LocalDate.of(2020, 2, 18);
        LocalDate d0219 = LocalDate.of(2020, 2, 19);
        LocalDate d0220 = LocalDate.of(2020, 2, 20);
        LocalDate d0221 = LocalDate.of(2020, 2, 21);
        LocalDate d0222 = LocalDate.of(2020, 2, 22);
        LocalDate d0223 = LocalDate.of(2020, 2, 23);
        LocalDate d0224 = LocalDate.of(2020, 2, 24);
        LocalDate d0225 = LocalDate.of(2020, 2, 25);
        LocalDate d0226 = LocalDate.of(2020, 2, 26);
        LocalDate d0227 = LocalDate.of(2020, 2, 27);
        LocalDate d0228 = LocalDate.of(2020, 2, 28);
        LocalDate d0229 = LocalDate.of(2020, 2, 29);
        LocalDate d0301 = LocalDate.of(2020, 3, 1);
        LocalDate d0302 = LocalDate.of(2020, 3, 2);
        LocalDate d0303 = LocalDate.of(2020, 3, 3);

        List<LocalDate> dates = Lists.list(d0217, d0218, d0219, d0220, d0221, d0222, d0223, d0224, d0225, d0226, d0227, d0228, d0229, d0301, d0302, d0303);

        LocalDate aGroupStartDate = LocalDate.now().minusDays(7);
        LocalDate bGroupEndDate = LocalDate.now().minusDays(6);
        LocalDate bGroupStartDate = LocalDate.now().minusDays(14);

        LocalDate releaseDate = LocalDate.of(2020, 2, 25);

        System.out.println("=============   14일전    ==============");

        dates.stream()
                .filter(e -> bGroupStartDate.isBefore(e))
                .forEach(System.out::println);

        System.out.println("=============   A 그룹    ==============");

        dates.stream()
                .filter(e -> aGroupStartDate.isBefore(e))
                .forEach(System.out::println);

        System.out.println("=============   B 그룹    ==============");

        dates.stream()
                .filter(e -> e.isAfter(bGroupStartDate)
                        && e.isBefore(bGroupEndDate))
                .forEach(System.out::println);

    }
}
