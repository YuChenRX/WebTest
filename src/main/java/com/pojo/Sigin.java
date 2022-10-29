package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sigin {
    private int tid;
    private Date tdate;
    private int qday;
    private String n1;
    private String n2;
    private String n3;
    private int uid;
}
