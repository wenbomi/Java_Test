package service;

import domain.Province;

import java.util.List;

/**
 * @ClassName ProvinceService
 * @Author Xiao Mi
 * @Date 2023/3/4 20:46
 * 简介：
 */
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
