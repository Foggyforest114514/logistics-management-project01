package com.webtest.webtest.service;

import com.alibaba.fastjson.JSONObject;
import com.webtest.webtest.dao.DeviceDao;
import com.webtest.webtest.entity.Device;
    public class DeviceService {
        public void getDeviceRecord(JSONObject param,JSONObject json) {
            DeviceDao dao=new DeviceDao();
            dao.getDeviceRecord(param,json);
        }

        public void addDeviceRecord(Device device, JSONObject json) {
            DeviceDao dao=new DeviceDao();
            dao.addDeviceRecord(device,json);
        }
    }
