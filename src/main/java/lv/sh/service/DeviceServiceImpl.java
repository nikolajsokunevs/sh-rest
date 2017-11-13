package lv.sh.service;

import lv.sh.models.Device;
import lv.sh.repository.DeviceRepository;

public class DeviceServiceImpl implements IDeviceService {

    private DeviceRepository deviceRepository=DeviceRepository.getInstance();

    @Override
    public Device addDevice(Device device) {
        deviceRepository.insert(device);
        return null;
    }

    @Override
    public Device[] getAllDevices() {
        deviceRepository.getAllDevices();
        return null;
    }
}
