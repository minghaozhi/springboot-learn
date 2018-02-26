package com.example.demo.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
public interface BaseDAO<T>
        extends
        JpaRepository<T, Long>,
        JpaSpecificationExecutor<T>,
        Serializable
{

}