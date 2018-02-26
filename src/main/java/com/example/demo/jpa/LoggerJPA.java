package com.example.demo.jpa;

import com.example.demo.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> {
}
