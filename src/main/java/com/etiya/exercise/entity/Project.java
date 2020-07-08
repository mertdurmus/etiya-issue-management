package com.etiya.exercise.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_code", length = 400, unique = true)
    private String projectCode;

    @Column(name = "project_name")
    private String projectName;

    @JoinColumn(name = "manager_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;


}
