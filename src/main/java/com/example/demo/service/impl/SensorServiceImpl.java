@Service
public class SensorServiceImpl {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    // ✅ REQUIRED
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
