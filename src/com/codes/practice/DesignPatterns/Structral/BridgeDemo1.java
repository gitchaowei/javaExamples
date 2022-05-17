package com.codes.practice.DesignPatterns.Structral;


// Implementor
// With the Bridge Design Pattern you create 2 layers of abstraction
// In this example I'll have an abstract class representing
// different types of devices. I also have an abstract class
// that will represent different types of remote controls

// decouple the functional abstraction from the implementation
// so that the two can vary independently
public class BridgeDemo1{

    public static void main(String[] args){
        // TV Remote controller 1 is linked to TV device 1
        RemoteButton theTV1 = new TVRemoteMute(new TVDevice(1, 200));

        // TV Remote controller 2 is linked to TV device 2
        RemoteButton theTV2 = new TVRemotePause(new TVDevice(1, 200));

        // DVD Remote controller is linked to DVD device
        RemoteButton theDVD = new DVDRemote(new DVDDevice(1,14));

        // -----------------------
        System.out.println("Test TV 1 with Mute");

        theTV1.buttonFivePressed();
        theTV1.buttonSixPressed();
        theTV1.buttonNinePressed();

        System.out.println("\nTest TV 2 with Pause");

        theTV2.buttonFivePressed();
        theTV2.buttonSixPressed();
        theTV2.buttonNinePressed();
        theTV2.deviceFeedback();

        // HOMEWORK

        System.out.println("\nTest DVD");

        theDVD.buttonFivePressed();
        theDVD.buttonSixPressed();
        theDVD.buttonNinePressed();
        theDVD.buttonNinePressed();
    }
}

abstract class EntertainmentDevice {
    public int deviceState;
    public int maxSetting;
    public int volumeLevel = 0;

    public abstract void buttonFivePressed();
    public abstract void buttonSixPressed();

    public void deviceFeedback() {
        if(deviceState > maxSetting || deviceState < 0) { deviceState = 0; }
        System.out.println("On Channel " + deviceState);
    }

    public void buttonSevenPressed() {
        volumeLevel++;
        System.out.println("Volume at: " + volumeLevel);
    }

    public void buttonEightPressed() {
        volumeLevel--;
        System.out.println("Volume at: " + volumeLevel);
    }
}
// Concrete Implementor
// Here is an implementation of the EntertainmentDevice
// abstract class.
class TVDevice extends EntertainmentDevice {
    public TVDevice(int newDeviceState, int newMaxSetting){
        deviceState = newDeviceState;
        maxSetting = newMaxSetting;
    }
    public void buttonFivePressed() {
        System.out.println("Channel Down");
        deviceState--;
    }

    public void buttonSixPressed() {
        System.out.println("Channel Up");
        deviceState++;
    }

}
// Concrete Implementor

// Here is an implementation of the EntertainmentDevice
// abstract class.
class DVDDevice extends EntertainmentDevice {
    public DVDDevice(int newDeviceState, int newMaxSetting){
        super.deviceState = newDeviceState;
        super.maxSetting = newMaxSetting;
    }

    public void buttonFivePressed() {
        System.out.println("DVD Skips to Chapter");
        deviceState--;
    }

    public void buttonSixPressed() {
        System.out.println("DVD Skips to Next Chapter");
        deviceState++;
    }
}

// Abstraction
// This is an abstract class that will represent numerous
// ways to work with each device
abstract class RemoteButton{
    // A reference to a generic device using aggregation
    // controller RemoteButton abstract is bridged through this device abstract
    private EntertainmentDevice theDevice;

    public RemoteButton(EntertainmentDevice newDevice){
        theDevice = newDevice;
    }

    public void buttonFivePressed() {
        theDevice.buttonFivePressed();
    }

    public void buttonSixPressed() {
        theDevice.buttonSixPressed();
    }

    public void deviceFeedback(){
        theDevice.deviceFeedback();
    }

    public abstract void buttonNinePressed();
}
// Concrete class from RemoteButton Abstraction
class TVRemoteMute extends RemoteButton{

    public TVRemoteMute(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    public void buttonNinePressed() {
        System.out.println("TV was Muted");
    }
}
// Concrete class from RemoteButton Abstraction
class TVRemotePause extends RemoteButton{

    public TVRemotePause(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    public void buttonNinePressed() {
        System.out.println("TV was Paused");
    }
}

// Concrete class from RemoteButton Abstraction
class DVDRemote extends RemoteButton{
    private boolean play = true;

    public DVDRemote(EntertainmentDevice newDevice) {
        super(newDevice);
    }
    public void buttonNinePressed() {
        play = !play;
        System.out.println("DVD is Playing: " + play);
    }
}
