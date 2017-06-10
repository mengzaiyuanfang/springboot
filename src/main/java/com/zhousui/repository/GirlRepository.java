package com.zhousui.repository;

import com.zhousui.model.GirlNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lenovo on 2017/5/28.
 */
public interface GirlRepository extends JpaRepository<GirlNew,Integer> {

    List<GirlNew> findByCupSize(String aa);
}
