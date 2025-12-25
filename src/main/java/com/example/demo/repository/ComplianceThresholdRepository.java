public interface ComplianceThresholdRepository
        extends JpaRepository<ComplianceThreshold, Long> {
    Optional<ComplianceThreshold> findBySensorType(String type);
}
