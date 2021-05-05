package com.lin.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "protein_info")
@Entity
public class ProteinInfo {


    @Id
    @Column(name="id")
    private String id;


    @Column(name="name")
    private String name;


    /**
     * 分类
     */
    @Column(name="classification")
    private String classification;


    /**
     * 生物体
     */
    @Column(name="organism")
    private String organism;


    /**
     * 表达系统
     */
    @Column(name="expression_system")
    private String expressionSystem;


    /**
     * 发布时间
     */
    @Column(name="deposited")
    private String deposited;


    /**
     * 发布作者
     */
    @Column(name="deposition_author")
    private String depositionAuthor;


    /**
     * 氨基酸序列
     */
    @Column(name="fasta_sequence")
    private String fastaSequence;


    /**
     * 图片地址
     */
    @Column(name="image_url")
    private String imageUrl;

}
