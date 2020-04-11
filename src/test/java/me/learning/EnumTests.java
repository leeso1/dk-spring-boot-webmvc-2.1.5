/*
 * Copyright (c) 2019 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2019. 08. 22.
 */
@Slf4j
public class EnumTests {

    @Test
    public void groupTypeTest() {
        String code = "DUO";
        GroupType type = GroupType.forCode(code);
    }


    static enum GroupType {

        DUO("D", "듀오"),
        SOLO("S", "솔로");

        private String code;
        private String value;

        GroupType(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }

        public static GroupType forCode(String code) {
            return Enum.valueOf(GroupType.class, code);
        }
    }
}
