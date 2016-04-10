package cn.emac.demo.pagination;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emac
 * @since 2016-04-10
 */
@Repository
public interface DistrictRepository extends PagingAndSortingRepository<District, Long> {
}
