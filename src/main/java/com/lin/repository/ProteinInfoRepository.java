package com.lin.repository;

import com.lin.entity.ProteinInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProteinInfoRepository extends JpaRepository<ProteinInfo, Integer> , JpaSpecificationExecutor<ProteinInfo> {


    /**
     * 查询全部
     * @return
     */
    public List<ProteinInfo> findAll();

    /**
     * 查询ByName
     * @return
     */
    @Query(value = "select * from protein_info t where t.name like %?1%" , nativeQuery = true)
    public ProteinInfo findByNameLike(String name);

    /**
     * 查询ById
     * @return
     */
    @Query(value = "select * from protein_info t where t.id = ?1" , nativeQuery = true)
    public ProteinInfo findByProteinId(String id);


    /**
     *  新增
     * @param simpleUUID
     * @param classification
     * @param organism
     * @param expressionSystem
     * @param deposited
     * @param depositionAuthor
     * @param fastaSequence
     * @param imageUrl
     * @param name
     * @return
     */
    @Modifying
    @Query(value = "insert into " +
            "protein_info (id, classification, organism, expression_system, deposited, deposition_author, fasta_sequence, image_url, name) values" +
            "(?1,?2,?3,?4,?5,?6,?7,?8,?9)" , nativeQuery = true)
    public int addProteinInfo(
            String simpleUUID,
            String classification,
            String organism,
            String expressionSystem,
            String deposited,
            String depositionAuthor,
            String fastaSequence,
            String imageUrl,
            String name
            );


    /**
     * 修改
     * @param classification
     * @param organism
     * @param expressionSystem
     * @param deposited
     * @param depositionAuthor
     * @param fastaSequence
     * @param imageUrl
     * @param name
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update protein_info set classification = ?1," +
            " organism = ?2," +
            " expression_system = ?3," +
            " deposited =?4, " +
            "deposition_author =?5, " +
            "fasta_sequence =?6, image_url=?7, name=?8 where id = ?9" , nativeQuery = true)
    public int updateProteinInfo(
            String classification,
            String organism,
            String expressionSystem,
            String deposited,
            String depositionAuthor,
            String fastaSequence,
            String imageUrl,
            String name,
            String id
            );

    /**
     * 删除
     */
    @Modifying
    @Query(value = "delete from protein_info g where g.id = ?1" , nativeQuery = true)
    public int deleteProteinInfo(String id);


}
