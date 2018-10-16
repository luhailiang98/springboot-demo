package com.sy.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SysUser {

    private Integer userId;

    private Integer departmentId;

    private String userName;

    private String userPwd;

    private String userPosition;

    private String userPhone;

    private String userEmail;

    private Integer userDisplayOrder;

    private String userNote;

    private SysDepartment department;


}