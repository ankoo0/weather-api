package com.senla.weather.repository;

import com.senla.weather.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

    WeatherEntity findFirstByOrderByUpdatedAtDesc();

    @Query("""
                SELECT AVG(w.tempInCelsius)
                FROM WeatherEntity w
                WHERE w.updatedAt >= :startDate
                    AND w.updatedAt <= :endDate
            """)
    Double getAverageTemperatureBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}