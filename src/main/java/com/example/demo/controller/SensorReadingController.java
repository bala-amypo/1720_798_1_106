@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingService service;

    public SensorReadingController(SensorReadingService service) {
        this.service = service;
    }

    @PostMapping("/{sensorId}")
    public SensorReading submit(@PathVariable Long sensorId, @RequestBody SensorReading reading) {
        reading.getSensor().setId(sensorId); // associate sensor
        return service.submitReading(sensorId, reading);
    }

    @GetMapping("/{id}")
    public SensorReading get(@PathVariable Long id) {
        return service.getReading(id);
    }
}
