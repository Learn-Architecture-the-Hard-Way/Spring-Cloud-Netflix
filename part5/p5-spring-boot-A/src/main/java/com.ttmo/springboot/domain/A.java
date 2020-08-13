package com.ttmo.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class A {

    Integer id;

    String a;

}
