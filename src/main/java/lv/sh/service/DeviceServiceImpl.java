package lv.sh.service;

import lv.sh.models.Device;
import lv.sh.repository.DeviceRepository;

public class DeviceServiceImpl implements IDeviceService {

    private DeviceRepository deviceRepository=new DeviceRepository();

    @Override
    public Device addDevice(Device device) {
        deviceRepository=new DeviceRepository();
        deviceRepository.insert(device);
        return null;
    }
}
