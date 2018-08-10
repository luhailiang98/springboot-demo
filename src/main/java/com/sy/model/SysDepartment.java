package com.sy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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