package com.asvin.MrFix1.Dto;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Configuration
@ToString
public class AdminDto {
     private String admin_name;
     private String admin_email;
     private String admin_pass;
     private int admin_id;
     private int admin_contact;
}
