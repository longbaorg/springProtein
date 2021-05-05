package com.lin.repository;

import com.lin.entity.ProteinInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
     * 查询ById
     * @return
     */
    @Query(value = "select * from protein_info t where t.name like %?1%" , nativeQuery = true)
    public ProteinInfo findByNameLike(String name);


}
