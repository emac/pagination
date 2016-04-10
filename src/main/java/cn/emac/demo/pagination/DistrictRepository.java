package cn.emac.demo.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * @author Emac
 * @since 2016-04-10
 */
public interface DistrictRepository extends Repository<District, Long> {

    Page<District> findAll(Pageable pageable);
}
