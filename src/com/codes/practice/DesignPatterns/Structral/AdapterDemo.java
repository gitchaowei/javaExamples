package com.codes.practice.DesignPatterns.Structral;
//
// The adapters job is to make new classes compatible with the Target Interface.
// EnemyRobotAdapter implements a common interface EnemyAttacker by wrapping
// EnemyRobotAdapter methods into interface methods.
import java.util.Random;

public class AdapterDemo{

    public static void main(String[] args){
        // implement interface EnemyAttacker
        EnemyTank rx7Tank = new EnemyTank();

        // convert EnemyRobot methods to common interface EnemyAttacker
        // by using EnemyAttacker Adaptor
        EnemyRobot fredTheRobot = new EnemyRobot();
        EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);

        System.out.println("The Enemy Tank, implementing interface EnemyAttacker:");
        rx7Tank.assignDriver("Frank");
        rx7Tank.driveForward();
        rx7Tank.fireWeapon();
        System.out.println();

        System.out.println("The Robot's original methods: ");
        fredTheRobot.reactToHuman("Paul");
        fredTheRobot.walkForward();
        fredTheRobot.smashWithHands();
        System.out.println();

        System.out.println("The Robot with Adapter by implementing interface EnemyAttacker and calling The Robot's original methods:");
        robotAdapter.assignDriver("Paul");
        robotAdapter.driveForward();
        robotAdapter.fireWeapon();
    }
}

interface EnemyAttacker {
    public void fireWeapon();
    public void driveForward();
    public void assignDriver(String driverName);
}
//
// EnemyTank implements EnemyAttacker perfectly
// Our job is to make classes with different methods
// from EnemyAttacker to work with the EnemyAttacker interface
class EnemyTank implements EnemyAttacker{
    Random generator = new Random();

    public void fireWeapon() {
        int attackDamage = generator.nextInt(10) + 1;
        System.out.println("Enemy Tank Does " + attackDamage + " Damage");
    }

    public void driveForward() {
        int movement = generator.nextInt(5) + 1;
        System.out.println("Enemy Tank moves " + movement + " spaces");
    }

    public void assignDriver(String driverName) {
        System.out.println(driverName + " is driving the tank");
    }
}

// This is the Adapter. The Adaptee sends method calls to objects that use
// the EnemyAttacker interface to the right methods defined in EnemyRobot
//
 class EnemyRobot{
    Random generator = new Random();

    public void smashWithHands() {
        int attackDamage = generator.nextInt(10) + 1;
        System.out.println("Enemy Robot Causes " + attackDamage + " Damage With Its Hands");
    }

    public void walkForward() {
        int movement = generator.nextInt(5) + 1;
        System.out.println("Enemy Robot Walks Forward " + movement + " spaces");
    }

    public void reactToHuman(String driverName) {
        System.out.println("Enemy Robot Tramps on " + driverName);
    }
}
// The Adapter must provide an alternative action for the methods that need to be used because
// EnemyAttacker was implemented.
//
// This adapter does this by containing an object of the same type as the Adaptee (EnemyRobot)
// All calls to EnemyAttacker methods are sent instead to methods used by EnemyRobot
//
class EnemyRobotAdapter implements EnemyAttacker{
    // link EnemyAttacker interface methods and EnemyRobot methods
    EnemyRobot theRobot;

    public EnemyRobotAdapter(EnemyRobot newRobot){
        theRobot = newRobot;
    }
    //interface function implementation
    // mapping to EnemyRobot
    public void fireWeapon() {
        theRobot.smashWithHands();
    }
    //interface function implementation
    // mapping to EnemyRobot
    public void driveForward() {
        theRobot.walkForward();
    }

    //interface function implementation
    // mapping to EnemyRobot
    public void assignDriver(String driverName) {
        theRobot.reactToHuman(driverName);
    }
}
