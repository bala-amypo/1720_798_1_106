public interface SensorRepository extends JpaRepository<Sensor, Long> {

    // ✅ REQUIRED
    List<Sensor> findByLocation_Region(String region);
}
