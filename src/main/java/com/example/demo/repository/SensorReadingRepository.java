public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    // ✅ REQUIRED
    List<SensorReading> findBySensor_Id(Long sensorId);

    // ✅ REQUIRED
    List<SensorReading> findBySensor_IdAndReadingTimeBetween(
            Long sensorId,
            LocalDateTime start,
            LocalDateTime end
    );
}
