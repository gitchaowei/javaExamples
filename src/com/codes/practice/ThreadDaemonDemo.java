package com.codes.practice;

// Daemon thread in Java is a low-priority thread that runs in the background to perform tasks
// such as garbage collection.
// Daemon thread in Java is also a service provider thread that provides services to the user thread.
// Its life depends on the mercy of user threads i.e. when all the user threads die,
// JVM terminates this thread automatically.
//
//In simple words, we can say that it provides services to user threads for background supporting tasks.
// It has no role in life other than to serve user threads.
//
    public class ThreadDaemonDemo extends Thread{
        public ThreadDaemonDemo(String name){
            super(name);
        }
        @Override
        public void run(){
            if(Thread.currentThread().isDaemon()){//checking for daemon thread
                System.out.println(getName() + " daemon thread work");
            }
            else{
                System.out.println(getName() + " user thread work");
            }
        }
        public static void main(String[] args){
            ThreadDaemonDemo t1=new ThreadDaemonDemo("t1");//creating thread
            ThreadDaemonDemo t2=new ThreadDaemonDemo("t2");
            ThreadDaemonDemo t3=new ThreadDaemonDemo("t3");

            t1.setDaemon(true);//now t1 is daemon thread

            t1.start();//starting threads
            t2.start();
            // Setting user thread t3 to Daemon
            t3.setDaemon(true);
            t3.start();
        }
    }
