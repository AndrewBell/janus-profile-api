/**
 * Created by Andrew Bell 12/29/17
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2017. See license.txt for details.
 */

package com.recursivechaos.profile.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Profile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length = 50, nullable = true)
    private String displayName;

    @Column(length = 50, nullable = true)
    private String email;

    @Column(length = 50, nullable = true)
    private String location;

    @Column(length = 50, nullable = true)
    private String title;

}
