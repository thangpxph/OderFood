package com.example.oderfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
   public String id;
    public String email;
    public String password;
    public String name;
    public String phone;
    public String solantoian;
    public String danhgia;

}
