public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findBySensorCode(String code);
    List<Sensor> findByLocation_Region(String region);
}
