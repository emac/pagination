package cn.emac.demo.pagination;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Emac
 * @since 2016-04-10
 */
@Entity
@Getter
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;
}
