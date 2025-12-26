public interface LocationRepository extends JpaRepository<Location, Long> {

    // ✅ REQUIRED
    Location findByLocationName(String locationName);

    // ✅ REQUIRED
    List<Location> findByRegion(String region);
}
