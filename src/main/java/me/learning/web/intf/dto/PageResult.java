
package me.learning.web.intf.dto;

import java.util.List;

import com.google.common.collect.ImmutableList;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class PageResult<T> {

    private final long total;
    private final List<T> items;

    public static <T> PageResult<T> empty() {
        return new PageResult<>(0L, ImmutableList.of());
    }

}
