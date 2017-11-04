package lv.sh.service;

import lv.sh.models.Device;
import lv.sh.repository.DeviceRepository;

public class DeviceServiceImpl implements IDeviceService {

    private DeviceRepository deviceRepository;

    @Override
    public Device addBird(Device device) {
        deviceRepository=new DeviceRepository();
        deviceRepository.insert(device);
        return null;
    }
}
