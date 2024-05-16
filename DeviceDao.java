package com.webtest.webtest.dao;

import com.alibaba.fastjson.JSONObject;
import com.webtest.webtest.entity.Device;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceDao {
    public void getDeviceRecord(JSONObject param, JSONObject json) {
        /*--------------------函数开始 传递进来的参数在param里--------------------*/
        System.out.println("[DeviceDao/getDeviceRecord]执行到这里param=null");
        /*--------------------数据库访问 开始--------------------*/
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="1234";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("[DeviceDao/getDeviceRecord]驱动加载完毕");
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("[DeviceDao/getDeviceRecord]Connection连接完毕");
        Statement statement=null;
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("[DeviceDao/getDeviceRecord]Statement创建完毕");
        String sql="select * from device_file order by device_name";
        List list=new ArrayList();
        try {
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                Map map=new HashMap();
                map.put("device_id",rs.getString("device_id"));
                map.put("device_name",rs.getString("device_name"));
                map.put("device_type",rs.getString("device_type"));
                map.put("create_time",rs.getString("create_time"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*--------------------数据库访问 结束--------------------*/
        json.put("aaData",list);
        json.put("result_code",0);
        json.put("result_msg","ok");
        /*--------------------函数结束 返回的结果存放在json里--------------------*/
    }

    public void addDeviceRecord(Device device, JSONObject json) {
        /*--------------------函数开始 传递进来的参数在param里--------------------*/
        System.out.println("[DeviceDao/addDeviceRecord]执行到这里device="+device.toString());
        /*--------------------数据库访问 开始--------------------*/
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="1234";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("[DeviceDao/addDeviceRecord]驱动加载完毕");
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("[DeviceDao/addDeviceRecord]Connection连接完毕");
        Statement statement=null;
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("[DeviceDao/addDeviceRecord]Statement创建完毕");

        String deviceId=device.getDeviceid();
        String deviceName=device.getDevicename();
        String deviceType=device.getDevicetype();
        java.util.Date date=new java.util.Date();
        String createTime=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        String sql="insert into device_file(device_id,device_name,device_type,create_time)" +
                " values('"+deviceId+"','"+deviceName+"','"+deviceType+"','"+createTime+"')";

        List list=new ArrayList();
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*--------------------数据库访问 结束--------------------*/
        json.put("aaData",list);
        json.put("result_code",0);
        json.put("result_msg","ok");
        /*--------------------函数结束 返回的结果存放在json里--------------------*/
    }
}
