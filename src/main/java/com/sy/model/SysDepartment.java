package com.sy.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SysDepartment {

    private Integer departmentId;

    private Integer parentDepartmentId;

    private String departmentName;

    private String departmentAttribute;

    private String departmentResponsibilities;

    private String departmentHeader;

    private String departmentPhone;

    private Integer departmentDisplayOrder;

    private String departmentNote;


}