/*
 * Copyright (c) 2020 DREAMUS COMPANY.
 * All right reserved.
 * This software is the confidential and proprietary information of DREAMUS COMPANY.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with DREAMUS COMPANY.
 */

package me.learning;

import lombok.*;
import org.assertj.core.util.DateUtil;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 설명 :
 *
 * @author Daniel/DREAMUS COMPANY (daekwon.song@sk.com)
 * @date 2020. 04. 28.
 */
public class CollectionSortTest {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        MemberChannelTrack track1 = MemberChannelTrack.builder()
                .trackId(1000L)
                .displayOrder(1)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack track2 = MemberChannelTrack.builder()
                .trackId(1001L)
                .displayOrder(2)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack track3 = MemberChannelTrack.builder()
                .trackId(1002L)
                .displayOrder(3)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack track4 = MemberChannelTrack.builder()
                .trackId(1003L)
                .displayOrder(4)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack track5 = MemberChannelTrack.builder()
                .trackId(1004L)
                .displayOrder(5)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack newTrack2 = MemberChannelTrack.builder()
                .trackId(1002L)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack newTrack4 = MemberChannelTrack.builder()
                .trackId(1003L)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        MemberChannelTrack newTrack5 = MemberChannelTrack.builder()
                .trackId(1004L)
                .createDateTime(now)
                .updateDateTime(now)
                .build();

        List<MemberChannelTrack> oldTrackIds = Arrays.asList(track1, track2, track3, track4, track5);
        List<Long> orderedTrackIds = Arrays.asList(1004L, 1002L, 1003L, 1004L);

        Map<Long, Integer> orederdTrackIdMap = IntStream.range(0, orderedTrackIds.size())
                .boxed()
                .peek(System.out::println)
                .collect(Collectors.toMap(orderedTrackIds::get, Function.identity(), (oldOne, newOne) -> oldOne));

        oldTrackIds.sort(Comparator.comparingInt(value -> orederdTrackIdMap.getOrDefault(value.getTrackId(), Integer.MAX_VALUE)));

        int index = 1;
        for (MemberChannelTrack each : oldTrackIds) {
            each.setDisplayOrder(index++);
        }

        oldTrackIds.forEach(System.out::println);

    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class MemberChannelTrack {

        /**
         * 트랙 ID
         */
        @EqualsAndHashCode.Include
        Long trackId;

        /**
         * 트랙 정렬 순번 ( 전시 순서 )
         */
        Integer displayOrder;

        /**
         * 생성 일시
         */
        LocalDateTime createDateTime;

        /**
         * 수정 일시
         */
        LocalDateTime updateDateTime;

        public MemberChannelTrack() {
        }

        public MemberChannelTrack(Long trackId) {
            this.trackId = trackId;
        }

        public void setDisplayOrder(Integer displayOrder) {
            this.displayOrder = displayOrder;
        }
    }
}
