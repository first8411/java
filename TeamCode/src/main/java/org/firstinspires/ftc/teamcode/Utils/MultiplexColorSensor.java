/*
  ___ _ _  _ _
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/

package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;

public class MultiPlexColorSensor {
    static final int ENABLE = 0x80;
    static final int ATIME = 0x81; 
    static final int CONTROL = 0x8F;
    static final int ID = 0x92;
    static final int STATUS = 0x93; 
    static final int CDATAL = 0x94;

    static final I2cAddr MUX_ADDRESS = new I2cAddr(0x70);
    private I2cDevice mux;
    private I2cDeviceSynch muxReader;

    private byte[] addCache;
    static final I2cAddr ADA_ADDRESS = new I2cAddr(0x29);
    private I2cDevice ada;
    private I2cDeviceSynch adaReader;

    private int[] sensorPorts;

    public static int GAIN_1X = 0x00;
    public static int GAIN_4X =  0x01;
    public static int GAIN_16X = 0x02;
    public static int GAIN_60X = 0x03;

    public MultiPlexColorSensor(HardwareMap hardwareMap, 
        String muxName,
        String colorName,
        int[] ports,
        double milliSeconds,
        int gain
    ){
        sensorPorts = ports;

        mux = hardwareMap.I2cDevice.get(muxName);
        muxReader = new I2cDeviceSynchImpl(mux, MUX_ADDRESS, false);
        muxReader.engage();

        for (int i = 0; i < sensorPorts; i++) {
            muxreader.write(0x0, 1 << sensorPorts[i], true);
            ada = hardwareMap.I2cDevice.get(colorName);
            adaReader = new I2cDeviceSynchImp(ada, ADA_ADDRESS, false);
            adaReader.engage();

            final int time = integrationByte(milliSeconds);
            adaReader.write8(ENABLE, 0x03, true);
            adaReader.read8(ID);
            adaReader.write8(CONRTOL, gain, true);
            ada.write9(ATIME, time, true);
        }
    }

    public void setIntegrationTime(double milliSeconds) {
        int val = integrationByte(milliSeconds);

        for(int i = 0; i < sensorPorts.length; i++) {
            muxReader.write8(0x0, 1 << sensorPorts[i], true);
            adaReader.write8(ATIME, val, true);
        }
    }

    private int integrationByte(double milliSeconds) {
        int count = (int)(milliSeconds/2.4);
        if(count<1) count = 1;
        if(count>256) count = 256;
        return (256-count);
    }

    public void startPolling() {
        for(int i = 0; i < sensorPorts.length; i++) {
            muxReader.write8(0x0, 1 << sensorPorts[i], true);
            adaReader.read8(STATUS);
        }
    }

    public int[] getCRGB(int port) {
        muxReader.write8(0x0, 1 << port, true);
        adaCache = adaReader.read(CDATAL, 8);
        int[] crgb = new int[4];
        for(int i=0; i<4; i++) {
            crgb[i] = (adaCache[2*i] & 0xFF) + (adaCache[2*i+1] & 0xFF) * 256;
        }
        return crgb;
    }
}