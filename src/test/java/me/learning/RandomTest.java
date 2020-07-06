/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.id.UUIDHexGenerator;

import java.util.Random;
import java.util.UUID;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 06. 25.
 */
public class RandomTest {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(UUID.randomUUID().node());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
