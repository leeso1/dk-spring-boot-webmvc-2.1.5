package me.learning.web.intf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;
import me.learning.domain.model.Employee;

@Data
@Builder
public final class Staff {

    @JsonProperty("id")
    private Long staffId;

    @JsonProperty("name")
    private String staffName;

    @JsonProperty("department")
    private String staffDepartment;

    public static Staff from(Employee employee) {
        return Staff.builder()
                .staffId(employee.getId())
                .staffName(employee.getName())
                .staffDepartment(employee.getDepartment())
                .build();
    }
}
