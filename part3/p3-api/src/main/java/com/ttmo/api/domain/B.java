package com.ttmo.api.domain;

import lombok.AllArgsConstructor;
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
public class B {

    Integer id;

    String b;

}
