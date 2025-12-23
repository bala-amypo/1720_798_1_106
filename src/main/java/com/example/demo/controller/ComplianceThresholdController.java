@RestController
@RequestMapping("/api/thresholds")
public class ComplianceThresholdController {

    private final ComplianceThresholdService service;

    public ComplianceThresholdController(ComplianceThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceThreshold create(@RequestBody ComplianceThreshold threshold) {
        return service.createThreshold(threshold);
    }

    @GetMapping
    public List<ComplianceThreshold> list() {
        return service.getAllThresholds();
    }

    @GetMapping("/type/{sensorType}")
    public ComplianceThreshold getBySensor(@PathVariable String sensorType) {
        return service.getThresholdBySensorType(sensorType);
    }
}
