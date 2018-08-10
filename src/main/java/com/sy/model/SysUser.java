package com.sy.model;

import javax.persistence.Table;
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
@Table(name = "user")
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


}